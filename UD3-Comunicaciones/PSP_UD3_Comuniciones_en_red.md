#Programación de comunicaciones en red

##Introducción
##Clases Java para comunicaciones en red

TCP/IP es una familia de protocolos para permitir la comunicación entre cualquier par de ordenadores de cualquier red o fabricante, respetando los protocolos de cada red individual. Afecta a 4 capas:

###Niveles OSI
* Físico
* Enlace
	* Es la interfaz con la red real. Comunica la capa de red con la física (el hardware).
* Red
	* Se dedica a seleccionar la mejor ruta para el envio de paquetes por la red. Protocolo IP.
* Transporte
	* Suministra a las aplicaciones un servicio de comunicaciones e2e mediante dos protocolos: TCP y UDP
* Sesión
* Presentación
* Aplicación
	* Son las aplicaciones que están disponibles para los usuarios: FTP, SMTP, TELNET...


Los equipos conectados a internet utilizan el procotolo TCP o UDP. Hay alguna diferencia entre ambos.

* TCP: Orientado a conexión. Se busca garantizar que los paquetes lleguen y que lo hagan de forma ordenada (conforme han sido enviados).
* UDP: No Orientado a conexión. Se envian datagramas sin garantizar que lleguen ni que lo hagan de forma ordenada.

###Los puertos
TCP y UDP utilizan puertos para asignar datos entrantes a un proceso en particular que se ejecuta en una máquina. Los datos transmitidos a través de Internet identifican la máquina y el puerto al que van destinados. Se destinan 32 bits (IPv4) para la máquina y 16 para el puerto. TCP una aplicación de servidor vincula un socket a un número de puerto específico, lo que supone registrar el servidor en el sistema para recibir los datos destinados a ese puerto. Por otro lado, en UDP el número de puerto se adjunta al datagrama para llegar a la aplicación correcta.


##Las clases
Cuando se escriben programas en Java, se trabaja a nivel de aplicación y se abstraen los protocolos de red mediante las clases presentes en el package *java.net* que incluye varias clases:

* URL; Cuyos objetos representan un puntero a un recurso en la Web.
* URLConnection; Para operaciones más complejas en las URL.
* ServerSocket y Socket, para dar soporte a sockets TCP. ServerSocket se utiliza desde el lado del servidor para crear un socket en el puerto en el que escucha las peticiones de conexión de los clientes. Socket por su parte se utiliza tanto en cliente como en servidor para comunicarse entre sí leyendo y escribiendo datos mediante streams.
* DatagramSocket MulticastSocket y DatagramPacket para el uso del protocolo UDP.
* InetAddress para representar direcciones de Internet. Tiene dos subclases *Inet4Address* e *Inet6Address*, aunque en la mayoría de los casos con la clase principal suele ser suficiente. Algunos de los métodos más relevantes de *InetAddress* son:


###La clase InetAddress

Algunos de los métodos más relevantes de *InetAddress* son:

* InetAddress getLocalHost() Devuelve un objeto de InetAddress que representa la dirección IP de la máquina donde se está ejecutando el programa.
* InetAddress getByName(String host) Devuelve un objeto de InetAddress que representa la dirección IP de la máquina que se especifica como parámetro (host). Este parámetro puede se el nombre de la máquina, un nombre de dominio o una IP. *Es el más habitual para crear objetos de la clase*. 
* InetAddress[] getAllByName(String host) Devuelve un array de InetAddress. Sirve para obtener todas las IP que tenga asignadas una máquina concreta.
* String getHostAddress() Devuelve la dirección IP de un objeto InetAddress en forma de cadena.
* String getHostName() Devuelve el nombre del host de un objeto InetAddress.
* String getCanonicalHostName() Obtiene el nombre canónico completo (suele ser la dirección real del host) de un objeto InetAddress.















