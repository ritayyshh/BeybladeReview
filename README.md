# BeybladeReview

A **RESTful backend application** built with **Java, Spring Boot, Hibernate, Lombok, and PostgreSQL** for managing and reviewing Beyblades. The project demonstrates clean layered architecture, API-driven development, and server-side pagination for scalable data handling.

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Setup & Installation](#setup--installation)

## Features
- CRUD operations for Beyblades:
  - Create, Read, Update, Delete
- CRUD operations for Reviews
- Layered architecture: Controllers → Services → Repositories
- DTO-based request/response handling
- Server-side pagination for listing Beyblades and reviews
- Lombok annotations to reduce boilerplate code
- Validation and structured API responses

## Tech Stack
- **Language:** Java v25  
- **Framework:** Spring Boot  
- **Persistence:** Spring Data JPA with Hibernate ORM  
- **Database:** PostgreSQL  
- **Libraries/Tools:** Lombok, Maven, Postman (for API testing)  

## Setup & Installation

1. **Clone the repository**

git clone https://github.com/ritayyshh/BeybladeReview.git
cd BeybladeReview

2. **Configure PostgreSQL**

Create a database named beyblade_db

Update application.properties with your database credentials

spring.datasource.url=jdbc:postgresql://localhost:5432/beyblade_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update

3. **Build & Run**

mvn clean install
mvn spring-boot:run
