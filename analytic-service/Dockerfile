FROM openjdk:17-slim-buster
COPY target/analytic-service.jar analytic-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "analytic-service.jar"]
