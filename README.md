# Sistema de Reclutamiento : PostulaPe
Este proyecto es un Sistema de Reclutamiento y Gestión Administrativa de Empleados que optimiza el proceso de contratación en una empresa. Permite administrar convocatorias de empleo, registrar postulantes con su CV, asignarlos a procesos de selección y evaluarlos en etapas como entrevistas, pruebas técnicas y psicológicas. Además, genera reportes de los candidatos seleccionados y brinda soporte a la administración en la gestión integral del personal.

---

## 👥 Integrantes

- Apaza Sandagorda Jhoandry
---

## 🎯 Alcance del Proyecto


El sistema de reclutamiento busca automatizar y optimizar el proceso de selección de personal en la empresa, permitiendo:  

- Registro y gestión de postulantes.  
- Administración de etapas del proceso (entrevista, pruebas técnicas, pruebas psicológicas, etc.).  
- Gestión de empleados contratados.  
- Consulta y reportes del proceso de reclutamiento.  

Con este sistema, se facilita la labor del área de Recursos Humanos, reduciendo tiempos de gestión y mejorando la organización del proceso.

---

## 🗄️ Diseño de Base de Datos

A continuación se muestra el diagrama de la base de datos:  

[BD_POSTULAPE.pdf](https://github.com/user-attachments/files/22323104/BD_POSTULAPE.pdf)

---



## 🌐 Endpoints Disponibles

## Base URL http://localhost:8080

### 📂 postulante

| Método | Endpoint               | Descripción                                   |
|--------|------------------------|-----------------------------------------------|
| GET    | /postulantes           | Listar todos los postulantes                  |
| POST   | /postulantes           | Registrar un nuevo postulante                 |
| PUT    | /postulantes/{id}      | Actualizar información de un postulante       |
| DELETE | /postulantes/{id}      | Eliminar logicamente un postulante            |

---

### 📂 usuario

| Método | Endpoint               | Descripción                                   |
|--------|------------------------|-----------------------------------------------|
| GET    | /usuarios              | Listar todos los usuarios                     |
| POST   | /usuarios              | Registrar un nuevo usuario                    |
| PUT    | /usuarios/{id}         | Actualizar información de un usuario          |
| DELETE | /usuarios/{id}         | Eliminar logicamente un usuario               |

---

### 📂 area

| Método | Endpoint               | Descripción                                   |
|--------|------------------------|-----------------------------------------------|
| GET    | /areas                 | Listar todas las áreas                        |
| POST   | /areas                 | Registrar una nueva área                      |
| PUT    | /areas/{id}            | Actualizar información de un área             |
| DELETE | /areas/{id}            | Eliminar logicamente un área                  |

---

### 📂 convocatoria

| Método | Endpoint               | Descripción                                   |
|--------|------------------------|-----------------------------------------------|
| GET    | /convocatorias         | Listar todas las convocatorias                |
| POST   | /convocatorias         | Registrar una nueva convocatoria              |
| PUT    | /convocatorias/{id}    | Actualizar información de una convocatoria    |
| DELETE | /convocatorias/{id}    | Eliminar logicamente una convocatoria         |

---

### 📂 perfil

| Método | Endpoint               | Descripción                                   |
|--------|------------------------|-----------------------------------------------|
| GET    | /perfiles              | Listar todos los perfiles                     |
| POST   | /perfiles              | Registrar un nuevo perfil                     |
| PUT    | /perfiles/{id}         | Actualizar información de un perfil           |
| DELETE | /perfiles/{id}         | Eliminar logicamente un perfil                |

---

### 📂 etapa

| Método | Endpoint               | Descripción                                   |
|--------|------------------------|-----------------------------------------------|
| GET    | /etapa                 | Listar todas las etapas                       |
| POST   | /etapa                 | Registrar una nueva etapa                     |
| PUT    | /etapa/{id}            | Actualizar información de una etapa           |
| DELETE | /etapa/{id}            | Eliminar logicamente una etapa                |
 
---

## Reto:

###👥 Integrantes

- Apaza Sandagorda Jhoandry

## 📖 Documentación con Swagger

El proyecto cuenta con integración de Swagger, lo que permite disponer de una documentación interactiva y siempre actualizada de la API del **Sistema de Reclutamiento**.  

Gracias a esta herramienta, se pueden visualizar de forma clara todos los **endpoints expuestos anteriormente** en el backend (convocatorias, postulantes, areas y usuarios), junto con la información necesaria para consumirlos, como parámetros de entrada, cuerpos de las peticiones y ejemplos de respuestas.  

Además, Swagger no solo documenta, sino que también facilita **probar los endpoints (CRUD) directamente desde el navegador**.
### 🚀 Acceso a la documentación
Una vez ejecutada la aplicación, la documentación estará disponible en:
- `http://localhost:8080/swagger-ui/index.html`

### Video demostrativo: 

link: https://www.youtube.com/watch?v=5NT6PiRXfxE

---

Sistema de reclutamiento-Lenguaje de programacion avanzado SISE
