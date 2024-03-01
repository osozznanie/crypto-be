FROM openjdk:latest
ADD ../build/libs/cryptoworld-0.0.1.jar /app/cryptoworld.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "eureka-server.jar"]
EXPOSE 8080