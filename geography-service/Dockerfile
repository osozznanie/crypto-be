FROM openjdk:17-slim-buster as build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw -B dependency:go-offline

RUN ./mvnw -B package

FROM openjdk:17-slim-buster

COPY --from=build target/geography-service.jar .

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "geography-service.jar"]
