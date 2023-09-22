
<h1 align="center">API Portfolio</h1>




## Table of Contents

- [About](#about)
- [Stack](#stack)
- [Usage](#usage)
- [Security](#security)
- [Endpoints](#endpoints)
- [Built Using](#built_using)
- [Author](#author)

## About <a name = "about"></a>

This API is for my portfolio website. It is a RESTful API that is built with Spring Boot and secured with Spring Security and uses a PostgreSQL database.

## Used Stack <a name = "stack"></a>

[![My Stack](https://skills.thijs.gg/icons?i=java,spring,maven,mongodb)](https://skills.thijs.gg)

- Java 17
- Maven
- MongoDB
- Git
- IntelliJ IDEA
- Spring Boot
- Spring Security
- Spring Web


## Usage <a name = "usage"></a>

Is used to provide data for my portfolio website and helps me to update my Portfolio website with new projects and skills posts without having to change the website code.

## Security <a name = "security"></a>

It is secured with Spring Security and uses JWT for authentication and authorization to access the endpoints to create, read, update and delete projects and skills posts.

## Endpoints <a name = "endpoints"></a>

### Projects

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | /api/projects | Get all projects |
| GET | /api/projects/{id} | Get project by id |
| POST | /api/projects | Create new project |
| PUT | /api/projects/{id} | Update project by id |
| DELETE | /api/projects/{id} | Delete project by id |

### Skills

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | /api/skills | Get all skills |
| GET | /api/skills/{id} | Get skill by id |
| POST | /api/skills | Create new skill |
| PUT | /api/skills/{id} | Update skill by id |
| DELETE | /api/skills/{id} | Delete skill by id |


### Authentication

| Method | Endpoint          | Description                         |
| --- |-------------------|-------------------------------------|
| POST | /api/auth/login   | Authenticate user and get JWT token |
| POST | /api/auth/logout  | Delete the token from database      |
| POST | /api/auth/refresh | Refresh JWT token                   |


## Built Using <a name = "built_using"></a>

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework
- [Maven](https://maven.apache.org/) - Dependency Management
- [MongoDB](https://www.mongodb.com/) - Database
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE
- [Spring Security](https://spring.io/projects/spring-security) - Security
- [Spring Web](https://spring.io/projects/spring-web) - Web
- [Spring Validation](https://spring.io/guides/gs/validating-form-input/) - Validation
- [JWT](https://jwt.io/) - Authentication
- [Git](https://git-scm.com/) - Version Control


## Author <a name = "author"></a>

- [@MkkCreations](https://github.com/mkkcreations) - Creator
