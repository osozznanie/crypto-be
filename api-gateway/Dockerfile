FROM openjdk:17-slim-buster
COPY target/api-gateway.jar api-gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "api-gateway.jar"]
