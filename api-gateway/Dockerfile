FROM openjdk:21-slim-buster

WORKDIR /usr/app
COPY . /usr/app

COPY mvnw /usr/app
RUN chmod +x mvnw

RUN ./mvnw -B dependency:go-offline
RUN ./mvnw -B package

EXPOSE 9090

ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=prod", "target/api-gateway-0.0.1-SNAPSHOT.jar"]