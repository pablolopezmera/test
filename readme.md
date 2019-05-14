#Ambiente
- Virtual Box, Headless Start

#Template
1.- Descargar Liferay Westeros Bank Theme.lpkg del marketplace de Liferay
2.- Desplegar el lpkg en /Control Panel/Apps/App Manager/Upload
3.- Ir a /Control Panel/Sites/Site Templates
--> Seleccionar Westeros Bank Theme ... Manage
--> En Navigation/Pages eliminar las páginas del tema

#Sitio
1.- Crear sitio a partir del template 
--> /Control Panel/Sites/Sites/
2.- Asignar el mismo tema para las páginas privadas
--> /Control Panel/Sites/Sites/Coinatural
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
## 1.- Crear contexto para servicios Rest
--> /Control Panel/Configuration/System Settings/Foundation
CXF Endpoints, en Context Path agregar /rest
Rest Extender, en Context paths agregar /rest

## En "Control Panel / Configuration / Custom fields / Site" agregar los siguientes campos de texto:
- notification.address.from
- notification.address.to
- notification.confirmation.request
- notification.approved.subject
- notification.purchase.confirmation

## En "Control Panel / Configuration / Custom fields / Site" dar permisos de lectura al rol User:
- notification.address.from
- notification.address.to
- notification.confirmation.request
- notification.approved.subject
- notification.purchase.confirmation

## En "Control Panel / System Settings / Other / Coinatural Configuration" 
- Campo Site name poner el nombre del sitio, ejm: Coinatural

## Esconder la opción de búsqueda
On the search input click on Options / Permissions
2) Disable view for every role you want (guest, user and site member is a minimum I think)
3) In your portal-ext.properties add the following line :
layout.show.portlet.access.denied=false

#App Sitio Privado

style="background: #EFF3E6;"
class="upper-modules"
class="secondary-background-color"

# Proyectos
Desplegar los siguientes proyectos:
- user-profile:
	- address.portlet-1.0.0.jar
	- buy-1.0.0.jar
	- com.ec.virtualcoin.commmon-1.0.0.jar
	- user.profile.api-1.0.0.jar
	- user.profile.service-1.0.0.jar
	- users.admin-1.0.0.jar
	- identification.portlet-1.0.0.jar
	- quotation-1.0.0.jar
	- my.orders-1.0.0.jar
- create-account
	- com.liferay.blade.module.jsp.override-1.0.0.jar
- fixed.quotation-1.0.0.jar
- language.override-1.0.0.jar
- my-account-override
	- com.liferay.users.admin.web.ext-1.0.0.jar
	- users.admin.web.my.account-1.0.4.jar
- MyCustomLoginPortlet
	- mycustomloginportlet-1.0.0.jar

