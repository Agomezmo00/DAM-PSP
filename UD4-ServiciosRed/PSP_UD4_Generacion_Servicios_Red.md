# Generación de Servicios en Red

## Introducción

*Un servicio de red es la creación de una red de trabajo en un ordenador. Generalmente los servicios de red son instalados en uno o más firewalles del servidor seleccionado. Eso facilita el uso y el fallo de muchos usuarios.* [Wikipedia, Servicios de red](https://es.wikipedia.org/wiki/Servicio_de_red)

Además, puede decirse que son programas auxiliares utilizados para gestionar recursos. Cabe pensar en la utilización que se hace de herramientas que se utilizan de forma remota: una impresora en red, el intercambio de ficheros, etc. Todos ellos constituyen ejemplos de servicios de red. El esquema más habitual de arquitectura en este tipo de servicios es cliente-servidor.

## Protocolos estándar de comunicación en red a nivel de aplicación (ftp, http, pop3, smtp, telnet).

A partir del modelo TCP/IP se constituyen toda una serie de servicios o aplicaciones en los niveles más altos del esquema OSI. Por poner unos ejemplos:

* TELNET (Conexión remota)
* FTP (File Transfer Protocol)
* SNMP (Simple Network Management Protocol)
* SMTP (Simple Mail Transfer Protocol)
* HTTP o HTTPS (Hiper Text Transfer Protocol (Secure))

Otras herramientas como DNS o TFTP pueden estar basadas en el protocolo UDP y también son servicios de red. Se suelen considerar habitualmente de la misma familia que los anteriores.

## Protocolo FTP

*El Protocolo de transferencia de archivos (en inglés File Transfer Protocol o FTP) es un protocolo de red para la transferencia de archivos entre sistemas conectados a una red TCP (Transmission Control Protocol), basado en la arquitectura cliente-servidor. Desde un equipo cliente se puede conectar a un servidor para descargar archivos desde él o para enviarle archivos, independientemente del sistema operativo utilizado en cada equipo.* [Wikipedia, Protocolo FTP](https://es.wikipedia.org/wiki/Protocolo_de_transferencia_de_archivos)

### Acceso anónimo y autorizado

* Anónimo:  La comunicación se realiza sin ningún tipo de identificación y, por lo tanto el usuario tendrá muy pocos privilegios en el servidor. En este caso, el usuario estará confinado en un directorio público donde puede descargar los archivos allí ubicados pero sin posibilidad de escribir o modificar ningún fichero.

* Autorizado:  El usuario establece la comunicación con una cuenta de usuario. Tras identificarse, se dirige al usuario a su directorio predeterminado desde el que puede descargar ficheros y escribir si está autorizado. Este tipo de acceso es el habitual a la hora de gestionar los contenidos de servidores web.

### Comunicación con el servidor FTP

Este protocolo utiliza dos conexiones diferentes, una para el control y otra para la transferencia de los datos. La primera establece y mantiene la comunicación cliente-servidor y la segunda ejecuta las transferencias de información. Mientras que la primera está abierta mientras dura la sesión, la segunda solo se produce cuando hay transferencia de información. Ambas usan puertos diferentes 21 y 20 respectivamente del lado del servidor y aleatorios en el cliente, suele ser lo más habitual. El cliente tiene dos modos de actuar, activo y pasivo.


* Modo Activo

Es el modo FTP estándar o PORT, donde el cliente envía comandos tipo PORT al servidor al establecer la conexión.

En el modo activo el servidor siempre crea el canal de datos en su puerto 20, mientras que el cliente se asocia a un puerto aleatorio mayor a 1024.

Para esto, el cliente envía un comando PORT al servidor por el canal control, indicando el número de puerto, para así lograr la conexión de datos para la transferencia de los archivos.

Este tipo de FTP tiene un grave problema de seguridad; el cliente puede aceptar cualquier conexión de entrada lo que la vuelve susceptible.

Los equipos con cortafuegos, rechazan estas conexiones aleatorias.

![alt-text](http://www.worldofintegration.com/sites/default/files/pictures_for_content/WOI_protocols/FTPactive.JPG "Esquema Modo Activo. Fuente: http://www.worldofintegration.com/sites/default/files/pictures_for_content/WOI_protocols/FTPactive.JPG")


* Modo Pasivo

En el modo pasivo, es siempre el programa del cliente quien inicia la conexión con el servidor.

El cliente en el modo pasivo inicia ambas conexiones (control y datos), por lo que la conexión no es filtrada por el cortafuegos.

Una vez creada la primera conexión, el cliente pasa a modo pasivo enviando el comando PASV y pidiendo un puerto abierto al servidor, para así establecer la conexión final.

En este caso, no se utiliza el canal de datos del puerto 20 del servidor, a diferencia de como ocurre siempre en el modo activo.

Antes de cada nueva transferencia en cualquiera de los modos, el cliente debe enviar otra vez un comando control, ya sea PORT o PASV.


![alt-text](http://www.worldofintegration.com/sites/default/files/pictures_for_content/WOI_protocols/FTP_Passive.jpg "Esquema Modo Pasivo. Fuente: http://www.worldofintegration.com/sites/default/files/pictures_for_content/WOI_protocols/FTP_Passive.jpg")

#### Códigos de respuesta en FTP

FTP utiliza un esquema de códigos de respuesta donde cada dígito tiene un significado concreto. Son números en ASCII de tres dígitos (XYZ) y significan lo siguiente


X: Indica si la respuesta es buena, mala o incompleta.

1 = Preliminar positiva 
2 = Completamente positiva 
3 = Positiva intermedia 
4 = Negativa transiente 
5 = Negativa permanente

Y: especifica el tipo de respuesta:

1 = Status de archivo o help 
2 = Status de conexión 
3 = Información de usuario 
4 = No especificada 
5 = Acción no tomada

Z: Mayor detalle sobre la respuesta, por ejemplo:

120   Servicio listo en nnn minutos (1XX) 
200   comando OK (2XX) 
230   User login correcto 
331   Login de usuario correcto, necesita password (3XX) 
425   No puede establecerse la conexión de datos (4XX) 
500   Error de sintaxis, comando no reconocido (5XX)

[Listado Wikipedia EN](https://en.wikipedia.org/wiki/List_of_FTP_server_return_codes)


### Cliente FTP en Java

Se modela básicamente mediante dos clases *[FTPClient](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ftp/FTPClient.html)* y *[FTPReply](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ftp/FTPReply.html)* ambas de la librería [Apache Commons Net](http://commons.apache.org/proper/commons-net/)

Otra clase importante en la gestión de ficheros es *[FTPFile](https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ftp/FTPFile.html)*

Vemos ejemplos de código. 

[Ejemplo Descarga Carpeta](https://es.stackoverflow.com/questions/115650/descargar-una-carpeta-de-ftp-desde-java-usando-ftpclient-apache-commons-net)


### Servidor FTP en Java

## Protocolo SMTP
## Servidores de ficheros
