# Etapa 1: Build
FROM gradle:8.5-jdk17-alpine AS builder

WORKDIR /app

# Copiar archivos de Gradle
COPY build.gradle settings.gradle ./
COPY gradle gradle/
COPY gradlew ./

# Descargar dependencias
RUN gradle dependencies --no-daemon || true

# Copiar código fuente
COPY src src/

# Compilar aplicación
RUN gradle clean bootJar --no-daemon

# Etapa 2: Runtime
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copiar JAR desde builder
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8082

ENV JAVA_OPTS="-Xmx512m -Xms256m"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]