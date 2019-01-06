#Ambiente
- Virtual Box, Headless Start

#Template
1.- Descargar Liferay Westeros Bank Theme.lpkg del marketplace de Liferay
2.- Desplegar el lpkg en /Control Panel/Apps/App Manager/Upload
3.- Ir a /Control Panel/Sites/Site Templates
--> Seleccionar Westeros Bank Theme ... Manage
--> Quitar Search en show-main-search opción no-screen
--> En Navigation/Pages eliminar las páginas del tema

#Sitio
1.- Crear sitio a partir del template 
--> /Control Panel/Sites/Sites/
2.- Asignar el mismo tema para las páginas privadas
--> /Control Panel/Sites/Sites/Coinatural
--> Cambiar Tema
--> Quitar Search en show-main-search opción no-screen

#Páginas privadas
1.- Administración de usuarios, portlet Coinatural / users-admin 
	A esta página quitar permisos de View y Add al rol Site member
#Páginas Públicas
1.- Añadir páginas públicas 
--> /Coinatural/Navigation/Public Pages/Add Public Pages
2.- Cambiar Logotipo
--> /Coinatural/Navigation/Public Pages/Configure/Look and Feel/Logo

#Configuración
1.- Crear contexto para servicios Rest
--> /Control Panel/Configuration/System Settings/Foundation
CXF Endpoints, en Context Path agregar /rest
Rest Extender, en Context paths agregar /rest

En "Control Panel / Configuration / Custom fields / Site" agregar los siguientes campos de texto:
- notification.address.from
- notification.address.to

En "Control Panel / System Settings / Other / Coinatural Configuration" 
- Campo Site name poner el nombre del sitio, ejm: Coinatural

#App Sitio Privado

style="background: #EFF3E6;"
class="upper-modules"
class="secondary-background-color"

# Proyectos
Se deben desplegar los siguientes proyectos
- quotation: Presenta la pantalla de cotización de btc actual, requiere del proyecto common
- fixed-quotation: Presenta una pantalla de cotizaciones fijadas, se puede configurar con valores predeterminados en configuración del portlet
- buy: Permite a un usuario registrado comprar btc, se presenta en el menu izquierdo del perfil del usuario
