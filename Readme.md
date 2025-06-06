# API de Celulares - Proyecto Spring Boot con Docker

Este proyecto es una API RESTful desarrollada con Spring Boot para gestionar un inventario de celulares. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los registros de celulares.

El proyecto está completamente dockerizado usando Docker Compose, lo que facilita su despliegue y ejecución en cualquier entorno que tenga Docker instalado.

## Tecnologías Utilizadas

*   Java 17
*   Spring Boot 3
*   Spring Data JPA (Hibernate)
*   MySQL 8
*   Maven
*   Docker & Docker Compose

## Prerrequisitos

Antes de comenzar, asegúrate de tener instalado el siguiente software en tu sistema:

*   [Docker](https://www.docker.com/get-started)
*   [Docker Compose](https://docs.docker.com/compose/install/) (generalmente viene incluido con Docker Desktop)
*   Un cliente de API como [Postman](https://www.postman.com/downloads/), [Insomnia](https://insomnia.rest/download) o `curl` en tu línea de comandos.



1.  **Levanta los servicios con Docker Compose:**
    Abre una terminal en la raíz del proyecto y ejecuta el siguiente comando:
    ```bash
    docker-compose up --build
    ```
    Este comando hará lo siguiente:
    *   Construirá la imagen de la aplicación Spring Boot (`celulares-api`) usando el `Dockerfile`.
    *   Descargará la imagen de MySQL 8.
    *   Levantará dos contenedores: uno para la aplicación y otro para la base de datos.
    *   Creará una red interna para que ambos contenedores se comuniquen.

2.  **Verificación:**
    Una vez que el comando termine y veas los logs de Spring Boot indicando que la aplicación se ha iniciado, el entorno estará listo.
    *   La **API de celulares** estará disponible en `http://localhost:8081`.
    *   La **base de datos MySQL** estará expuesta en el puerto `3307` de tu máquina local (por si quieres conectarte con un cliente como DBeaver o MySQL Workbench).

## Guía de la API (Endpoints)

A continuación se muestran los endpoints disponibles y ejemplos de cómo usarlos con `curl`.

---

### 1. Listar todos los celulares
Recupera una lista de todos los celulares en la base de datos.

*   **Endpoint:** `GET /api/v1/celulares/`
*   **Comando `curl`:**
    ```bash
    curl -X GET http://localhost:8081/api/v1/celulares/
    ```
*   **Respuesta de Ejemplo:**
    ```json
    [
      {
        "id": 1,
        "marca": "Samsung",
        "modelo": "Galaxy S23",
        "precio": 15000.00,
        "foto": "https://example.com/s23.jpg"
      }
    ]
    ```

---

### 2. Obtener un celular por su ID
Recupera la información de un celular específico.

*   **Endpoint:** `GET /api/v1/celulares/{id}`
*   **Comando `curl` (para el ID 1):**
    ```bash
    curl -X GET http://localhost:8081/api/v1/celulares/1
    ```
*   **Respuesta de Ejemplo:**
    ```json
    {
      "id": 1,
      "marca": "Samsung",
      "modelo": "Galaxy S23",
      "precio": 15000.00,
      "foto": "https://example.com/s23.jpg"
    }
    ```

---

### 3. Crear un nuevo celular
Añade un nuevo celular al inventario.

*   **Endpoint:** `POST /api/v1/celulares/`
*   **Comando `curl`:**
    ```bash
    curl -X POST http://localhost:8081/api/v1/celulares/ \
    -H "Content-Type: application/json" \
    -d '{
      "marca": "Google",
      "modelo": "Pixel 8",
      "precio": 18500.75,
      "foto": "https://example.com/pixel8.jpg"
    }'
    ```
*   **Respuesta de Ejemplo (con código 201 Created):**
    ```json
    {
      "id": 2,
      "marca": "Google",
      "modelo": "Pixel 8",
      "precio": 18500.75,
      "foto": "https://example.com/pixel8.jpg"
    }
    ```

---

### 4. Actualizar un celular completamente (PUT)
Reemplaza toda la información de un celular existente.

*   **Endpoint:** `PUT /api/v1/celulares/{id}`
*   **Comando `curl` (para el ID 1):**
    ```bash
    curl -X PUT http://localhost:8081/api/v1/celulares/1 \
    -H "Content-Type: application/json" \
    -d '{
      "marca": "Samsung",
      "modelo": "Galaxy S23 Ultra",
      "precio": 17500.00,
      "foto": "https://example.com/s23ultra.jpg"
    }'
    ```

---

### 5. Actualizar un celular parcialmente (PATCH)
Modifica solo los campos especificados de un celular existente.

*   **Endpoint:** `PATCH /api/v1/celulares/{id}`
*   **Comando `curl` (para cambiar solo el precio del ID 2):**
    ```bash
    curl -X PATCH http://localhost:8081/api/v1/celulares/2 \
    -H "Content-Type: application/json" \
    -d '{
      "precio": 19000.00
    }'
    ```

---

### 6. Eliminar un celular
Borra un celular de la base de datos.

*   **Endpoint:** `DELETE /api/v1/celulares/{id}`
*   **Comando `curl` (para el ID 2):**
    ```bash
    curl -X DELETE http://localhost:8081/api/v1/celulares/2
    ```
*   **Respuesta de Ejemplo:** No hay contenido en la respuesta, solo un código de estado `200 OK` o `204 No Content`.

## Detener el Entorno
Para detener y eliminar los contenedores, la red y los volúmenes creados, ejecuta:
```bash
docker-compose down
