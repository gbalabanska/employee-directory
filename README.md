# Employee Management System

This project is part of a comprehensive course on Spring Boot 3, Spring 6, and Hibernate, led by Chad Derby.

## Dockerized Application

This application is containerized using Docker. The setup includes the following:

- **Dockerfile**: Used to build an image of the Spring Boot application.
- **docker-compose.yml**: Manages the containers - the MySQL database and the Spring Boot application. The containers are configured to run in a defined sequence within a Docker network. The MySQL container starts first, followed by the application container, which depends on the MySQL service.

## Getting Started

To start the application, follow these steps:

1. **Start Docker Desktop**

2. **Build and Start Containers**:
   Open the terminal in your IDE and run the following command:
```
docker-compose up
```

3. **Access the Application**:
   Once the containers are up and running, open your web browser and navigate to http://localhost:8080/showMyLoginPage:

![image](https://github.com/user-attachments/assets/c0b4ae51-b142-4d62-bd95-aee6e88d4ab3)

🔑 **Admin Credentials:**
- 👤 **Username:** `gabby`
- 🔒 **Password:** `Tolk!en1892`

You can also register a new user by clicking on the **Sign Up** button.

This application uses **Spring Security** to manage user login (**authentication**) and access to resources (**authorization**). The sign-up process is handled by the class **SignUpController**. Here user passwords are securely hashed before being stored in the DB using the **BCrypt** algorithm with automatically generated random salt. The use of salt ensures that users with the same passwords have different hashed passwords. The **BCrypt** algorithm is purposefully slow to protect against brute-force attacks.

After a successful login, the user is redirected to the page where the employees are listed and **CRUD** operations are available:

![image](https://github.com/user-attachments/assets/047bc603-c921-4b30-a25b-d7a495f3cf9f)

In the following form, users can **add** or **update** employee data:

![image](https://github.com/user-attachments/assets/c1205d91-0a27-4588-b273-79445d58020e)

The security chain configuration defines which roles can perform specific actions. For example, only **ADMIN** users can delete employees, while both **ADMIN** and **MANAGER** roles can update or add employees. If an unauthorized user tries to access a URL not specified for their role, they are redirected to the following page:

![image](https://github.com/user-attachments/assets/450227b4-bdc5-40db-b6d1-09ae59ecf050)








