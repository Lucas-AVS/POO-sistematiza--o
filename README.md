# Employee Management System

## Description

This system manages employee information, allowing for insertion, retrieval, modification, and deletion of employee data. It uses a Swing-based graphical interface and PostgreSQL for data persistence.

## Features

- **Database Connection**: Connects to a PostgreSQL database.
- **CRUD Operations**: Create, read, update, and delete employee records.
- **Login Interfaces**: Separate login for employees and administrators.
- **Employee List**: Displays employee names in a JComboBox.
- **GUI**: User interface built with Swing.

## Project Structure

- **DatabaseHelper**: Handles database operations.
- **Employee**: Represents the employee entity.
- **EmployeeLogin**: Employee login interface.
- **AdminLogin**: Administrator login interface.
- **AdminPanel**: Admin management panel.
- **CreateUserPanel**: Panel for creating new employees.
- **ModifyUserPanel**: Panel for modifying employee data.

## Prerequisites

- Java 8 or higher
- PostgreSQL

## Database Setup

1. Install PostgreSQL.
2. Create a database named `employee_db`.
3. Create the `employees` table:

```sql
CREATE TABLE employees (
    empid SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    age INT NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(200),
    bloodType VARCHAR(3) NOT NULL,
    allergiesInfo VARCHAR(255) DEFAULT 'no allergies'
);
```
