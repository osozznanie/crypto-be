FROM openjdk:17-slim-buster
COPY target/eureka-server.jar logging-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "logging-service.jar"]
