package com.subramanian.videostreaming.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.subramanian.videostreaming.entity.Video;
import com.subramanian.videostreaming.service.VideoService;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins = "*")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    // Upload Video
    @PostMapping("/upload")
    public ResponseEntity<Video> uploadVideo(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file) throws IOException {

        Video video = videoService.uploadVideo(title, description, file);

        return ResponseEntity.ok(video);
    }

    // Get All Videos
    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        return ResponseEntity.ok(videoService.getAllVideos());
    }

    // Get Video By ID
    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {

        Video video = videoService.getVideoById(id);

        if (video == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(video);
    }

    // Delete Video
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable Long id) {

        return ResponseEntity.ok(videoService.deleteVideo(id));
    }

    // Stream Video (Old Method)
    @GetMapping("/play/{id}")
    public ResponseEntity<Resource> playVideo(@PathVariable Long id) throws IOException {

        Video video = videoService.getVideoById(id);

        if (video == null) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = videoService.streamVideo(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(video.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .body(resource);
    }

    // Stream Video with HTTP Range Support
    @GetMapping("/stream/{id}")
    public ResponseEntity<ByteArrayResource> streamVideo(
            @PathVariable Long id,
            @RequestHeader(value = "Range", required = false) String rangeHeader)
            throws IOException {

        return videoService.streamVideo(id, rangeHeader);
    }
}