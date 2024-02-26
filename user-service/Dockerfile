FROM openjdk:17-slim-buster as build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw -B dependency:go-offline

RUN ./mvnw -B package

FROM openjdk:17-slim-buster

COPY --from=build target/user-service.jar .

EXPOSE 8088

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "user-service.jar"]
