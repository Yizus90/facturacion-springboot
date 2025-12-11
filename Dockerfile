# Dockerfile
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar el jar con nombre fijo
COPY target/facturacion-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
