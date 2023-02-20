# Spring Boot 3 Rest API example

## Introduction

Spring Boot 3 CRUD REST API Example

### Available resources

The following resources are available:

+ ``GET /api/posts`` (``JSON``) : getAllPosts
+ ``GET /api/posts/:id`` (``JSON``) : getPostById
+ ``POST /api/posts`` : createPost
+ ``PUT /api/posts/:id`` : updatePost
+ ``DELETE /api/posts/:id`` : deletePost
+ ``DELETE /api/posts`` : deleteAllPosts
+ ``GET /api/posts/status`` (``JSON``) : findByStatus

### Back-end

The back-end is using an [H2 database](https://www.h2database.com/) behind to store the post.

## How to build and execute it

### Requirements

+ git
+ Java 17
+ Spring Boot 3.0.2
+ Gradle 7.6

### Dependency

+ springboot-web
+ springboot-data-jpa
+ h2

### Run Spring Boot application

```
mvn spring-boot:run
```

### To connect to Swagger UI

```
http://localhost:8080/swagger-ui.html
```