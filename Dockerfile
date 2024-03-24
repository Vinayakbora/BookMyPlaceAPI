FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/bookmyplace-api.jar .
EXPOSE 8081
ENTRYPOINT [ "java","-jar","bookmyplace-api.jar"]