# Proyecto Seguridad                                                                         

Proyecto de seguridad semestre 2020-2

#### **Integrantes:**

* Jhusseth Sanchez
* Sebastian Rebolledo




# Uso

## **Interfaz principal:**

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Interfaz_Main.PNG) 



### La Interfaz principal cuenta con 3 opciones relevantes:

#### Crear llaves:

* Seleccionar directorio donde se almacenara la llave publica y privada:

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Create_Keys.PNG)



* Se crea la llave publica y la llave privada:

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Create_Keys_2.PNG)



#### Firmar archivos:

* En primer lugar se debe seleccionar el archivo que se va a firmar:

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Create_Signature.PNG)



* En segundo lugar se debe seleccionar la llave privada:

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Create_Signature_2.PNG)



* Luego se guarda el archivo que contiene la firma: 

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Create_Signature_3.PNG)



* Finalmente se crea la firma:

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Create_Signature_4.PNG)



#### Verificar Firma

* En primer lugar se debe seleccionar la llave publica:

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Verify_Signature.PNG)



* En segundo lugar se debe seleccionar el archivo que contiene la firma:

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Verify_Signature_2.PNG)



* Luego se debe seleccionar el archivo a verificar la firma:

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Verify_Signature_3.PNG)



* Finalmente se verifica la firma:

![alt text](https://github.com/Jhusseth/Proyecto_Seguridad/blob/main/Project_Security/docs/images/Verify_Signature_4.PNG)







# Informe

## Desarrollo del programa
 
 Para el desarrollo de este proyecto, pasamos a dividirnos los tres requerimientos encontrados en el enunciado. Las cuales  
 derivan las siguientes funcionalidades:
 - Creación de clave publica y privada
 - Generación de firma digital
 - Verificación de firma digital
 
 Luego realizamos la investigación para conocer como usar **la API criptográfica de Java** y poder implementarlo
 en el programa desarrollado.
 
 Hemos decidido relizar un interfaz grafica que le permita al usuario usarla facilmente. Por tanto, el usuario al iniciar el programa puede conocer facilmente cuales son 
 las mencionadas anteriormente, para que pueda elegir. 
         
                                                     
## Dificultades

Para relizar el presente proyecto no se presentaron muchas dificultades en los desarrollos indiviales, sin embargo en la 
integración de las funcionalidades presento ciertos inconvenientes al conectar con la interfaz grafica y al pensar como podria ser amigable al usuario.

Sin embargo listamos aqui las dificultades encontradas :

* Comprender el funcionamientos de los métodos que usa la API criptografica de Java para realizar las funcionalidad de firma de
archivos.

* Comprender las diferentes codificaciones que existen para exportar las llaves e importarlas. 

* Encontrar la manera correcta de leer los archivos para importar las claves.

* No supimos como ponerle clave al archivo de la clave privada.

* Realizar una interfaz grafica amigable con el usuario


## Conclusiones

* Es necesario saber, desde los diferentes lenguajes de programación como Java, implementar estrategias de seguridad. 

* Existen diferentes brechas de seguridad en las aplicaciones y es importante conocer las diferentes maneras que existen para sobrepasar esas brechas.

* Es necesario conocer como funcionan la seguridad de los archivos, haciendo uso de claves privadas y publicas para compartir información.


