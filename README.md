# QA Java + Spring Training Project

A tiny Spring Boot project with implemented methods and **intentional gaps** to practice testing with **JUnit 5**, **Mockito**, and **Spring Boot Test** (+ RestAssured for simple API checks).

## How to run
```bash
mvn -q -DskipTests spring-boot:run
```
API: `POST /api/users` and `GET /api/users`

## How to test
```bash
mvn -q test
```

## What to practice
- Unit tests for pure functions (MathUtils, StringUtils)
- Service tests with mocks (UserService, OrderService)
- Integration tests of REST API (UserControllerIT)

Open `src/test/java/...` and complete all **TODO** items.
