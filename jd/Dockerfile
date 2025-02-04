# Stage 1: Install MariaDB
FROM mariadb:latest AS mariadb
ENV MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD}
ENV MYSQL_DATABASE=${MYSQL_DATABASE}
ENV MYSQL_USER=${MYSQL_USER}
ENV MYSQL_PASSWORD=${MYSQL_PASSWORD}

# Esperar unos segundos para asegurarse de que MariaDB esté listo
HEALTHCHECK CMD mysqladmin ping -h localhost --silent || exit 1

# Stage 2: Build Java Application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Stage 3: Combine both
FROM mariadb:latest

# Copiar la aplicación Java
COPY --from=build /app/target/*.jar /usr/local/bin/app.jar

# Expose ports
EXPOSE ${SERVER_PORT:-8081}
EXPOSE 3306

# Start both services
CMD ["sh", "-c", "mysqld & java -jar /usr/local/bin/app.jar"]