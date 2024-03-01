FROM openjdk:17-slim-buster
COPY target/authentication-service.jar authentication-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "authentication-service.jar"]
