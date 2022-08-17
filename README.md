# Shopping App 🚀🚀

## **Deployed via Heroku** [Shopping App](https://shopping-app-bm.herokuapp.com)

![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white)

# **Service Functionality** 🧠

- A Backend Rest-API designed using MVC Design Architecture.
- Enables customers to choose the products they want.
- Enables app admins to add/remove products.
- Ability to serve products with different categories, our app is scalable.
- Email and Password based Authentication.
- Authorization was done using JWT(Json Web Token).
- Error and Exception handling.  

```
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── bm
    │   │           ├── config
    │   │           │   └── SecurityConfig.java
    │   │           ├── controller
    │   │           │   ├── CategoryController.java
    │   │           │   ├── LoginController.java
    │   │           │   ├── ProductController.java
    │   │           │   ├── ProfileController.java
    │   │           │   └── RegistrationController.java
    │   │           ├── dto
    │   │           │   ├── CustomUserDetails.java
    │   │           │   ├── LoginRequest.java
    │   │           │   ├── LoginResponse.java
    │   │           │   ├── ProductDto.java
    │   │           │   └── UpdateRequest.java
    │   │           ├── entity
    │   │           │   ├── Category.java
    │   │           │   ├── Product.java
    │   │           │   └── User.java
    │   │           ├── exception
    │   │           │   ├── ErrorResponse.java
    │   │           │   └── Errors.java
    │   │           ├── filter
    │   │           │   └── JwtFilter.java
    │   │           ├── repository
    │   │           │   ├── CategoryRepository.java
    │   │           │   ├── ProductRepository.java
    │   │           │   └── UserRepository.java
    │   │           ├── service
    │   │           │   ├── CategoryService.java
    │   │           │   ├── impl
    │   │           │   │   ├── CategoryServiceImpl.java
    │   │           │   │   ├── LoginServiceImpl.java
    │   │           │   │   ├── ProductServiceImpl.java
    │   │           │   │   ├── ProfileServiceImpl.java
    │   │           │   │   ├── RegistrationServiceImpl.java
    │   │           │   │   └── UserServiceImpl.java
    │   │           │   ├── LoginService.java
    │   │           │   ├── ProductService.java
    │   │           │   ├── ProfileService.java
    │   │           │   ├── RegistrationService.java
    │   │           │   └── UserService.java
    │   │           ├── ShoppingApplication.java
    │   │           └── util
    │   │               └── JwtUtil.java
    │   └── resources
    │       └── application.properties
```

# **Database Design 🖊️**

![WhatsApp Image 2022-08-17 at 12 15 59 PM](https://user-images.githubusercontent.com/58389695/185098824-d1345a71-d9cc-47cc-841e-24e5dbf58f82.jpeg)

# **Tech Stack ⚡**

- Programming Language: Java 8
- Backend Framework: Spring Boot v2.7.2
- Database Engine: PostgreSQL
- Deployment: Heroku
- API Documentation: Swagger via OpenApi 3.0
- Logger: SLF4J
- Other Frameworks: Spring [**Security**, **Data JPA**]

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

[![Maven](https://badgen.net/badge/icon/maven?icon=maven&label)](https://https://maven.apache.org/)

![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white)



# **Features to add in the future 💭** 
- Adding OAuth 2.0.
- Signup with Google, Facebook and other platforms.


# API Documentation 📝 via  [|Swagger|](https://shopping-app-bm.herokuapp.com/swagger-ui/index.html#/) *OR* [|Notion|](https://youthful-burn-22f.notion.site/API-Documentation-48b32853a1ba46b0ba285fe216c0d4b6)
