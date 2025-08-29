# 📝 Task Manager API

A simple **CRUD Task Manager Application** built with **Spring Boot** and **MySQL**, enhanced with **JWT Authentication** for secure access.  
This project is designed to demonstrate **backend development skills** including REST APIs, exception handling, authentication, and database integration.  

---

## ⚡ Features
- ✅ **User Authentication** (Signup & Login with JWT)  
- ✅ **Secure Endpoints** (JWT required for task operations)  
- ✅ **CRUD Operations for Tasks**  
  - Create a new task  
  - Retrieve all tasks / task by ID  
  - Update existing tasks  
  - Delete tasks  
- ✅ **Global Exception Handling**  
- ✅ **Persistent Storage** using MySQL  
- ✅ **DTOs & Clean Architecture**  

---

## 📂 Project Structure
```
src/main/java/com/example/taskmanager/
│
├── DemoApplication.java           # Entry point
├── GlobalExceptionHandler.java    # Handles errors globally
│
├── auth/                          # Authentication & JWT
│   ├── JwtUtil.java
│   ├── JwtRequestFilter.java
│   ├── SecurityConfig.java
│   ├── User.java
│   ├── UserRepository.java
│   ├── AuthController.java
│
├── task/                          # Task CRUD
│   ├── Task.java
│   ├── TaskDTO.java
│   ├── TaskRepository.java
│   ├── TaskController.java
```

---

## 🛠️ Tech Stack
- **Java 17+**  
- **Spring Boot** (Web, Security, JPA, Validation)  
- **MySQL** (Persistent Database)  
- **JWT (JSON Web Token)** for authentication  
- **Lombok** for cleaner code (optional)  

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/taskmanager-api.git
cd taskmanager-api
```

### 2️⃣ Configure Database
Update `application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Build & Run
```bash
./mvnw spring-boot:run
```

---

## 🔐 Authentication Flow

### 1. Register User  
```http
POST /auth/signup
Content-Type: application/json

{
  "username": "john",
  "password": "password123"
}
```

### 2. Login User  
```http
POST /auth/login
Content-Type: application/json

{
  "username": "john",
  "password": "password123"
}
```
✅ Response will include a **JWT token**:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### 3. Use JWT in Task Requests  
Attach token in **Authorization Header**:  
```
Authorization: Bearer <your_token>
```

---

## 📌 API Endpoints

### Authentication
- `POST /auth/signup` → Register new user  
- `POST /auth/login` → Authenticate and get JWT  

### Task Management (JWT Required)
- `POST /tasks` → Create new task  
- `GET /tasks` → Get all tasks  
- `GET /tasks/{id}` → Get task by ID  
- `PUT /tasks/{id}` → Update task  
- `DELETE /tasks/{id}` → Delete task  

---

## 🧪 Testing
- Use **Postman** or **cURL** to test API endpoints.  
- First signup & login to get your JWT token.  
- Then attach token in request headers for all `/tasks` endpoints.  

---

## 🚀 Future Improvements
- Role-based access (Admin/User)  
- Pagination & sorting for tasks  
- Dockerize the application  
- Add frontend (React/Angular/Vue)  

---

## 👤 Author 
- GitHub: [ItsPratyush](https://github.com/ItsPratyush)  
