FROM openjdk:17-slim-buster
COPY target/company-service.jar company-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "company-service.jar"]
