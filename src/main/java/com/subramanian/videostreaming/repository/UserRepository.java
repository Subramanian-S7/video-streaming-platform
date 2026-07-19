package com.subramanian.videostreaming.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subramanian.videostreaming.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}