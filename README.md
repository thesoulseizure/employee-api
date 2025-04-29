# Employee API Project

This project is a Spring Boot application that provides a RESTful API for managing employee data using Spring Data MongoDB and Thymeleaf for rendering views.

## Overview

The application allows users to:
1. Display a form on the landing page (`/`) to input employee details such as Employee ID, Employee Name, Employee Email, and Location, which are then saved to a MongoDB database upon submission.
2. View a list of all employees at the `/displayAll` endpoint.
3. View details of a specific employee by their ID at the `/display/{id}` endpoint.
4. All functionalities are exposed as RESTful URLs and documented using Swagger UI.

## Technologies Used
- **Spring Boot**: Framework for building the application.
- **Spring Data MongoDB**: For interacting with MongoDB database.
- **Thymeleaf**: For rendering HTML views.
- **Swagger (Springdoc OpenAPI)**: For API documentation.
- **Maven**: For dependency management.

## Prerequisites
- Java 17
- Maven
- MongoDB (running locally or accessible remotely)

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd employee-api
   ```

2. **Configure MongoDB**:
    - Ensure MongoDB is running on your local machine (default: `mongodb://localhost:27017`).
    - The application will automatically create a database named `employee_db` (or you can configure it in `application.properties`).

3. **Build and Run the Application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the Application**:
    - Open a browser and navigate to `http://localhost:8080/` to access the employee form.
    - Visit `http://localhost:8080/displayAll` to view all employees.
    - Use `http://localhost:8080/display/{id}` to view a specific employee by ID.
    - Access Swagger UI at `http://localhost:8080/swagger-ui.html` to explore the API documentation.

## API Endpoints
- `GET /`: Displays the form to add a new employee.
- `POST /saveEmployee`: Saves a new employee to the database.
- `GET /displayAll`: Displays a list of all employees.
- `GET /display/{id}`: Displays details of an employee by their ID.

## Submission Instructions
To submit your work for Code 5:
- Push your project files to GitHub.
- Attach a screenshot of your Swagger API endpoints in the submission.