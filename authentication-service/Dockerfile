FROM openjdk:17-slim-buster
COPY target/*.jar authentication-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/authentication-service.jar"]
