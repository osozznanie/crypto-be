FROM openjdk:17-slim-buster
COPY target/eureka-server.jar api-gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "api-gateway.jar"]
