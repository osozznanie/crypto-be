FROM openjdk:17-slim-buster as build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw -B dependency:go-offline

RUN ./mvnw -B package

FROM openjdk:17-slim-buster

COPY --from=build target/eureka-server.jar .

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "eureka-server.jar"]
