# Etapa 1: Compilación (Build)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos primero el pom.xml
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiamos el resto del código
COPY src ./src

# AQUÍ ESTÁ EL TRUCO: Forzamos el repackage explícitamente
RUN mvn clean package spring-boot:repackage -DskipTests

# Etapa 2: Ejecución (Runtime)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el archivo .jar generado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]