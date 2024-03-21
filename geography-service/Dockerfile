FROM openjdk:21-slim-buster as build

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .

RUN ./mvnw -B dependency:go-offline

COPY src src

RUN ./mvnw -B package

FROM openjdk:21-slim-buster

COPY --from=build target/geography-service.jar .

EXPOSE 8095

ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=prod", "geography-service.jar"]