## Manejo de perfil de usuario.

###Componentes:
- addres-portlet: permite a un usuario modificar sus datos de dirección
- identification-portlet: permite a un usuario modificar sus datos de identificación
- user-profile-api: api para acceso a datos de perfil de usuario
- user-profile-service:  servicios de acceso adatos de perfil de usuario
- users-admin: portlet para aprovación y denegación de usuarios

### Construcción

Generar servicios: ./gradlew buildService
Generar artefactos: ./gradlew build