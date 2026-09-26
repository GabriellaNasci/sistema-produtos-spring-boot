# Product Management System — Spring Boot

REST API for product management, developed with **Java and Spring Boot** as part of an academic assignment.

## Overview

Product API is a backend application designed to manage products and their respective categories through a RESTful interface.

This project was developed as part of the Programming Language II course, with the code created throughout the classes and based on the concepts and practices taught during the course.

The project follows a layered architecture, separating domain models, business logic, data access, and HTTP communication to keep the code organized and maintainable.

## Features

- Product management
- Category management
- Product–category relationship
- RESTful endpoints
- In-memory data management

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Spring Boot | Application framework |
| Spring Web | REST API |
| Maven | Dependency management and build |

## Architecture

The application is organized into five main layers/packages:

```text
controller/
    Handles HTTP requests and responses

service/
    Contains business rules and application logic

repository/
    Handles product data storage and retrieval

model/
    Represents the application's domain entities

exception/
    Handles application-specific exceptions and error responses
```

This structure separates the main responsibilities of the application, making the codebase easier to maintain and extend.

## Domain Model

```text
Category
    │
    │ 1:N
    ▼
Product
```

A **Category** can contain multiple **Products**, while each **Product** belongs to a category.

## API Endpoints

### Products

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/products` | List all products |
| `GET` | `/products/{id}` | Find a product by ID |
| `POST` | `/products` | Create a product |
| `PUT` | `/products/{id}` | Update a product |
| `DELETE` | `/products/{id}` | Delete a product |

### Categories

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/categories` | List all categories |
| `GET` | `/categories/{id}` | Find a category by ID |
| `POST` | `/categories` | Create a category |
| `PUT` | `/categories/{id}` | Update a category |
| `DELETE` | `/categories/{id}` | Delete a category |


## Project Status

This project is currently under development.

## License

This project was developed for educational purposes.
