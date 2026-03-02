# Clinic Psychology API

Proyecto desarrollado en Spring Boot como parte de la materia **Temas Selectos de Computación II**.

## Descripción
API REST para la gestión de pacientes de un consultorio psicológico.  
Permite realizar operaciones CRUD sobre la información de los pacientes, conectándose a una base de datos MySQL.

## Tecnologías utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

## Configuración del proyecto

### Base de datos
El proyecto se conecta a una base de datos MySQL existente.
La estructura puede crearse usando el archivo `schema.sql` incluido en el repositorio.
Importante que el servidor de base de datos este en el puerto 3308 o si no cambiar al 3306 por defecto.

Configurar el archivo `application.properties`:

properties: 
spring.datasource.url=jdbc:mysql://localhost:3308/db_reconstruye?useSSL=false&serverTimezone=UTC
spring.datasource.username=Luis
spring.datasource.password=DesarrollandoApis
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

#### Propiedad de Luis Ángel Peréz Estrada