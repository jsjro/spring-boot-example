# Spring Boot 3 Rest API example

## Introduction

Spring Boot 3 JSON Web Token REST API Login Example

### Available resources

The following resources are available:

#### Auth

+ ``POST /api/auth/signup`` (``JSON``) : signup new account
+ ``POST /api/auth/signin`` (``JSON``) : login an account
+ ``POST /api/auth/signout`` (``JSON``) : logout the account
+ ``POST /api/auth/refreshtoken`` (``JSON``) : 	generate new Access Token

#### Test

+ ``GET /api/test/all`` (``JSON``) : retrieve public content
+ ``GET /api/test/admin`` (``JSON``) : access User’s content
+ ``GET /api/test/mod`` (``JSON``) : access Moderator’s content
+ ``GET /api/test/user`` (``JSON``) : access Admin’s content

* The access Token is stored in HttpOnly Cookie

### Back-end

The back-end is using an [PostgreSQL database](https://www.postgresql.org) behind to store the user and role.

## How to build and execute it

### Requirements

+ git
+ Java 17
+ Spring Boot 3.0.2
+ Gradle 7.6

### Dependency

+ springboot-web
+ springboot-data-jpa
+ springboot-security
+ springboot-validation
+ jjwt
+ postgresql

### Run Spring Boot application

#### STEP 1. Insert data
```sql
INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_MODERATOR');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');
```

#### STEP 2. Spring Boot run
```
ADD VM Options

-Dspring.datasource.username=pgadmin
-Dspring.datasource.password=P@ssw0rd
-Djsjro.app.jwtCookieName=jsjro-jwt
-Djsjro.app.jwtRefreshCookieName=jsjro-jwt-refresh
-Djsjro.app.jwtSecret=2366HKxscwd7LZA5NldnKj7NrGMICPKYxyHKqMFlG8lplhvyB1uMcCB4sQfx6buYO2LrMnD1GO9uXX1nuDdLFsodqM9VqZMk

mvn spring-boot:run
```