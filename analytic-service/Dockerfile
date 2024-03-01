FROM openjdk:latest
ADD ../build/libs/cryptoworld-0.0.1.jar /app/cryptoworld.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "analytic-service.jar"]
EXPOSE 8080