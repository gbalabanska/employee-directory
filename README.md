# Employee Management System

This project is part of a comprehensive course on Spring Boot 3, Spring 6, and Hibernate.

## Dockerized Application

This application is containerized using Docker. The setup includes the following:

- **Dockerfile**: Used to build an image of the Spring Boot application.
- **docker-compose.yml**: Manages multiple containers, including the MySQL database and the Spring Boot application. The containers are configured to run in a defined sequence within a Docker network. The MySQL container starts first, followed by the application container, which depends on the MySQL service.

## Getting Started

To start the application, follow these steps:

1. **Build and Start Containers**:
   Open the terminal in your IDE and run the following command:

![image](https://github.com/user-attachments/assets/dc16b038-f187-48b1-896a-43fb1aa86d6b)


2. **Access the Application**:
   Once the containers are up and running, open your web browser and navigate to:

![image](https://github.com/user-attachments/assets/ce15b6f0-78dc-448f-8639-7a93701c912b)



You can now manage employee data through the application interface.




