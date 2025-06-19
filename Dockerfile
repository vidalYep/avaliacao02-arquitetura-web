# Etapa 1: constrói o JAR usando Maven
FROM maven:3.9.6-eclipse-temurin-21 as builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: roda o JAR usando uma imagem Java leve
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
