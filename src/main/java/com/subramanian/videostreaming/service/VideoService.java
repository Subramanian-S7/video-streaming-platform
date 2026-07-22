package com.subramanian.videostreaming.service;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.subramanian.videostreaming.entity.Video;
import com.subramanian.videostreaming.repository.VideoRepository;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    private static final String UPLOAD_DIR = "uploads";

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    // Upload Video
    public Video uploadVideo(String title,
                             String description,
                             MultipartFile file) throws IOException {

        File folder = new File(UPLOAD_DIR);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        Path filePath = Paths.get(UPLOAD_DIR, fileName);

        Files.copy(
                file.getInputStream(),
                filePath,
                StandardCopyOption.REPLACE_EXISTING);

        Video video = new Video();

        video.setTitle(title);
        video.setDescription(description);
        video.setFileName(fileName);
        video.setContentType(file.getContentType());
        video.setFileSize(file.getSize());
        video.setFilePath(filePath.toString());

        return videoRepository.save(video);
    }

    // Get All Videos
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    // Get Video By ID
    public Video getVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    // Delete Video
    public String deleteVideo(Long id) {

        if (videoRepository.existsById(id)) {
            videoRepository.deleteById(id);
            return "Video deleted successfully";
        }

        return "Video not found";
    }

    // Stream Complete Video (Old Method)
    public Resource streamVideo(Long id) throws IOException {

        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        Path path = Paths.get(video.getFilePath());

        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            throw new RuntimeException("Video file not found");
        }

        return resource;
    }

    // Stream Video with HTTP Range Support
    public ResponseEntity<ByteArrayResource> streamVideo(Long id, String rangeHeader) throws IOException {

        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        Path path = Paths.get(video.getFilePath());

        try (RandomAccessFile file = new RandomAccessFile(path.toFile(), "r")) {

            long fileSize = file.length();

            long start = 0;
            long end = fileSize - 1;

            if (rangeHeader != null && rangeHeader.startsWith("bytes=")) {

                String range = rangeHeader.substring(6);

                String[] ranges = range.split("-");

                start = Long.parseLong(ranges[0]);

                if (ranges.length > 1 && !ranges[1].isEmpty()) {
                    end = Long.parseLong(ranges[1]);
                }
            }

            long contentLength = end - start + 1;

            byte[] data = new byte[(int) contentLength];

            file.seek(start);
            file.readFully(data);

            ByteArrayResource resource = new ByteArrayResource(data);

            HttpHeaders headers = new HttpHeaders();

            headers.add(HttpHeaders.CONTENT_TYPE, video.getContentType());
            headers.add(HttpHeaders.ACCEPT_RANGES, "bytes");
            headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(contentLength));
            headers.add(HttpHeaders.CONTENT_RANGE,
                    "bytes " + start + "-" + end + "/" + fileSize);

            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                    .headers(headers)
                    .contentType(MediaType.parseMediaType(video.getContentType()))
                    .body(resource);
        }
    }
}