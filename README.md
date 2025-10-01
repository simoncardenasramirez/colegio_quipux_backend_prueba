# 📚 Proyecto Backend - Colegio Quipux

Base de datos: **H2 en memoria**  
JDBC URL: `jdbc:h2:mem:universidad`  
Usuario: `sa`  
Password: *(vacío)*

---

## 🚀 Endpoints

### Materias

- **Crear materia**  
  POST /api/materias  
  Body JSON:  
  ```json
  { "nombre": "Matemáticas I" }

- **Listar materias**  
  GET /api/materias  

---

### Estudiantes

- **Crear estudiante (sin materias)**  
  POST /api/estudiantes  
  Body JSON:  
  ```json
  { "nombre": "Juan Perez", "materiaIds": [] }

  - **Crear estudiante con materias**  
  POST /api/estudiantes  
  Body JSON:  
  ```json
  { "nombre": "Ana López", "materiaIds": [1,2] }

