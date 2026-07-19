# 📺 Distributed Video Streaming Platform

<p align="center">
  <h3 align="center">A Production-Ready Backend Video Streaming Platform</h3>
  <p align="center">
    Built with Java, Spring Boot, Spring Security, JWT, MySQL, Redis, Docker, AWS S3, and Microservices.
  </p>
</p>

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql)
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)

</p>

---

# 📌 Overview

The **Distributed Video Streaming Platform** is a backend-focused project built using **Java** and **Spring Boot** to simulate a production-ready video streaming service.

The primary objective of this project is to learn and implement modern backend development concepts including authentication, RESTful APIs, layered architecture, caching, cloud storage, and distributed systems.

The project is being developed incrementally by following industry best practices so that every feature reflects real-world backend engineering.

---

# ✨ Current Features

The current implementation includes:

- ✅ Spring Boot REST Application
- ✅ Layered Architecture
- ✅ User Entity
- ✅ User Repository
- ✅ User Service
- ✅ User Controller
- ✅ Login Request & Response DTOs
- ✅ Security Configuration
- ✅ JWT Utility Class
- ✅ Maven Project Structure

---

# 🚧 Upcoming Features

The following features are planned for upcoming versions:

- 🔐 JWT Authentication
- 👤 User Registration
- 🔑 Secure Login
- 🛡️ Role-Based Authorization
- 📹 Video Upload
- 🎬 Video Streaming
- 🔍 Video Search
- ⚡ Redis Caching
- ☁️ AWS S3 Storage
- 🐳 Docker
- 🏗️ Microservices
- 🌐 API Gateway
- 📚 Swagger Documentation
- 🧪 Unit Testing

---

# 🛠️ Technology Stack

| Category | Technology |
|----------|------------|
| Language | Java 21 |
| Framework | Spring Boot |
| Security | Spring Security, JWT |
| Database | MySQL |
| Build Tool | Maven |
| Version Control | Git & GitHub |
| IDE | VS Code |
| Architecture | Layered Architecture |

---

# 📂 Current Project Structure

```text
src
└── main
    └── java
        └── com.subramanian.videostreaming
            ├── config
            ├── controller
            ├── dto
            ├── entity
            ├── repository
            ├── security
            ├── service
            └── VideoStreamingPlatformApplication.java
```

---

# 🎯 Project Goal

The objective of this project is to build a scalable backend application capable of handling video upload, authentication, cloud storage, and streaming while following production-level software engineering practices.

This repository serves as a learning project to gain hands-on experience with backend development using the Spring ecosystem.

---

# 🏗️ System Architecture

```text
                  +----------------------+
                  |      Client App      |
                  +----------+-----------+
                             |
                             | HTTP / REST API
                             |
                  +----------v-----------+
                  | Spring Boot Backend  |
                  +----------+-----------+
                             |
         +-------------------+-------------------+
         |                   |                   |
         |                   |                   |
+--------v-------+  +--------v--------+  +-------v--------+
| Authentication |  | Business Logic  |  | REST APIs      |
| Spring Security|  | User Services   |  | Controllers    |
+--------+-------+  +--------+--------+  +-------+--------+
         |                   |                    |
         +-------------------+--------------------+
                             |
                     +-------v--------+
                     |     MySQL      |
                     |   User Data    |
                     +----------------+

                🚧 Future Enhancements
        Redis • AWS S3 • Docker • Microservices
```

---

# 📁 Project Structure

```text
video-streaming-platform
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.subramanian.videostreaming
│   │   │       ├── config
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── repository
│   │   │       ├── security
│   │   │       ├── service
│   │   │       └── VideoStreamingPlatformApplication.java
│   │   │
│   │   └── resources
│   │
│   └── test
│
├── pom.xml
├── README.md
└── .gitignore
```

---

# 🚀 Getting Started

## Prerequisites

Before running this project, make sure you have:

- Java 21 or later
- Maven 3.9+
- MySQL
- Git
- VS Code / IntelliJ IDEA

---

## Clone the Repository

```bash
git clone https://github.com/Subramanian-S7/video-streaming-platform.git
```

Move into the project folder.

```bash
cd video-streaming-platform
```

---

## Build the Project

```bash
mvn clean install
```

---

## Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

---

# ⚙️ Configuration

Create a MySQL database.

Example:

```text
video_streaming_db
```

Configure the database credentials inside:

```text
src/main/resources/application.properties
```

Typical configuration includes:

- Database URL
- Username
- Password
- JPA Configuration
- Server Port

---

# 🔐 Security

The project currently contains the foundation for security implementation.

Current components:

- Security Configuration
- JWT Utility
- Login DTOs

Upcoming security features include:

- JWT Authentication
- Password Encryption (BCrypt)
- Role-Based Authorization
- Refresh Tokens
- Token Validation

---

# 📡 REST API Endpoints

The following endpoints represent the planned REST API structure for the platform.

| Method | Endpoint | Description | Status |
|--------|----------|-------------|--------|
| POST | `/api/auth/register` | Register User | 🚧 Planned |
| POST | `/api/auth/login` | User Login | 🚧 Planned |
| GET | `/api/users` | Get All Users | ✅ Current |
| GET | `/api/users/{id}` | Get User by ID | 🚧 Planned |
| PUT | `/api/users/{id}` | Update User | 🚧 Planned |
| DELETE | `/api/users/{id}` | Delete User | 🚧 Planned |
| POST | `/api/videos/upload` | Upload Video | 🚧 Planned |
| GET | `/api/videos` | Get All Videos | 🚧 Planned |
| GET | `/api/videos/{id}` | Stream Video | 🚧 Planned |

---

# 🔄 Authentication Flow

```text
                User
                  │
                  ▼
            Login Request
                  │
                  ▼
        Spring Security Filter
                  │
                  ▼
         Validate Credentials
                  │
                  ▼
           Generate JWT Token
                  │
                  ▼
         Return JWT to Client
                  │
                  ▼
 Store JWT in Client Application
                  │
                  ▼
 JWT sent in Authorization Header
                  │
                  ▼
      Access Protected Endpoints
```

---

# 🗄️ Database Design

### User Table

| Column | Type |
|---------|------|
| id | BIGINT |
| username | VARCHAR |
| email | VARCHAR |
| password | VARCHAR |
| role | VARCHAR |

Future versions will include:

### Video Table

| Column | Type |
|---------|------|
| id | BIGINT |
| title | VARCHAR |
| description | TEXT |
| fileUrl | VARCHAR |
| uploadedBy | BIGINT |
| uploadDate | TIMESTAMP |

---

# 📦 Future Microservices Architecture

The application will gradually evolve into a distributed system consisting of:

- Authentication Service
- User Service
- Video Service
- API Gateway
- Service Registry (Eureka)
- Redis Cache
- AWS S3 Storage

This architecture improves scalability, maintainability, and fault tolerance.

---

# 📈 Development Progress

| Module | Status |
|---------|--------|
| Spring Boot Setup | ✅ Completed |
| User Module | ✅ Completed |
| Layered Architecture | ✅ Completed |
| DTOs | ✅ Completed |
| JWT Utility | ✅ Initial Setup |
| Authentication | 🚧 In Progress |
| Spring Security | 🚧 In Progress |
| Video Module | ⏳ Planned |
| Redis | ⏳ Planned |
| AWS S3 | ⏳ Planned |
| Docker | ⏳ Planned |
| Microservices | ⏳ Planned |

---

# 🗺️ Development Roadmap

## Phase 1 – User Management
- [x] Spring Boot Project Setup
- [x] Layered Architecture
- [x] User Entity
- [x] User Repository
- [x] User Service
- [x] User Controller
- [x] DTO Implementation

## Phase 2 – Authentication
- [ ] User Registration
- [ ] User Login
- [ ] JWT Authentication
- [ ] Spring Security
- [ ] Password Encryption (BCrypt)

## Phase 3 – Video Management
- [ ] Upload Videos
- [ ] Stream Videos
- [ ] Delete Videos
- [ ] Search Videos
- [ ] Video Metadata

## Phase 4 – Scalability
- [ ] Redis Caching
- [ ] Docker
- [ ] AWS S3 Integration
- [ ] API Documentation
- [ ] Unit Testing

## Phase 5 – Distributed Architecture
- [ ] API Gateway
- [ ] Eureka Service Registry
- [ ] Authentication Service
- [ ] Video Service
- [ ] User Service
- [ ] CI/CD Pipeline

---

# 🚀 Future Enhancements

Some planned enhancements include:

- Adaptive video streaming
- HLS support
- Video recommendations
- Thumbnail generation
- Email verification
- Password reset
- Cloud deployment
- Monitoring & logging
- Kafka event streaming
- Kubernetes deployment

---

# 🤝 Contributing

Contributions are welcome!

If you would like to improve this project:

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push your branch
5. Open a Pull Request

---

# 📄 License

This project is licensed under the **MIT License**.

---

# 👨‍💻 Author

**Subramanian S**

- 💻 Software Engineer | Backend Development
- ☕ Java | Spring Boot | MySQL
- 🌐 Passionate about building scalable backend applications

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.

It motivates further development and improvements.