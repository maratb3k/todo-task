# Todo List RESTful API

This project is a RESTful API built using Spring Boot, Hibernate, and MySQL to manage a simple todo list application. The API allows users to create, read, update, and delete todo items. Each todo item includes a title and a description, and all data is persisted in a MySQL database using Hibernate.

## Features

- Create a new todo item.
- Retrieve a list of all todo items.
- Retrieve a single todo item by its ID.
- Update an existing todo item.
- Delete a todo item by its ID.

## Technologies Used

- **Spring Boot** - Framework for building Java-based web applications.
- **Hibernate** - ORM (Object-Relational Mapping) framework for database interactions.
- **MySQL** - Relational database management system for storing data.
- **Gradle** - Dependency management and build tool.
- **JUnit Jupiter** - Provides the core JUnit 5 functionalities.
- **Mockito Core** - For mocking objects during tests.
- **Spring Boot Starter Test** - This is a comprehensive starter package for testing with Spring Boot applications. It includes support for JUnit, Mockito, MockMvc, and other testing utilities.
- **Mockito JUnit Jupiter** - Allows using Mockito annotations like @Mock and @InjectMocks in JUnit 5 tests.

## Prerequisites

Before running the application, ensure you have the following installed:

- [Java 21 (or compatible JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle](https://gradle.org/)
- [MySQL](https://www.mysql.com/)
- [Git](https://git-scm.com/)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/maratb3k/todo-task.git
cd todo-task
```

### 2. Configure the MySQL Database
Create a MySQL database named **todo_db** (or update the configuration as needed) and update the **application.properties** file located in **src/main/resources/** with your database credentials:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build the Project
Use Gradle to build the project:
```bash
./gradlew build
```
### 4. Run the Application
Start the application using the following command:
```bash
./gradlew bootRun
```
Alternatively, you can run the generated JAR file:
```bash
java -jar build/libs/todo-application-0.0.1-SNAPSHOT.jar
```
### 5. API Endpoints
The API exposes the following endpoints for managing todo items:

### 1) Create a new todo item
**POST** `/todos`

**Request body example:**
```json
{
  "title": "Example Task",
  "description": "This is an example description."
}
```

### 2) Retrieve all todo items
**GET** `/todos`

### 3) Retrieve a single todo item by ID
**GET** `/todos/{id}`

### 4) Update an existing todo item
**PUT** `/todos/{id}`

**Request body example:**
```json
{
  "title": "Updated Task",
  "description": "This is an updated description."
}
```

### 5) Delete a todo item by ID
**DELETE** `/todos/{id}`

### 6. Testing the API
You can use tools such as Postman or cURL to test the API endpoints.


## Feedback

### Was it easy to complete the task using AI?
Yes, it was relatively straightforward. AI provided step-by-step guidance and generated structured code based on prompts, which made it easier to accomplish the task.

### How long did the task take you to complete?
The task took approximately 1 hour to complete.

### Was the code ready to run after generation? What did you have to change to make it usable?
No, I had to configure the database and set up Postman to check the API requests.

### Which challenges did you face during completion of the task?
Challenges primarily included clarifying ambiguous prompts and ensuring that configurations were aligned with the user's environment (e.g., database settings).

### Which specific prompts did you learn as a good practice to complete the task?
1. `I am a Java developer who needs to build a RESTful API to manage a simple todo list application using Spring Boot, Hibernate, and MySQL. The application should allow users to create, read, update, and delete todo items. Each item should have a title and a description. Can you guide me step-by-step on how to achieve this?`
2. `Can you help me with writing and running JUnit tests for the code you provided?`


