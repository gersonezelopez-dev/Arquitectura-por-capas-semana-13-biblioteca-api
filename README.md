# Semana 13 – Biblioteca Personal API

## 1. Nombre de la actividad
Desarrollo de una API REST para administrar libros de una biblioteca personal.

## 2. Descripción del problema
Este proyecto permite llevar un control de los libros de una biblioteca personal. Se pueden registrar, consultar, 
actualizar y eliminar libros, guardando toda la información en una base de datos PostgreSQL.

## 3. Tecnologías utilizadas
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- IntelliJ IDEA
- Postman

## 4. Estructura del proyecto
- **controller:** Contiene LibroController.java, que recibe las solicitudes.
- **entity:** Contiene Libro.java, que representa los datos del libro.
- **repository:** Contiene LibroRepository.java, que permite consultar y guardar los libros.
- **database:** Contiene el script biblioteca.sql.
- **evidencias:** Contiene el documento Word con las capturas de las pruebas.

## 5. Configuración de la base de datos
Se utiliza PostgreSQL con una base de datos llamada `biblioteca_personal` y una tabla llamada `libro`.

La conexión se configura en `application.properties`, utilizando el puerto 5432 y el usuario postgres. La contraseña 
se proporciona mediante la variable de entorno `DB_PASSWORD`.

## 6. Endpoints de la API

| Método | Endpoint | Descripción |
|---|---|---|
| GET | /api/libros | Consultar todos los libros |
| GET | /api/libros/{id} | Buscar un libro por ID |
| POST | /api/libros | Registrar un libro |
| PUT | /api/libros/{id} | Actualizar un libro |
| DELETE | /api/libros/{id} | Eliminar un libro |
| GET | /api/libros/categoria/{categoria} | Buscar libros por categoría |
| GET | /api/libros/disponibles | Consultar libros disponibles |

## 7. Instrucciones para ejecutar
1. Abrir el proyecto en IntelliJ IDEA.
2. Tener PostgreSQL instalado y en funcionamiento.
3. Crear la base de datos `biblioteca_personal`.
4. Ejecutar el archivo `database/biblioteca.sql`.
5. Configurar la contraseña de PostgreSQL mediante la variable `DB_PASSWORD`.
6. Ejecutar la clase principal `Semana13BibliotecaApiApplication`.
7. Abrir Postman para realizar las pruebas en `http://localhost:8080/api/libros`.

## 8. Datos del estudiante
**Nombre:** Gerson Ezequiel López Enríquez

**Carné:** 9941-25-22144    

**Curso:** Programación II

**Actividad:** Semana 13 – Biblioteca Personal API