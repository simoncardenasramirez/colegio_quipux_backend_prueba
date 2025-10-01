# 📚 Proyecto Backend - Colegio Quipux

Base de datos: **H2 en memoria**  
JDBC URL: `jdbc:h2:mem:universidad`  
Usuario: `sa`  
Password: *(vacío)*

---

## 🚀 Endpoints

### Materias

1. **POST /api/materias** → Crear materia  
   Body JSON:  
   ```json
   { "nombre": "Matemáticas I" }
   ```

2. **GET /api/materias** → Listar todas las materias  

---

### Estudiantes

3. **POST /api/estudiantes** → Crear estudiante (con o sin materias)  
   Body JSON (sin materias):  
   ```json
   { "nombre": "Juan Perez", "materiaIds": [] }
   ```  
   Body JSON (con materias):  
   ```json
   { "nombre": "Ana López", "materiaIds": [1,2] }
   ```

4. **GET /api/estudiantes/{id}** → Consultar estudiante por ID  

5. **GET /api/estudiantes/{id}/materias** → Consultar materias de un estudiante  

6. **PUT /api/estudiantes/{id}/materias** → Matricular materias a un estudiante existente  
   Body JSON:  
   ```json
   [1, 3]
   ```
