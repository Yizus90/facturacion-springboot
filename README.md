# Sistema de Facturación

Proyecto desarrollado en **Spring Boot** con conexión a **MySQL**, usando **Thymeleaf** y **Bootstrap**.  
Actualmente, implemente un **CRUD de Clientes** y se expandirá con Productos, Facturación y entre otras cosas que se me ocurran.

## Tecnologías
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL 8
- Thymeleaf
- Bootstrap

## Funcionalidades
- En lista de clientes tiene un CRUD (listar, agregar, editar, eliminar).
- Nuevo cliente: Validado según su campo, el buton de guardar y cancelar son funcionales.
- Los clientes añadidos se guardan en la DB MySQL, y se actualizan o eliminan según corresponda.
- Próximamente: CRUD de Producto, Facturas y Detalle de Factura.

## Estrategia de branching
Se utiliza **feature branching**:
- `main` → rama principal, estable.
- `feature-*` → ramas para nuevas funcionalidades.