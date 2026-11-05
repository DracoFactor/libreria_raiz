# Etapa 1: Compilación (Build)
# Usamos una imagen con Maven y Java 21 para compilar el proyecto
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos primero el pom.xml para aprovechar la caché de dependencias de Docker
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiamos el resto del código y compilamos
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Runtime)
# Usamos una imagen ligera de Java 21 (JRE) solo para ejecutar la aplicación
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el archivo .jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto 8080 (Render lo mapeará automáticamente)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]