# Spring Boot Registration and Login System

## Description
This is a Spring Boot web application that implements a complete user registration and login system using:

- Spring MVC
- Spring Security
- Spring Data JPA
- MySQL
- Thymeleaf
- Bootstrap 5

---

## Technologies Used
- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- MySQL
- Thymeleaf
- Bootstrap 5

---

## Features
- User Registration with validation
- Password encryption using BCrypt
- Login authentication with Spring Security
- Secure logout

---

## Project Structure
controller  -   Handles HTTP requests  
service   - Business logic  
repository  -   Database access (JPA)  
entity  -   Database models  
dto -   Data transfer objects  
security    -   Authentication logic  
config  -   Security configuration  
templates   -   Thymeleaf HTML pages

---

## How to Clone from GitHub

you can clone it to your local machine:

- Open a terminal or Git Bash
- Navigate to the folder where you want to clone the project
- Run the clone command (replace <repo-url> with your GitHub repository URL):
- git clone <repo-url>
- Navigate into the cloned folder:
- cd <project-folder-name>
- Open the project in your IDE  IntelliJ
- Configure the database connection in application.properties (see Database Configuration)

---
## Database Setup

Run this in MySQL:

```sql
CREATE DATABASE login_system;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/login_system
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
```


### Add this dependency to pom.xml
```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
---

## Run the Application

1. Open project in IntelliJ or any IDE
2. Run the main Spring Boot class
3. Open browser:

```
http://localhost:8080
```
---
