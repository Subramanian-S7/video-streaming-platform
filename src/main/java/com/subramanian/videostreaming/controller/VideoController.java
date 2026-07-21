package com.subramanian.videostreaming.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
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

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadVideo(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file) {

        try {

            System.out.println("Upload API reached");

            if (file.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Please select a video file.");
            }

            Video savedVideo = videoService.uploadVideo(title, description, file);

            return ResponseEntity.ok(savedVideo);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload failed: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteVideo(@PathVariable Long id) {
        return videoService.deleteVideo(id);
    }
}