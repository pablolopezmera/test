## Manejo de perfil de usuario.

###Componentes:
- addres-portlet: permite a un usuario modificar sus datos de dirección, se presenta como opción del menú del usuario
- identification-portlet: permite a un usuario modificar sus datos de identificación
- user-profile-api: api para acceso a datos de perfil de usuario
- user-profile-service:  servicios de acceso adatos de perfil de usuario
- users-admin: portlet para aprobación, denegación de usuarios y configuración del nombre del sitio (a este sitio se atan los usuarios creados)

### Construcción

Generar servicios: ./gradlew buildService
Generar artefactos: ./gradlew build
