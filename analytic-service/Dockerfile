FROM openjdk:21-slim-buster as build

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .

RUN ./mvnw -B dependency:go-offline

COPY src src

RUN ./mvnw -B package

FROM openjdk:21-slim-buster

COPY --from=build target/analytic-service.jar .

EXPOSE 8098

ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=prod", "analytic-service.jar"]