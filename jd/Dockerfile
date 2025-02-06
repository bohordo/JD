# Stage 1: Build using lightweight Maven image
FROM maven:3.8.5-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Cache dependencies first
COPY pom.xml .
RUN mvn -B dependency:go-offline --fail-never

# Build application
COPY src ./src
RUN mvn -B package -DskipTests

# Stage 2: Minimal runtime image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy built jar
COPY --from=build /app/target/*.jar app.jar

# Adjust the path to your jar file if needed.
COPY --from=build /app/target/*.jar app.jar

# Expose the port that the app listens on.
EXPOSE ${SERVER_PORT:-8081}

# Run the application.
ENTRYPOINT ["java", "-jar", "app.jar"]
