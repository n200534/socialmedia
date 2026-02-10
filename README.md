

# 🚀 Social Media Backend API

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)
![JWT](https://img.shields.io/badge/Auth-JWT-orange)
![Build](https://img.shields.io/badge/Build-Maven-success)

A **production-style social media backend** built with **Spring Boot** and **PostgreSQL**, implementing **JWT authentication**, **clean architecture**, and **performance-optimized database design**.

Designed with **product-based company interview expectations** in mind.

---

## ✨ Features

* 🔐 JWT-based authentication with BCrypt password hashing
* 👤 Follow / Unfollow users (social graph)
* 📝 Create and view posts
* ❤️ Like / Unlike posts (duplicate likes prevented)
* 💬 Comment on posts
* 📰 Personalized feed (posts from followed users)
* 📄 Pagination for scalable data access

---

## 🛠 Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Data JPA (Hibernate)**
* **Spring Security + JWT**
* **PostgreSQL**
* **Maven**

---

## 🧱 Architecture

```
Controller → Service → Repository → Database
```

* DTO-based API design (Entity ≠ API response)
* Global exception handling
* Stateless authentication
* Clean separation of concerns

---

## ⚡ Performance Highlights

* Indexing on high-frequency query columns (email, foreign keys)
* Composite indexes for feed queries
* Lazy loading with fetch joins to avoid N+1 queries
* Paginated feed to handle large datasets efficiently

---

## 🔌 API Endpoints (Sample)

```
POST   /auth/login
POST   /users
POST   /posts
GET    /feed
POST   /posts/{id}/likes
POST   /posts/{id}/comments
POST   /users/{id}/follow
```

> 🔒 All endpoints (except auth & registration) require JWT authentication.

---

## ▶️ Getting Started

### Prerequisites

* Java 17+
* PostgreSQL
* Maven

### Setup

```bash
git clone https://github.com/your-username/social-media-backend.git
cd social-media-backend
```

Create database:

```sql
CREATE DATABASE social_media_db;
```

Update `application.yml` with your DB credentials.

### Run Application

```bash
mvn spring-boot:run
```

Server starts at:

```
http://localhost:8080
```

---

## 🎯 Interview Highlights

* Implemented **stateless JWT authentication**
* Designed **scalable feed logic**
* Prevented **N+1 query problems**
* Applied **database indexing strategies**
* Followed **production-grade backend practices**

---

## 👨‍💻 Author

**Akshay Kumar Amavarapu**
Backend Developer | Java | Spring Boot | PostgreSQL

---


