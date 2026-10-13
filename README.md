# Library Management System

A library management system developed in Java to practice Object-Oriented Programming (OOP), layered architecture, database integration, and business rule implementation. The project is being migrated from a console-based application to a REST API using Spring Boot.

## Getting Started

Clone the repository:

```bash
git clone https://github.com/Pelissaroo/library-management-system.git
```

Start the MySQL database using Docker Compose:

```bash
docker-compose up -d
```

Open the project in your preferred Java IDE and run it using Maven. Make sure Java and Docker are installed and that the database configuration is set correctly.

## Features

* Book management (CRUD)
* User management (CRUD)
* Book loan registration
* Loan listing and search by ID
* Book stock management
* Loan returns
* Automatic ID generation
* Business rule validation
* Custom exception handling
* REST API development with Spring Boot
* Request validation using Bean Validation
* Database integration with MySQL

## Technologies

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Docker
* Maven
* DBeaver
* Object-Oriented Programming (OOP)
* Layered Architecture

## Project Structure

```text
src
└── main
    ├── java
    │   └── br/com/pelissaro/librarySystem
    │       ├── controller
    │       ├── domain
    │       ├── exception
    │       ├── repository
    │       ├── service
    │       └── LibraryManagementSystemApplication.java
    └── resources
        └── application.properties
```

## Database

* MySQL running in Docker
* Database persistence using Spring Data JPA
* Entity mapping with Hibernate

## Project Status

✅ Completed — developed as a learning project to practice Java, Object-Oriented Programming, database integration, and REST API development with Spring Boot.

