package com.subramanian.videostreaming.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

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

    public Video uploadVideo(String title,
                             String description,
                             MultipartFile file) throws IOException {

        File folder = new File(UPLOAD_DIR);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        Path filePath = Paths.get(UPLOAD_DIR, fileName);

        Files.copy(file.getInputStream(),
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

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    public String deleteVideo(Long id) {

        if (videoRepository.existsById(id)) {
            videoRepository.deleteById(id);
            return "Video deleted successfully";
        }

        return "Video not found";
    }
}