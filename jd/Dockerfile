# Stage 1: Install MariaDB
FROM mariadb:latest AS mariadb
ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_DATABASE=jd
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=password

# Copy Database
COPY --from=mariadb /var/lib/mysql /var/lib/mysql
VOLUME ["/var/lib/mysql"]

# Stage 2: Build Java Application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Stage 3: Combine both
FROM mariadb:latest

# Copy Java Application
COPY --from=build /app/target/*.jar app.jar

# Expose ports
EXPOSE ${SERVER_PORT:-8081}
EXPOSE 3306

# Start both services
CMD ["sh", "-c", "mysqld & java -jar /usr/local/bin/app.jar"]