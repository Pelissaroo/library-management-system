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

## API Endpoints

This project provides RESTful endpoints for managing books, users, and loans.

### Books

| Method | Endpoint              | Description           | Status           |
| ------ | --------------------- | --------------------- | ---------------- |
| POST   | `/book`               | Register a new book   | `201 Created`    |
| GET    | `/book`               | Retrieve all books    | `200 OK`         |
| GET    | `/book/{id}`          | Retrieve a book by ID | `200 OK`         |
| PUT    | `/book/{id}`          | Update a book         | `200 OK`         |
| PUT    | `/book/addStock/{id}` | Add stock to a book   | `200 OK`         |
| DELETE | `/book/{id}`          | Delete a book         | `204 No Content` |

### Users

| Method | Endpoint     | Description           | Status           |
| ------ | ------------ | --------------------- | ---------------- |
| POST   | `/user`      | Register a new user   | `201 Created`    |
| GET    | `/user`      | Retrieve all users    | `200 OK`         |
| GET    | `/user/{id}` | Retrieve a user by ID | `200 OK`         |
| PUT    | `/user/{id}` | Update a user         | `200 OK`         |
| DELETE | `/user/{id}` | Delete a user         | `204 No Content` |

### Loans

| Method | Endpoint            | Description            | Status        |
| ------ | ------------------- | ---------------------- | ------------- |
| POST   | `/loan`             | Register a new loan    | `201 Created` |
| GET    | `/loan`             | Retrieve all loans     | `200 OK`      |
| GET    | `/loan/{id}`        | Retrieve a loan by ID  | `200 OK`      |
| PUT    | `/loan/return/{id}` | Return a borrowed book | `200 OK`      |

### Request Format

Endpoints that create or update resources receive data in JSON format through the request body, except for `PUT /loan/return/{id}`, which requires only the loan ID in the URL.

### Running Locally

By default, the API can be accessed at:

`http://localhost:8080`

For example, to retrieve all books:

`GET http://localhost:8080/book`


