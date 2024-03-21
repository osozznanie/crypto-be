FROM openjdk:21-slim-buster

WORKDIR /usr/app
COPY . /usr/app

RUN chmod +x mvnw
RUN ./mvnw -B dependency:go-offline
RUN ./mvnw -B package

EXPOSE 8761
ENV IMAGE_NAME=eureka-server


ENTRYPOINT ["java", "-jar", "target/eureka-server.jar"]
