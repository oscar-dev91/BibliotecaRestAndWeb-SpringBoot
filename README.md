# Biblioteca REST & Web Controllers

Este proyecto en Java implementa una aplicación web con controladores REST y Web para gestionar una biblioteca digital que incluye libros, revistas y DVDs. Se ha desarrollado usando Spring Boot y sigue las mejores prácticas de separación de responsabilidades.

## Características

* API REST para la gestión de libros, revistas y DVDs.
* Controladores Web para una interfaz interactiva.
* Conexión a base de datos MySQL.
* Uso de variables de entorno para mantener la seguridad y portabilidad.

## Tecnologías utilizadas

* Java 17+
* Spring Boot
* Spring MVC
* Spring Data JPA
* MySQL
* Thymeleaf

## Estructura de Controladores

### REST Controllers

* ``LibroRestController.java``
* ``RevistaRestController.java``
* ``DVDRestController.java``

### Web Controllers

* ``LibroWebController.java``
* ``RevistaWebController.java``
* ``DVDWebController.java``

## Configuración de entorno

Las variables de entorno se definen en el archivo ``.env`` y se referencian desde ``application.properties`` usando la sintaxis ``${VARIABLE}``.

### .env (ejemplo)
```bash
DB_URL=jdbc:mysql://localhost:3306/biblioteca
DB_USERNAME=root
DB_PASSWORD=clave_segura
```
### application.properties
```bash
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.error.include-message=always
server.error.include-binding-errors=always
server.error.include-stacktrace=always
```
## ¿Por qué usar variables de entorno?

El uso de variables de entorno es crucial en entornos de producción porque:
* Protege información sensible (como contraseñas y URLs de bases de datos).
* Permite configuraciones diferentes por entorno (desarrollo, testing, producción).
* Facilita la integración con sistemas de CI/CD.
* Evita exponer datos en repositorios de código.

**Importante**: Nunca subas tu archivo ``.env`` a repositorios públicos.

## Ejecución del proyecto

1. Clona el repositorio.
2. Crea un archivo ``.env`` en el directorio raíz con tus credenciales de base de datos.
3. Ejecuta la aplicación con tu IDE o con:
```bash
./mvnw spring-boot:run
```
## Endpoints REST de ejemplo

* ``GET /api/libros`` - Lista todos los libros
* POST ``/api/libros`` - Agrega un libro nuevo
* GET ``/api/revistas`` - Lista todas las revistas
* GET ``/api/dvds`` - Lista todos los DVDs

## Endpoints Web de ejemplo
* ``/libros`` - Vista con listado de libros
* ``/revistas`` - Vista con listado de revistas
* ``/dvds`` - Vista con listado de DVDs

## Importar en Postman

Incluimos el archivo ``Biblioteca.postman_collection`` para que puedas importar directamente la colección en Postman y comenzar a probar todos los endpoints REST de forma rápida y sencilla.

**Desarrollado con pasión por el conocimiento y la buena arquitectura ☕**

