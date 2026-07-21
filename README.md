# 🎬 Distributed Video Streaming Platform

<p align="center">
A secure backend video streaming platform built using <strong>Java</strong>, <strong>Spring Boot</strong>, and <strong>Spring Security</strong>.
</p>

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring_Security-Enabled-success?style=for-the-badge)
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)

</p>

---

# 📌 Overview

Distributed Video Streaming Platform is a backend application that enables secure user authentication, video upload, metadata management, and video streaming through RESTful APIs.

The project follows a layered architecture and modern backend development practices using Spring Boot and Spring Security.

---

# 🚀 Features

- ✅ User Registration
- ✅ User Login
- ✅ JWT Authentication & Authorization
- ✅ BCrypt Password Encryption
- ✅ Spring Security
- ✅ Secure REST APIs
- ✅ Video Upload
- ✅ Video Metadata Management
- ✅ Video Streaming Endpoint
- ✅ MySQL Database Integration
- ✅ Layered Architecture

---

# 🛠 Tech Stack

| Category | Technology |
|-----------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3 |
| Security | Spring Security, JWT |
| Database | MySQL |
| ORM | Spring Data JPA |
| Build Tool | Maven |
| API Testing | Postman |
| Version Control | Git & GitHub |

---

# 🏗 Architecture

```text
                Client
                   │
         HTTP / REST API
                   │
        Spring Boot Backend
                   │
     ┌─────────────┼─────────────┐
     │             │             │
Authentication   Video Module   Database
     │             │             │
 Spring Security  Upload/Stream  MySQL
```

---

# 📂 Project Structure

```text
src
└── main
    ├── java
    │   └── com.subramanian.videostreaming
    │       ├── config
    │       ├── controller
    │       ├── dto
    │       ├── entity
    │       ├── repository
    │       ├── security
    │       ├── service
    │       └── VideoStreamingPlatformApplication.java
    │
    └── resources
```

---

# 📡 REST API Endpoints

## Authentication

| Method | Endpoint |
|---------|----------|
| POST | `/api/users/register` |
| POST | `/api/users/login` |

## Videos

| Method | Endpoint |
|---------|----------|
| POST | `/api/videos/upload` |
| GET | `/api/videos` |
| GET | `/api/videos/{id}` |
| GET | `/api/videos/stream/{id}` |
| DELETE | `/api/videos/{id}` |

---

# 🔐 Security

- Spring Security
- JWT Authentication
- Stateless Session Management
- BCrypt Password Encoding
- Protected REST APIs

---

# 🗄 Database

## User

| Column | Type |
|---------|------|
| id | BIGINT |
| username | VARCHAR |
| email | VARCHAR |
| password | VARCHAR |

---

## Video

| Column | Type |
|---------|------|
| id | BIGINT |
| title | VARCHAR |
| description | TEXT |
| filePath | VARCHAR |
| uploadDate | TIMESTAMP |

---

# 🚀 Getting Started

## Prerequisites

- Java 21
- Maven
- MySQL
- Git

---

## Clone Repository

```bash
git clone https://github.com/Subramanian-S7/video-streaming-platform.git
```

---

## Configure Database

Update the database credentials in:

```text
src/main/resources/application.properties
```

---

## Run

```bash
mvn spring-boot:run
```

Application runs on

```
http://localhost:8080
```

---

# 📸 Screenshots

Screenshots will be added for:

- User Registration
- User Login
- Video Upload
- Video Streaming
- MySQL Database

---

# 🚀 Future Enhancements

- HTTP Range Video Streaming
- Swagger Documentation
- Redis Caching
- AWS S3 Storage
- Docker Support
- Microservices Architecture
- API Gateway
- Kafka Integration

---

# 👨‍💻 Author

**Subramanian S**

- Java Backend Developer
- Spring Boot Developer
- Passionate about Backend Development

---

# ⭐ Support

If you found this project helpful, consider giving it a ⭐ on GitHub.