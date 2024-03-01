FROM openjdk:17-slim-buster
COPY target/user-service.jar user-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "user-service.jar"]
