# Complaint Management System

An AI-powered Complaint Management System built using Spring Boot, Thymeleaf, MySQL, and Bootstrap that allows users to submit complaints with optional images while automatically categorizing and assigning them to the appropriate department using AI logic.

Admins can monitor, resolve, and manage complaints through a dedicated dashboard.

---

## Features

### User Features



* Secure login system
* Submit complaints
* Upload complaint images
* AI-based complaint categorization
* Automatic department assignment
* Complaint tracking using complaint ID

### Admin Features

* Admin dashboard
* View all complaints
* Complaint statistics
* Resolve complaints
* Delete complaints
* View uploaded images

### AI Features

* Automatic complaint category detection
* Automatic department assignment

Example:

Complaint Text:
"food and ac problem"

AI Output:

Category → AC, FOOD
Department → Maintenance

---

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate

### Frontend

* Thymeleaf
* HTML
* CSS
* Bootstrap

### Database

* MySQL

### Tools

* IntelliJ IDEA
* Git
* GitHub
* Maven

---

## Application Screenshots

### Login Page

<img width="1440" height="900" alt="Screenshot 2026-03-09 at 11 49 59 PM" src="https://github.com/user-attachments/assets/3ff31c05-9b68-4180-ba37-280387f601c9" />
  
Users and admins log in from a single login page.
Default Credentials

Admin
Username: admin
Password: admin123

User
Username: user
Password: user123

---

### User Complaint Submission Page
<img width="1440" height="900" alt="Screenshot 2026-03-09 at 11 50 32 PM" src="https://github.com/user-attachments/assets/a5f7db47-944b-409d-bafb-b8a9a02526f8" />


Users can submit complaints and attach an optional image.

---

### Complaint Submission Success Page
<img width="1440" height="900" alt="Screenshot 2026-03-09 at 11 50 39 PM" src="https://github.com/user-attachments/assets/1a94f89d-493e-4069-abc7-40d5195b4af2" />


After submission, the system generates a unique complaint ID for tracking.

Example:
Complaint ID → 10
Category → AC, FOOD

---

### Admin Dashboard
<img width="1440" height="900" alt="Screenshot 2026-03-09 at 11 51 05 PM" src="https://github.com/user-attachments/assets/932f395e-d9d7-4f8a-b0aa-6ce1b18175bd" />


Admins can monitor all complaints from a centralized dashboard.

Features:

* Total complaints
* Pending complaints
* Resolved complaints
* Complaint list
* Department assignment
* Resolve / Delete actions

---

## Project Structure

complaint-management-system

controller
HomeController.java

model
Complaint.java
User.java

repository
ComplaintRepository.java
UserRepository.java

service
AIService.java

config
SecurityConfig.java

templates
login.html
index.html
success.html
admin.html
track.html

resources
application.properties

---

## Installation & Setup

### 1. Clone the Repository

git clone https://github.com/vivekbehera240/complaint-management-system.git

---

### 2. Open Project in IntelliJ

Open the folder in IntelliJ IDEA.

---

### 3. Setup MySQL Database

Create database:

CREATE DATABASE complaintdb;

---

### 4. Update application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/complaintdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---

### 5. Run the Application

Run:

ComplaintsystemApplication.java

Or using Maven:

mvn spring-boot:run

---

### 6. Open in Browser

http://localhost:8080

---

## Database Tables

Main tables used:

complaint

id - bigint
text - varchar
category - varchar
department - varchar
status - varchar
imagePath - varchar

---

## Future Improvements

Possible improvements:

* JWT authentication
* Real AI model integration
* Email notification system
* Complaint comments system
* Role-based authentication
* Mobile responsive UI improvements
* Cloud deployment

---

## Deployment Options

The project can be deployed on:

* Render
* Railway
* AWS
* Heroku
* DigitalOcean

---

## Author

Developed by

Vivek Behera 

GitHub
https://github.com/vivekbehera240

---

## Support

If you like this project:

Star the repository on GitHub
Fork the project
Contribute improvements

---

## Final Result

This system provides a complete complaint handling workflow:

User submits complaint →
AI categorizes issue →
Department auto-assigned →
Admin resolves complaint →
User tracks status
