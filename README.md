# Repositorio - tdx-microservices-mongodb 


## Table of Contends
<details>
  <summary>Table of Contends</summary>
  <ol>
    <li>About The Project</li>
    <li>Built With</li>
    <li>Getting Started</li>
    <li>Prerequisites</li>
    <li>Installation</li>
    <li>Usage</li>
    <li>License</li>
    <li>Contact</li>
  </ol>
</details>

## About The Project

El proyecto se encuentra en el marco de desarrollo de JAVA utilizando la tecnología de SPRINGBOOT lo cual permite compilar nuestras aplicaciones Web.

Actualmente el microservicio `tdx-microservices-mongodb`  permite realizar peticiones de los métodos mas comunes de http (GET, POST, PUT, DELETE).

Los datos son almacenados en una BD no relacional. Este proyecto se utilizó como BD `mongodb`

El proyecto `tdx-microservices-mongodb`, permite realizar las operaciones `CRUD` de una lista de documentos.


```
"identityDocument": {
 "number": "112380912",
 "expiryDate": "09/22",
 "emissionDate": "2021-05-17T00:00:00.000Z",
 "documentType": {
 "code": "CI",
 "name": "Cédula de identidad."
 }
```

<p align="right">(<a href="#top">back to top</a>)</p>

## Built With

El proyecto está construido con las siguientes tecnologías: 

* [SpringBoot](https://spring.io)
* [MongoDB](https://www.mongodb.com)
* [Docker](https://www.docker.com)

<p align="right">(<a href="#top">back to top</a>)</p>

## Getting Started

Instrucciones de cómo configurar el proyecto localmente.

### Prerequisites

Software adicional
* IDE Eclipse
* Docker Desktop
* Postman

### Installation

* 1. Clonar el repositorio

```
   git clone https://github.com/angelvcuenca/tdx-microservices-mongodb
```

El proyecto se puede compilar de 2 formas mediante el IDE Eclipse o con Contenedore de Docker

`IDE Eclipse`

* 1. Importar el proyecto en el IDE eclipse
* 2. Run proyect

`Docker`
* 1. Ubicarse en la raiz del proyecto
* 2. Ejecutar el siguiente comando

```
	docker-compose up
```
El comando ejecutado creara las imágenes correspondientes para utilizar el proyecto.


<p align="right">(<a href="#top">back to top</a>)</p>

### Usage
Url's de los recursos a consumir:


* [Autenticación - POST]

```
* [URL]

	http://localhost:8080/api/v1/auth

* [Request - Body | x-www-form-urlencoded]		
		key: username  -> value: tdx_user
		key: password  -> value: tdx_pwd		 	
* [Reponse]
	{
		"username": "tdx_user",
		"password": null
		"token": generate jwtToken
 	}
```

* [All Documents - GET]

```
* [URL]
	http://localhost:8080/api/v1/allDoc
* [Headers]
	Authorization : generated jwtToken	
* [Reponse]
	List Array of Documents
	{
	 "number": "112380912",
	 "expiryDate": "09/22",
	 "emissionDate": "2021-05-17T00:00:00.000Z",
	 "documentType": 
	 	{
		 "code": "CI",
		 "name": "Cédula de identidad."
 		}
 	},
	{
	 "number": "112380912",
	 "expiryDate": "09/22",
	 "emissionDate": "2021-05-17T00:00:00.000Z",
	 "documentType": 
	 	{
		 "code": "CI",
		 "name": "Cédula de identidad."
 		}
 	}
```


* [Create Documents - POST]

```
* [URL]
	http://localhost:8080/api/v1/createDoc
* [Headers]
	Authorization : generated jwtToken
* [Request - Body - Rwa | Json]
	{
	 "number": "112380912",
	 "expiryDate": "09/22",
	 "emissionDate": "2021-05-17T00:00:00.000Z",
	 "documentType": 
	 	{
		 "code": "CI",
		 "name": "Cédula de identidad."
 		}
 	}
* [Reponse]	
	{
	 "number": "112380912",
	 "expiryDate": "09/22",
	 "emissionDate": "2021-05-17T00:00:00.000Z",
	 "documentType": 
	 	{
		 "code": "CI",
		 "name": "Cédula de identidad."
 		}
 	}
```
* [Update Documents - PUT]

```
* [URL]
	http://localhost:8080/api/v1/updateDoc/{_idDocument}
* [Headers]
	Authorization : generated jwtToken
* [Request - Body - Rwa | Json]
	{
	 "number": "112380912",
	 "expiryDate": "09/22",
	 "emissionDate": "2021-05-17T00:00:00.000Z",
	 "documentType": 
	 	{
		 "code": "CI",
		 "name": "Cédula de identidad."
 		}
 	}
* [Reponse]	
	{
	 "number": "112380912",
	 "expiryDate": "09/22",
	 "emissionDate": "2021-05-17T00:00:00.000Z",
	 "documentType": 
	 	{
		 "code": "CI",
		 "name": "Cédula de identidad."
 		}
 	}
```
* [Delete Documents - DELETE]

```
* [URL]
	http://localhost:8080/api/v1/deleteDoc/{_idDocument}
* [Headers]
	Authorization : generated jwtToken
* [Reponse]	
	{	}
```

## License
Distribuido bajo la licencia MIT. Consulte `LICENSE.txt` para obtener más información.

<p align="right">(<a href="#top">back to top</a>)</p>


## Contact

Developer Name - [angelvcuenca@gmail.com](angelvcuenca@gmail.com) - Angel Cuenca

Project Link: [https://github.com/angelvcuenca/tdx-microservices-mongodb](https://github.com/angelvcuenca/tdx-microservices-mongodb)

<p align="right">(<a href="#top">back to top</a>)</p>

