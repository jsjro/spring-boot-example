# Spring Boot 3 Rest API example

## Introduction

Spring Boot 3 JSON Web Token REST API Login Example

### Available resources

The following resources are available:

#### Auth

+ ``POST /api/auth/signin`` (``JSON``) : authenticateUser
+ ``POST /api/auth/signup`` (``JSON``) : registerUser

#### Test

+ ``GET /api/test/all`` (``JSON``) : allAccess
+ ``GET /api/test/admin`` (``JSON``) : adminAcess
+ ``GET /api/test/mod`` (``JSON``) : modAccess
+ ``GET /api/test/user`` (``JSON``) : userAccess


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
-Djsjro.app.jwtCookieName=jsjro
-Djsjro.app.jwtSecret=d3c5153d-bfd3-497c-9b04-49d1935868d2-29b535bd-3dff-4b95-838d-2f8f1f9783cf

mvn spring-boot:run
```