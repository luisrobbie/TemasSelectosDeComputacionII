# Proyecto Spring Boot – Tienda Online

## Descripción

Este proyecto es una aplicación **Spring Boot** que se conecta a:

* Una **base de datos relacional (MySQL)** para manejar la información principal del sistema.
* Una **base de datos NoSQL (MongoDB)** para almacenar las imágenes de los productos.

La arquitectura combina **JPA (relacional)** y **MongoDB (documentos)**.

---

# Tecnologías utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Spring Data MongoDB
* MySQL
* MongoDB
* Maven

# Base de datos relacional (MySQL)

El archivo incluido:

```
DB_TIENDA_ONLINE.sql
```

contiene la estructura de la base de datos para poder crear la base de datos.

Configuración en `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3308/DB_TIENDA_ONLINE
spring.datasource.username=Luis
spring.datasource.password=DesarrollandoApis
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

# Base de datos NoSQL (MongoDB)

MongoDB se utiliza para almacenar las **imágenes de los productos**.

Colección utilizada:

```
IMAGENES
```

Ejemplo de documento:

```json
{
  "_id": "ObjectId",
  "productoId": 1,
  "url": "https://cdn.tienda.com/img/producto1.jpg",
  "orden": 1,
  "principal": true
}
```

Configuración en `application.properties`:

```
spring.mongodb.uri=mongodb://localhost:27017/DB_TIENDA_ONLINE
```

MongoDB crea automáticamente la base de datos y la colección al insertar el primer documento.

---

# Ejecutar el proyecto

1. Clonar el repositorio

```
git clone <https://github.com/luisrobbie/TemasSelectosDeComputacionII/tree/main/online>
```

2. Crear la base de datos en MySQL ejecutando el script:

```
DB_TIENDA_ONLINE.sql
```

3. Verificar que MongoDB esté corriendo en el puerto **27017**

4. Ejecutar el proyecto

```
mvn spring-boot:run
```

---

# Notas

* Para ejecutar correctamente el proyecto es posible que se deban **modificar las credenciales de MySQL** en el archivo `application.properties`.
* También puede ser necesario **cambiar el puerto de MySQL**, dependiendo de la configuración local.
* El puerto por defecto de MySQL es **3306**, pero en este proyecto se utiliza **3308**, por lo que se puede ajustar según la instalación del usuario.

---

# Autor

**Pérez Estrada Luis Ángel**
