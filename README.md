# principlesanddesignpatterns

## Funciones Principales

- Creacion de Productos
- Registro de Ordenes
- Cambio de Estado de Ordenes
- Generacion de Reportes

## Arquitectura Aplicada

La arquitectura que se siguio para la implementacion de este proyecto es la arquitectura Hexagonal donde se separo de la siguiente forma

- **Dominio**: Logica del Negocio
- **API**: Exposicion de Endpoints creados

## Tecnologias Utilizadas

- Java 17
- SpringBoot 3.4.4
- Spring Data JPA
- Swagger
- MYSQL

## Requisitos Previos

- Instalar Gradle para la administracion de dependencias
- Instalar MYSQL para la base de datos
- Crear una base de datos en MYSQL (Ej. project_module5)
- Modificar el Archivo aplication.properties siguiendo las siguientes instrucciones:
    - jdbc:mysql://localhost:3306/{Nombre_Base_Datos}?useSSL=false&serverTimezone=UTC
    - username = Usuario configurado para MYSQL (o usar el root)
    - password = Contraseña de usuario en MYSQL

## Pasos para ejecutar el proyecto

### Clonar el Repositorio
- git clone https://github.com/sergioale1990/principlesanddesignpatterns

### Compilar y correr

- Ejecutar en la consola el comando ./gradlew bootRun

### Ingreso para probar API

- Ingresar a la URL http://localhost:8080/swagger-ui.html
- O usar POSTMAN para prueba de EndPoints