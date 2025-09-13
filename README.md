# Sistema de Reclutamiento : PostulaPe
Este proyecto es un Sistema de Reclutamiento y Gestión Administrativa de Empleados que optimiza el proceso de contratación en una empresa. Permite administrar convocatorias de empleo, registrar postulantes con su CV, asignarlos a procesos de selección y evaluarlos en etapas como entrevistas, pruebas técnicas y psicológicas. Además, genera reportes de los candidatos seleccionados y brinda soporte a la administración en la gestión integral del personal.

---

## 👥 Integrantes

- Apaza Sandagorda Jhoandry
- Castro Rojas Jorge Luis
  
---

## 🎯 Alcance del Proyecto

El sistema de reclutamiento busca automatizar y optimizar el proceso de selección de personal en la empresa, permitiendo:  

- Registro y gestión de postulantes.  
- Administración de etapas del proceso (entrevista, pruebas técnicas, pruebas psicológicas, etc.).  
- Gestión de empleados contratados.  
- Asignación de contratos y control de historial laboral.  
- Consulta y reportes del proceso de reclutamiento.  

Con este sistema, se facilita la labor del área de Recursos Humanos, reduciendo tiempos de gestión y mejorando la organización del proceso.

---

## 🗄️ Diseño de Base de Datos

A continuación se muestra el diagrama de la base de datos:  

[DiseñoBD_PostulaPe.pdf](https://github.com/user-attachments/files/22314647/DisenoBD_PostulaPe.pdf)

---

## 🌐 Endpoints Disponibles

| Método | Endpoint                     | Descripción                                   |
|--------|------------------------------|-----------------------------------------------|
| GET    | `/api/postulantes`           | Listar todos los postulantes                  |
| GET    | `/api/postulantes/:id`       | Obtener datos de un postulante por ID         |
| POST   | `/api/postulantes`           | Registrar un nuevo postulante                 |
| PUT    | `/api/postulantes/:id`       | Actualizar información de un postulante       |
| DELETE | `/api/postulantes/:id`       | Eliminar un postulante                        |
| GET    | `/api/empleados`             | Listar empleados contratados                  |
| POST   | `/api/empleados`             | Registrar un nuevo empleado                   |
| GET    | `/api/contratos`             | Listar contratos existentes                   |
| POST   | `/api/contratos`             | Crear un nuevo contrato                       |
| PUT    | `/api/contratos/:id`         | Actualizar información de un contrato         |


---

Sistema de reclutamiento-Lenguaje de programacion avanzado SISE
