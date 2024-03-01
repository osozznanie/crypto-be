FROM openjdk:17-slim-buster
COPY target/eureka-server.jar marketplace-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "marketplace-service.jar"]
