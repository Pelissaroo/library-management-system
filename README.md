# library-management-system
A console-based library management system developed in Java to practice Object-Oriented Programming (OOP), software architecture, and business rule implementation.

## Getting Started

Clone the repository:

```bash
git clone https://github.com/Pelissaroo/library-management-system
```

This project uses MySQL via Docker. With Docker installed, start the database:

```bash
docker-compose up -d
```

Compile and run the project using your preferred Java IDE (IntelliJ IDEA, Eclipse or VS Code). Dependencies are managed via Maven (see `pom.xml`).

## Features

- Register books
- Register users
- Register book loans
- Edit books
- Edit users
- List books
- List users
- List active loans
- Interactive console menu
- Automatic ID generation
- Input validation
- Exception handling
- Remove books on data Base
- Book stock management

## Next Features

- Complete JDBC migration for User and Loan repositories

## Technologies

- Java
- MySQL
- JDBC
- Docker
- Maven
- Object-Oriented Programming (OOP)
- Layered Architecture

## Project Structure
```
src
├── App
├── conn
├── Domain
├── Exception
├── Repository
├── Service
└── Main
```

## Current Data Storage

- MySQL (via Docker) — migration in progress
    - **Book**: fully migrated to JDBC (create, read, update, delete)
    - **User**: still in-memory (ArrayList)
    - **Loan**: still in-memory (ArrayList)

## Project Status

🚧 In development