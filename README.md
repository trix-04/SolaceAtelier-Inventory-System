# SOLACE ATELIER INVENTORY SYSTEM

## **Overview**
The Solace Atelier Inventory System is a web-based application built using Spring Boot and Thymeleaf. It allows users to manage inventory items through a simple and structured interface, while also supporting secure user authentication and role-based access control.

The application demonstrates full-stack development concepts including front-end templating, database integration, security and deployment using Docker.

---

## Features
- User registration and login system
- Role based access control (Admin, Staff, Customer
- Add, edit and delete inventory items
- Form validation with user-friendly error messages
- Persistent data storage usign Spring Data JPA
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
- Docker & Docker COmpose

---

## Running the Application (Development)

To run the app locally using the H2 in-memory database:

- Open terminal and type:

```bash
.\mvnw.cmd spring-boot:run

```
- Then open your browser and go to:

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

Once everything is running,open:
```bash
http://localhost:8080
```
---
## Environment Profiles
The application supports two environments:

**Development (dev)**
- Uses H2 in-memory database
- Fast and easy for local testing

**QA (qa)**
- Uses MySQL database running in Docker
- Simulates a production-like environemnt

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
- Securing configuration manages authentication and authorization

---

## Team Contributions
- Trish Figueroa - worked on UI design, inventory features and README documentation. Assisted in implementing Docker setup & MySQL database integration
- Sahib Soor - (add contribution)
- Berra Tekin - (add contribution)

---

## Notes
This project builds on previous deliverables by improving stability, adding environment configuration and preparing the application for deployment using Docker.

The goal was to create a complete and functional system that can run consistently across different environment.

---
