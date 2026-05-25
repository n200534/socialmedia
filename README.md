# 🚀 Social Media Backend API

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)
![Redis](https://img.shields.io/badge/Redis-Caching-red)
![JWT](https://img.shields.io/badge/Auth-JWT-orange)
![Docker](https://img.shields.io/badge/Containerized-Docker-blue)

A **production-style social media backend** built using **Spring Boot**, **PostgreSQL**, **Redis**, and **JWT Authentication** with focus on **clean architecture, scalability, caching, and deployment-ready infrastructure**.

Designed with **product-based company backend engineering practices** in mind.

---

# ✨ Features

## 🔐 Authentication & Security

* JWT-based stateless authentication
* BCrypt password hashing
* Secure protected APIs using Spring Security
* Registration & login APIs

---

## 👤 User Features

* User profile APIs
* Follow / Unfollow users
* Followers & following system

---

## 📝 Posts

* Create posts
* Fetch authenticated user's posts
* Fetch public user profile posts
* Paginated APIs

---

## ❤️ Likes & 💬 Comments

* Like / Unlike posts
* Comment on posts
* Duplicate like prevention
* Validation & exception handling

---

## 📰 Feed System

* Personalized following feed
* Feed pagination
* Optimized database queries
* Redis feed caching

---

## ⚡ Performance Optimizations

* Redis caching with cache invalidation
* Composite indexing
* Fetch joins to avoid N+1 problem
* Lazy loading strategy
* Pagination support

---

# 🛠 Tech Stack

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA (Hibernate)
* PostgreSQL
* Redis
* JWT
* Docker
* Swagger / OpenAPI

---

# 🧱 Architecture

```text
Controller → Service → Repository → Database
```

### Key Design Principles

* DTO-based API contracts
* Layered architecture
* Centralized exception handling
* Stateless authentication
* Separation of concerns

---

# 📘 API Endpoints

## Auth APIs

```http
POST /auth/register
POST /auth/login
```

---

## User APIs

```http
GET /users
GET /users/{id}
PUT /users/{id}
GET /users/{id}/posts
```

---

## Post APIs

```http
POST /posts
GET /posts
GET /posts/me
```

---

## Feed APIs

```http
GET /feed?page=0&size=10
```

---

## Like APIs

```http
POST /posts/{postId}/like
DELETE /posts/{postId}/like
```

---

# ⚡ Redis Caching

Implemented Redis caching using Spring Cache abstraction.

### Cached Features

* Feed responses
* User lookups

### Concepts Used

* Cache-aside pattern
* Cache invalidation
* TTL (Time To Live)

---

# 🐳 Dockerized Infrastructure

Containerized using Docker with:

* Spring Boot container
* PostgreSQL container
* Redis container

### Run Locally

```bash
docker compose up --build
```

---

# 📖 Swagger API Documentation

Interactive API documentation available at:

```text
/swagger-ui/index.html
```

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/your-username/social-media-backend.git
cd social-media-backend
```

---

## Build Application

```bash
mvn clean package
```

---

## Run Using Docker

```bash
docker compose up --build
```

---

# 🧠 Key Backend Engineering Concepts Demonstrated

* JWT Authentication
* Redis Caching
* Feed System Design
* Pagination
* Query Optimization
* N+1 Problem Prevention
* Exception Handling
* Dockerization
* REST API Design
* Spring Security

---

# 🎯 Interview Highlights

* Implemented scalable social media feed APIs with Redis caching.
* Designed secure JWT authentication and authorization flows.
* Optimized database performance using indexing and fetch joins.
* Containerized backend infrastructure using Docker.

---

# 👨‍💻 Author

**Akshay Kumar Amavarapu**
Backend Developer | Java | Spring Boot | PostgreSQL | Redis
