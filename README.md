# 👤 User Management System (JDBC + MySQL + DAO Pattern)

A simple console-based CRUD (Create, Read, Update, Delete) application using:
- Java SE
- JDBC (with PreparedStatement)
- DAO Pattern
- MySQL database

This project demonstrates clean architecture, modular code, and good coding practices using core Java and database interaction.

---

## 🔧 Technologies Used

- Java 8+
- JDBC API
- MySQL 8.x
- MySQL Connector/J
- DAO Design Pattern
- IntelliJ / Eclipse (any IDE)
- Git & GitHub

---

## 💡 Features

- ✅ Add new user
- 📋 View all users
- 🔍 View user by ID
- ✏️ Update existing user
- ❌ Delete user
- 📦 Proper DAO structure
- ⚙️ Reusable DB connection class
- 🧼 Clean and maintainable code

---

## 🗃️ Database Setup

1. Create the database and table:

```sql
CREATE DATABASE userdb;

USE userdb;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100)
);

```
2. Update your DB credentials in DBConnection.java:
```java
String url = "jdbc:mysql://localhost:3306/userdb";
String user = "root";
String pass = "your_password";
```

## 🚀 How to Run
Clone this repository:
```
git clone https://github.com/yourusername/user-management.git
```
Open in your favorite IDE (IntelliJ / Eclipse)

Add the MySQL JDBC driver (mysql-connector-java-x.x.x.jar) to the project classpath

Run MainApp.java and use the menu to interact with the system

