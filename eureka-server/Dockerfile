FROM openjdk:17-slim-buster
COPY target/eureka-server.jar eureka-server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "eureka-server.jar"]
