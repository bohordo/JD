# Usa la imagen oficial de MariaDB
FROM mariadb:latest

# Establece las variables de entorno para la configuración de la base de datos
ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_DATABASE=jd
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=password

# Expone el puerto por defecto de MariaDB
EXPOSE 3306

# Usa el comando de inicio de MariaDB
CMD ["mysqld"]