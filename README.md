# Backend De Encuesta de estilos musicales

Este proyecto corresponde al backend de la encuesta de preferencias musicales de los usuarios. Fue hecho en Java con el framework Spring 

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.

### Pre-requisitos 📋

_Que cosas necesitas para instalar el software y como instalarlas?_

Necesitas tener preferentemente el IDE Spring Tool Suite o cualquier IDE compatible con JAVA si es Eclipse bajar plugin para spring, contar con OpenJDK  o JDK.
Este proyecto fue hecho con OpenJDK 18. Tener cualquier tipo de base de datos en el computador ( En este proyecto se trabajo con MySQL). Tener instalado  en el IDE
la libreria Lombok. Lo anterior no es obligatoio ya que es para evitar hacer manual los getter y setter y el constructor de las clases. Se debe contar con Postman
o cualquier software para probar las rutas de la API. Ver en el proyecto la siguiente ruta de carpeta (se llama encuessta) : src/main/resources/application.properties en
este ultimo archivo modificar los parametros de conexion a la base de datos segun sea la preferencia.

### Instalación 🔧

1. Una vez que se descarga el proyecto se debe ejecutar en el IDE 
2. En postman se debe seguir los siguientes pasos:
       . Señalar que se hara un Post,Get,Put o Delete
        - Para hacer las pruebas las rutas son:
         Para Usuarios:
         
         -POST :localhost:8080/api/usuarios
         -GET Pa ver la lista total de usuarios :localhost:8080/api/usuarios
         -PUT: localhost:8080/api/usuarios/id
         -DELETE: ocalhost:8080/api/usuarios/id
         -GET para buscar un usuario en especifico: ocalhost:8080/api/usuarios/id
         -GET para ver la tendencia de los gustos musicales de los usuarios: http://localhost:8080/api/usuarios/tendencia
         -Get para ver las tendencias o gustos musicales que servira para elegir un gusto musical en el formulario de 
          la encuesta.
          -Get para ver la cantidad de registros ingresados: localhost:8080/api/usuarios/cantidad
          -Get para ver por paginas los resultados: localhost:8080/api/usuarios/page/id
         - Donde id es el identificador del usuario
         - En id es autoincremental.
   Para  Estilos musicales (los estilos musicales fueron igresados en un archivo sql llamado import.sql asi que no se ingresan en el sistema)
        
         -POST :localhost:8080/api/estilosMusicales
         -GET Pa ver la lista total de estilos musicales: localhost:8080/api/estilosMusicales
         -PUT: localhost:8080/api/estilosMusicales/id
         -DELETE:localhost:8080/api/estilosMusicales/id
         -Get para ver por paginas los resultados: localhost:8080/api/estilosMusicales/page/1
 _Ejemplo de obtener datos del API REST_
 
 1 Get a localhost:8080/api/usuarios/tendencia para obtener la cantidad de usuarios que elegieron algun gusto musical
 
[
    [
        1,
        "Rock"
    ],
    [
        1,
        "Jazz"
    ],
    [
        3,
        "Kpop"
    ],
    [
        2,
        "Romantica"
    ]
]
2. Post (para ingersar el suaurio) localhost:8080/api/usuarios resultado: 

{
    "usuario": {
        "id": 9,
        "mail": "master2025@gmail.com",
        "tipoMusica": {
            "id": 7,
            "estiloMusical": "Romantica"
        }
    },
    "mensaje": "El usuario ha sido creado éxito! "
}

Cual quier usuario puede hacer uso de la api para ver los endpoint ya que no 
 
 ## Construido con 🛠️
 _Herramientas utilizadas_
 *[spring IDE](https://spring.io/tools) -Es el IDE que se ocupo para manejar el framework de spring
 *[Maven](https://maven.apache.org/) - Manejador de dependencias

