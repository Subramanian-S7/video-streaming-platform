package com.subramanian.videostreaming.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.subramanian.videostreaming.entity.Video;
import com.subramanian.videostreaming.service.VideoService;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    // Upload Video
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadVideo(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file) {

        try {

            if (file.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Please select a video.");
            }

            Video savedVideo = videoService.uploadVideo(title, description, file);

            return ResponseEntity.ok(savedVideo);

        } catch (IOException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    // Get All Videos
    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    // Get Video By ID
    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }

    // Delete Video
    @DeleteMapping("/{id}")
    public String deleteVideo(@PathVariable Long id) {
        return videoService.deleteVideo(id);
    }

    // Stream Video
    @GetMapping("/stream/{id}")
    public ResponseEntity<Resource> streamVideo(@PathVariable Long id) {

        try {

            Resource resource = videoService.streamVideo(id);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(resource);

        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }
}