# Solace Atelier Inventory System

This is our CPAN-228 project for Category 1 (E-Commerce / Clothes Warehouse).  
We’re building an inventory management system for a clothing/fashion brand so it’s easier to track products, variants (size/color), and stock at different locations.

## What the system will do
- Store **products** (name, category, brand, price, active status)
- Store **product variants** (SKU, size, color, cost, reorder point)
- Track **inventory by location** (distribution centers)
- Record **inventory changes** in a log (receiving, transfers, adjustments, returns)

## Tools / Tech
- Java 17
- Spring Boot (Maven)
- Spring Web
- Thymeleaf  
- (Later) Spring Data JPA + a database (H2 or MySQL)

## How to run the project
### Requirements
- Java 17 installed (Temurin/Adoptium is what we used)
- Git

### Steps
1. Clone the repo:
   ```bash
   git clone https://github.com/trix-04/SolaceAtelier-Inventory-System.git
   cd SolaceAtelier-Inventory-System
2. Type and run this command in your systems terminal
    ```bash
    ./mvnw spring-boot:run
    ```
3. Then open 'http://localhost:8080' in your browser.
