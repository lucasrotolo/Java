# Java
Trabajo final de la materia Programacion orientada a objetos
Defina las clases (nombre, superclase, atributos y métodos) para implementar una solución orientada a objetos para el siguiente problema e implemente en Java.

Una biblioteca desea desarrollar un sistema de administración de sus libros y colecciones. De cada libro es necesario conocer:

- ID
- Título
- Autores
- Cantidad de páginas
- Editorial
- Año de publicación
- Palabras clave que describen al libro (temática, género, etc).

Los libros se agrupan en la biblioteca en diferentes estantes, estanterías, salas y pabellones. Cada uno de estos grupos posee un número de identificación, un título que lo describe y un conjunto de palabras clave de los elementos que contiene, sin repetidos. Tener en cuenta que, dentro de cada grupo, puede haber libros sueltos u otros grupos. Es decir, dentro de un pabellón puede haber estantes sueltos (repisas), estanterías, salas, libros sueltos (por ejemplo, sobre una silla por falta de espacio).

Existe un caso de grupos especiales que consideran como palabras clave únicamente a las 10 más repetidas de todos sus elementos.

Además de la funcionalidad mencionada, el sistema debe proveer los siguientes servicios:

1. **Búsquedas**
   El sistema debe contar con soporte para la búsqueda de libros que satisfacen un determinado criterio. Los criterios de búsqueda pueden ser simples o compuestos.

   Un criterio de búsqueda simple está definido por un solo atributo, por ejemplo:

   - Buscar los libros del autor “Julio Verne”.
   - Buscar los libros de menos de 200 páginas.
   - Buscar los libros que traten el tema “programación”.

   Los criterios de búsqueda compuestos resultan de combinar estos criterios con operaciones lógicas (and, or, not), como por ejemplo:

   - Buscar los libros cuyo autor es “Horacio Quiroga” y su editorial es “Atlántida”.
   - Buscar los libros cuyo título contiene la palabra “metodologías” pero no contienen la palabra “objetos” en las palabras clave.
   - Buscar los libros cuya autora es “J.K. Rowling”, no contienen la palabra “Potter” en el título y el año de publicación es posterior a 2010.

   Aclaraciones sobre las búsquedas:

   - Las búsquedas no deben ser “case sensitive”.
   - Los libros pueden cumplir parcialmente con la búsqueda y pertenecer igualmente al resultado (por ejemplo, coincidencias parciales de nombre).
   - Las búsquedas siempre retornan una lista de libros, y nunca incluyen grupos.
   - Los resultados deben ordenarse según un criterio determinado especificado al momento de la búsqueda.

2. **Operaciones sobre los grupos**

   - **Cantidad de elementos**: Contar la cantidad de libros almacenados en la colección completa o en un grupo específico.
   - **Lista de palabras clave**: Obtener el listado de palabras clave de un grupo.
   - **Copia restringida de grupos**: Obtener una copia restringida de un grupo respetando su estructura original pero que contenga solo los libros que coincidan con un criterio. Si un grupo queda vacío, se retorna null.
   - **Impresión por pantalla**: Permitir imprimir los elementos del grupo en un orden establecido, con formato: (Año) Título – Autores - Editorial.



