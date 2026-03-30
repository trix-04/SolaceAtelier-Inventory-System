# **SOLACE ATELIER | WAREHOUSEOS**

Inventory management system for a clothing brand. This version integrates full security layers and high-performance server-side data management.

## **TECH STACK**

- **Java 17 / Spring Boot 3.5.13**
- **Spring Security**: BCrypt password encoding and role-based access.
- **Spring Data JPA**: H2 in-memory database with server-side pagination.
- **Thymeleaf**: Dynamic rendering with Security dialect integration.
- **Bootstrap 5**: Responsive and professional UI styling.

---

## **DELIVERABLES FULFILLED**

### **DELIVERABLE 1: DATA & PRESENTATION**

- **Server-Side Pagination/Sorting**: Utilizes `Pageable` to handle data efficiently at the database level.
- **Automated Data Seeding**: Initial records are auto-loaded via `data.sql` for immediate testing upon startup.
- **Input Validation**: Strict rejection of invalid data (e.g., negative stock, empty names) with dynamic UI feedback.

### **DELIVERABLE 2: SECURITY & USER MANAGEMENT**

- **BCrypt Encryption**: Zero plain-text password storage.
- **Role-Based Access Control (RBAC)**: Defined roles (**Admin**, **Staff**, **Customer**) dynamically restrict application capabilities.
- **Administrative Interface**: Dedicated tools for editing and deleting warehouse entities, strictly role-gated.
- **Identity Persistence**: Logged-in user identity and assigned roles are visible globally in the navbar.

---

## **ACCESS CREDENTIALS**

| ROLE         | USERNAME   | PASSWORD      | PERMISSIONS               |
| :----------- | :--------- | :------------ | :------------------------ |
| **Admin**    | `admin`    | `admin123`    | Full Access (Edit/Delete) |
| **Staff**    | `staff`    | `staff123`    | View & Add Inventory      |
| **Customer** | `customer` | `customer123` | Read-only Inventory       |

---

## **SETUP & EXECUTION**

1.  **Clone**: `git clone https://github.com/trix-04/SolaceAtelier-Inventory-System.git`
2.  **Build**: `./mvnw clean install`
3.  **Run**: `./mvnw spring-boot:run`
4.  **Access**: `http://localhost:8080`

---
