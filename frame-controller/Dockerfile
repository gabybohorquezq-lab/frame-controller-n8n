# 1. Usamos una imagen de Java liviana
FROM eclipse-temurin:17-jdk-alpine

# 2. Creamos una carpeta para la app
WORKDIR /app

# 3. Copiamos el archivo JAR (el ejecutable que genera Maven)
COPY target/*.jar app.jar

# 4. Exponemos el puerto que usa Spring Boot
EXPOSE 8080

# 5. Comando para arrancar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]