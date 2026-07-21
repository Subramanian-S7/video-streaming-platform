package com.subramanian.videostreaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subramanian.videostreaming.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}