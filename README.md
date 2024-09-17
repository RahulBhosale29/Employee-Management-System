# Employee Management System

## Overview

The **Employee Management System** is a full-stack web application that allows administrators to manage employee data such as personal details, job details, and department assignments. The back-end of the application is developed using **Spring Boot**, **Hibernate**, and **MySQL**, while the front-end is developed using **Angular 16**.

---

## Features

- **Employee Management**: Add, edit, delete, and view employee details.
- **Department Management**: Organize employees into departments.
- **Role-based Authentication**: Manage access based on roles (e.g., Admin, HR, Employee).
- **Search and Filtering**: Search and filter employees based on various attributes.
- **REST API**: RESTful APIs for CRUD operations on employees and departments.
- **Responsive Design**: User interface is responsive and works across various screen sizes.
  
---

## Technologies Used

### Front-End:
- **Angular 16**
  - TypeScript
  - Angular Router
  - Angular Forms
  - HTTP Client for API communication
  - Bootstrap 5 for styling

### Back-End:
- **Spring Boot**
  - Spring Data JPA
  - Spring Security (optional for role-based access)
  - Hibernate ORM
  - Spring MVC (for REST API)
  - Spring Boot Starter (for RESTful services)

### Database:
- **MySQL**
  - Employee and Department tables
  - Relational mapping using Hibernate

---

## Getting Started

### Prerequisites
To run this project, you will need:

- **Node.js** (for Angular)
- **MySQL Server**
- **JDK 11+** (for Spring Boot)
- **Maven** (for Spring Boot project management)
  
### Back-End Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repo/employee-management-system.git
   cd employee-management-system/backend
