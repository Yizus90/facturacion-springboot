# Dockerfile
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia el JAR generado por Maven (wildcard para evitar nombre exacto)
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]