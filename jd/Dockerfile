# Stage 1: Build the application using Maven.
FROM maven:3.8.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the jar.
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Create the final image with the built jar.
FROM eclipse-temurin:17-jre
WORKDIR /app
# Adjust the path to your jar file if needed.
COPY --from=build /app/target/*.jar app.jar

# Expose the port that the app listens on.
EXPOSE ${SERVER_PORT:-8081}

# Run the application.
ENTRYPOINT ["java", "-jar", "app.jar"]
