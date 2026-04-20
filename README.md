# SOLACE ATELIER INVENTORY SYSTEM

## **Overview**
The Solace Atelier Inventory System is a web-based application built using Spring Boot and Thymeleaf. It allows users to manage inventory items through a simple and structured interface, while also supporting secure user authentication and role-based access control.

The application demonstrates full-stack development concepts including front-end templating, database integration, security and deployment using Docker.

---

## Features
- User registration and login system
- Role based access control (Admin, Staff, Customer)
- Add, edit and delete inventory items
- Form validation with user-friendly error messages
- Persistent data storage using Spring Data JPA
- Responsive UI using Bootstrap
- Secure password handling with BCrypt
- Environment-based configuration (H2 for development, MySQL for QA)
- Docker support for running the full application stack

---

## Technologies Used
- Java 17
- Spring Boot 3.5.13
- Spring Security (BCrypt password encoding and role-based access)
- Spring Data JPA (database interaction and persistence)
- Thymeleaf (dynamic HTML rendering)
- Bootstrap 5 (responsive UI design)
- H2 Database (development)
- MySQL (QA environment via Docker)
- Docker & Docker Compose

---

## Running the Application (Development)

To run the app locally using the H2 file-based database:

- Open the terminal and type:

```bash
.\mvnw.cmd spring-boot:run

```
- Then open your browser and type:

```bash
http://localhost:8080

```

## Running the Application with Docker (QA Environment)
Make sure Docker is first installed and running on your machine.

From the root of the project, run:

```bash
docker-compose up --build
```
This will start:
- The Spring Boot application
- A MySQL database container

Once everything is running, open:
```bash
http://localhost:8080
```
Then login using demo accounts (see below).
---
## Environment Profiles
The application supports two environments:

**Development (dev)**
- Uses H2 database for local development
- Fast and easy for testing

**QA (qa)**
- Uses MySQL database running in Docker
- Simulates a production-like environment

To switch profiles manually:
```bash
-Dspring.profiles.active=qa
```

---

## **Demo Accounts**

You can log in using the following accounts:

| ROLE         | USERNAME   | PASSWORD      | PERMISSIONS               |
| :----------- | :--------- | :------------ | :------------------------ |
| **Admin**    | `admin`    | `admin123`    | Full Access (Edit/Delete) |
| **Staff**    | `staff`    | `staff123`    | View & Add Inventory      |
| **Customer** | `customer` | `customer123` | Read-only Inventory       |

---

## **Project Structure**
- Controllers handle routing and user requests
- Services contain business logic
- Repositories manage database interaction
- Templates (Thymeleaf) handle UI rendering
- Security configuration manages authentication and authorization

---

## Team Contributions
- Trish Figueroa - worked on UI/UX design, inventory features, improving user interaction and README documentation. Assisted in testing Docker setup & MySQL database integration.
- Sahib Soor - Implemented Docker integration, including Dockerfile, docker-compose configuration and MySQL set up for the QA environment. Also contributed to core application development and feature implementation from previous deliverables.
- Berra Tekin - Contributed to earlier stages in the project, in accordance to previous deliverables.

---

## Notes
This project builds on previous deliverables by improving stability, adding environment configuration and preparing the application for deployment using Docker.

The goal was to create a complete and functional system that can run consistently across different environments.

---
