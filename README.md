# 📝 Registro de Alumnos con Java Swing y MySQL

Este repositorio contiene un proyecto Java desarrollado con Java Swing para gestionar un sistema de registro de alumnos. La base de datos utilizada es **MySQL** y está alojada en **XAMPP**.

## 🛠️ Requisitos Previos

Antes de comenzar, asegúrate de contar con los siguientes elementos instalados en tu equipo:

- **Java JDK** (Versión recomendada: 8 o superior) ☕
- **XAMPP** (Para ejecutar el servidor MySQL) 🐬
- **IDE** (Como NetBeans o Eclipse) 💻

## ⚙️ Configuración de la Base de Datos

1. Inicia XAMPP y asegúrate de que el servidor MySQL esté en ejecución.
2. Importa la Base de Datos:
   - Accede a [http://localhost/phpmyadmin/](http://localhost/phpmyadmin/) desde tu navegador.
   - Crea una nueva base de datos llamada `gestion_alumnos` o selecciona una existente donde se importará el archivo.
   - Dirígete a la pestaña **Importar** y selecciona el archivo de base de datos que se encuentra en la carpeta `/BD` de este proyecto.
   - Ejecuta la importación para cargar las tablas y datos en el servidor MySQL.

## 🔌 Configuración en Java

Para conectar tu proyecto Java con la base de datos, sigue estos pasos:

1. **Agregar el archivo JAR de MySQL a las Librerías del Proyecto**:
   - En tu IDE, haz clic derecho en el proyecto y selecciona **Properties** (Propiedades).
   - Ve a la sección **Libraries** (Librerías).
   - Haz clic en **Add JAR/Folder...** y selecciona el archivo `.jar` que se encuentra en la carpeta `/jar` de este proyecto.
   - Esto agregará el conector MySQL necesario para establecer la conexión.

2. **Configurar los Parámetros de Conexión en tu código**:
   - Define el nombre de la base de datos (`gestion_alumnos`), usuario y contraseña que configuraste en XAMPP.
   - Usa el controlador `com.mysql.cj.jdbc.Driver` para la conexión.
   - Si tu configuración de MySQL tiene una contraseña para el usuario `root`, ajusta el código para incluirla en la conexión.

## 🚀 Ejecución del Proyecto

Después de completar los pasos anteriores:

- Compila y ejecuta el proyecto desde tu IDE.
- El proyecto debe conectarse a la base de datos MySQL en XAMPP y mostrar un mensaje de éxito si la conexión es establecida correctamente.

## 📂 Archivos Incluidos

- **/BD**: Contiene el archivo SQL para importar la base de datos en MySQL.
- **/jar**: Contiene el archivo `.jar` necesario para conectar Java con MySQL.

## 📚 Recursos Adicionales

Si necesitas más ayuda, consulta los siguientes recursos:

- [Documentación oficial de MySQL Connector/J](https://dev.mysql.com/doc/connector-j/8.0/en/)
- [XAMPP](https://www.apachefriends.org/index.html)
- [Documentación de JDBC en Java](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)

Con esta configuración, deberías tener una conexión estable entre tu aplicación Java y la base de datos MySQL en XAMPP. ¡Buena suerte! 🎉
