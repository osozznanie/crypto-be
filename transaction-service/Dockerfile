FROM openjdk:17-slim-buster
COPY target/eureka-server.jar transaction-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "transaction-service.jar"]
