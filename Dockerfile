FROM eclipse-temurin:17-jdk-alpine

WORKDIR /opt/servicio

COPY ./target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
