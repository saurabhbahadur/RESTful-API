<h1 align="center">🚀 RESTful-API</h1>
<p align="center">(A Clean RESTful API using Java Spring Boot)</p>

---

## 🛠️ Project Overview

This project demonstrates a basic RESTful API using **Java Spring Boot**, featuring:

- 🧑‍💻 User Authentication (Register/Login)
- 📝 Blog Creation, Editing, and Deletion
- ✅ JWT-based Secure Middleware
- 📁 Clean Layered Architecture (Controller, Service, Repository)

---

## 📂 Folder Structure

```
📦 RESTful-API
├── src/
│ └── main/
│ └── java/
│ ├── configuration/
│ ├── controller/
│ ├── dto/
│ ├── exceptions/
│ ├── models/
│ ├── repository/
│ ├── security/
│ └── service/
├── application.properties
├── pom.xml
└── README.md

```


---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/saurabhbahadur/RESTful-API.git

```


### 2️⃣ Open in your IDE (IntelliJ/VS Code)
### 3️⃣ Configure your database credentials in `application.properties:`

```properties

spring.application.name=backend-springBoot

server.port=6969

spring.datasource.url=jdbc:postgresql://localhost:5432/blog-db
spring.datasource.username=postgres
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update

security.jwt.secret-key=mysecretkeywhichhelpsintogeneratetokenwithjwt
security.jwt.expiration-time=3600000


```

### 4️⃣ Run the App

```bash

./mvnw spring-boot:run

or by play button

```
### 🔐 Authentication Filter (JWT)

```java

// code snippet

```

### 👤 UserService - Register & Login

```java

// code snippet

```

### ✍️ BlogService - Create, Edit, Delete

```java

// code snippet

```

### 📬 API Endpoints

| Method | Endpoint                 | Description          |
| ------ | ------------------------ | -------------------- |
| POST   | `/api/users/register`    | Register user        |
| POST   | `/api/users/login`       | Login user (get JWT) |
| POST   | `/api/blogs/create`      | Create a blog post   |
| PUT    | `/api/blogs/edit/{id}`   | Edit blog (owner)    |
| DELETE | `/api/blogs/delete/{id}` | Delete blog (owner)  |


### 🔐 Auth Header Format

```
Authorization: Bearer <your-jwt-token>

```


## 🔗 Connect with Me




<p align="center"> <a href="https://twitter.com/saurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" height="30" width="40" /></a> <a href="https://linkedin.com/in/saurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" height="30" width="40" /></a> <a href="https://fb.com/singhsaurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/facebook.svg" height="30" width="40" /></a> <a href="https://instagram.com/saurabhbahadur_" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" height="30" width="40" /></a> <a href="https://www.youtube.com/c/mightysaur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/youtube.svg" height="30" width="40" /></a> <a href="https://www.hackerrank.com/saurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/hackerrank.svg" height="30" width="40" /></a> <a href="https://discord.gg/aQR27Bg7de" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/discord.svg" height="30" width="40" /></a> </p>