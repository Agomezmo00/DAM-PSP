# Técnicas de programación segura

## Introducción

Entre las técnicas más importantes para asegurar los sistemas y aplicaciones informáticas están la criptografía, los certificados digitales y el control de acceso.

Además, existen una serie de buenas prácticas que debemos conocer a la hora de escribir código de manera que podamos mejorar la seguridad del mismo.

En Java existen herramientas tanto para implantar los mecanismos de criptografía, sockets seguros, servicios de autenticación y autorización.

## Buenas prácticas de programación segura

* Conocer fallos que hayan podido cometer otros para evitarlos, estar informado.
* Tomar precauciones en el manejo de la información
* Revisión profunda de los procesos.
* Listas de control de seguridad.
* Reutilización de código comprobado.
* Puesta en valor del mantenimiento de software.
* Entender bien el problema para crear un diseño correcto.
* Elegir la tecnología más adecuada que se conozca o que se pueda investigar.
* Evitar copiar y pegar código de terceros a menos que se entienda bien su cometido. Copiar != reutilizar.
* Asegurar en la medida de lo posible que las librerías o frameworks que se utilicen no estén comprometidas por vulnerabilidades conocidas.

### Cuestiones a tener en cuenta para crear programas seguros

* Tener en cuenta a los usuarios. Son el eslabon más débil.
* No aceptar deadlines imposibles, que pasen por alto la calidad y/o seguridad.
* *You get what you pay for*.
* *Low cost = Low Quality*.

## Malas prácticas de programación

* Usar rutas relativas de ficheros. Son preferibles las absolutas.
* Hardcodear nombres de ficheros.
* Utilizar almacenamiento con permisos de escritura (permitiría el borrado, etc.).
* Almacenar datos confidenciales en bases de datos no protegidas.
* Mostrar el eco de passwords.
* Facilitar password por email.
* Almacenar o enviar passwords (u otra información sensible) sin cifrar.
* Establecer criterios de acceso en función de variables de entorno u otros parámetros pasados en tiempo de ejecución.
* Evitar confiar en terceros (software o servicios) en situaciones críticas.
* *Confiar* en los usuarios.
* ...

## Técnicas de seguridad

*El activo más importante que se posee es la información y, por lo tanto, deben existir técnicas que la aseguren, más allá de la seguridad física que se establezca sobre los equipos en los cuales se almacena. Estas técnicas las brinda la seguridad lógica que consiste en la aplicación de barreras y procedimientos que resguardan el acceso a los datos y solo permiten acceder a ellos a las personas autorizadas para hacerlo.*

*Cada tipo de ataque y cada sistema requiere de un medio de protección o más (en la mayoría de los casos es una combinación de varios de ellos).* [Fuente](https://es.wikipedia.org/wiki/Seguridad_informática#Técnicas_para_asegurar_el_sistema)

### Criptografía

*Básicamente, la criptografía es la técnica que protege documentos y datos. Funciona a través de la utilización de cifras o códigos para escribir algo secreto en documentos y datos confidenciales que circulan en redes locales o en internet. Su utilización es tan antigua como la escritura. Los romanos usaban códigos para ocultar sus proyectos de guerra de aquellos que no debían conocerlos, con el fin de que sólo las personas que conocían el significado de estos códigos descifren el mensaje oculto.*

*A partir de la evolución de las computadoras, la criptografía fue ampliamente divulgada, empleada y modificada, y se constituyó luego con algoritmos matemáticos. Además de mantener la seguridad del usuario, la criptografía preserva la integridad de la web, la autenticación del usuario así como también la del remitente, el destinatario y de la actualidad del mensaje o del acceso.* [Fuente](https://tecnologia-informatica.com/que-es-la-criptografia/)

En la imagen, se describe el proceso general para cifrar y descifrar mensajes. Los elementos a tener en cuenta son la __clave__ y el __algoritmo criptográfico__ que permiten obtener el texto cifrado a partir del texto legible y viceversa.

![alt text][crypto]

[crypto]: https://cdncontribute.geeksforgeeks.org/wp-content/uploads/Encryption_vs_Encoding_vs_Hashing_1.png "Esquema básico de cifrado/descifrado. Fuente: https://cdncontribute.geeksforgeeks.org/wp-content/uploads/Encryption_vs_Encoding_vs_Hashing_1.png"

#### Existen 3 grupos principales de algoritmos criptográficos.

Estos algoritmos, como ya se ha visto, modifican los datos con el objetivo de proporcionar características de seguridad tales como la integridad, confidencialidad o autenticación. [Tipos de criptografía](https://www.genbeta.com/desarrollo/tipos-de-criptografia-simetrica-asimetrica-e-hibrida)

##### Criptografía simétrica

Se basa en la utilización de __una sola clave__ para cifrar y descifrar los mensajes. De aquí resulta obvio que dicha clave debe permanecer lo más secreta posible.

El principal inconveniente es que emisor y receptor han de conocer previamente la clave para poder intercambiar información.

##### Criptografía asimétrica

Se basa en la utilización de __pares de claves__ para encriptar la información. Una de las claves permite cifrar la información y es pública, mientras que la otra permite descifrar y es privada o secreta. El funcionamiento es que un actor crea el par de claves y difunde la pública, para que otros cifren la información que desean enviarle, y al recibirla, descifrar mediante la clave privada.

La principal ventaja es que nadie necesita conocer la clave privada para poder cifrar la información. La desventaja es que es más lento.

* [Generación de claves en Windows](https://www.siteground.es/kb/generar-clave-ssh-windows/)

##### Funciones Hash

También denominadas [funciones de resumen](https://es.wikipedia.org/wiki/Función_hash). Reciben una cadena de texto habitualmente y la convierten en una cadena de texto, habitualmente finita. Son funciones de un solo sentido, porque solo permiten cifrar la información, no descifrarla. Es decir, si tenemos una información x y le aplicamos la función hash f(x), este proceso es sencillo. Ahora bien, es prácticamente imposible obtener x a partir de f(x).

Este tipo de funciones se emplean por ejemplo en mecanismos de firma digital. Los algoritmos más utilizados de este tipo son [MD5](https://es.wikipedia.org/wiki/MD5) y los del tipo [SHA](https://es.wikipedia.org/wiki/Secure_Hash_Algorithm)


### Firma digital

El concepto es análogo al de la firma manuscrita tradicional. Su objetivo, por lo tanto, es asegurar la identidad del firmante. El método de firma más habitual o extendido es el [RSA](https://es.wikipedia.org/wiki/RSA), basado en las funciones hash ya comentadas.


El proceso es iniciado por el __emisor__ del mensaje, quien genera un hash del mensaje *mh1*. Posteriormente se cifra dicho hash con una clave privada. El resultado de la operación de cifrado es lo que se denomina firma digital y se envía junto con el mensaje al que se quiere dar autenticidad de origen. 

El __receptor__ por su parte separa el mensaje de la firma que ha recibido, aplica la misma función de resumen que el emisor al mensaje, *mh2*. Descifra la firma mediante la clave pública del emisor, con lo que obtiene *mh1*. 

*mh1* y *mh2* deben ser iguales para garantizar la validez de la firma digital.



### Certificados digitales

El Certificado Digital es el único medio que permite garantizar técnica y legalmente la identidad de una persona en Internet. Se trata de un requisito indispensable para que las instituciones puedan ofrecer servicios seguros a través de Internet. 

* Permite la firma electrónica de documentos. El receptor de un documento firmado puede tener la seguridad de que éste es el original y no ha sido manipulado y el autor de la firma electrónica no podrá negar la autoría de esta firma.

* Permite cifrar las comunicaciones. Solamente el destinatario de la información podrá acceder al contenido de la misma.

* Consta de un par de claves criptográficas, una pública y una privada.

* El titular del certificado debe guardar cautelosamente la clave privada, ya que si ésta es sustraída, se podría suplantar su identidad en la red. En caso de pérdida o sustracción de la clave privada el titular debe __revocar__ el certificado lo antes posible.

* La clave pública forma parte de lo que se denomina Certificado Digital en sí, que es un documento digital que contiene la clave pública junto con los datos del titular, todo ello firmado electrónicamente por una __Autoridad de Certificación__, que es una tercera entidad que asegura que la clave pública se corresponde con los datos del titular.

* La Autoridad de Certificación se encarga de emitir los certificados para los titulares tras comprobar su identidad.

* El formato de los Certificados Digitales está definido por el estándar internacional [X.509](https://es.wikipedia.org/wiki/X.509).


### Control de acceso



* Identificación. El usuario provee datos de sí mismo.
* Autenticación. *La autenticación o autentificación1​es el acto o proceso de confirmar que algo (o alguien) es quien dice ser* [Fuente](https://es.wikipedia.org/wiki/Autenticación)
* Autorización. *Se usa para decidir si la persona, programa o dispositivo "X" tiene permiso para acceder al dato, funcionalidad o servicio Y.* [Fuente](https://es.wikipedia.org/wiki/Autorización)

[Protocolo AAA](https://es.wikipedia.org/wiki/Protocolo_AAA)

## Seguridad en Java

### [Introducción](https://www.uv.es/sto/cursos/seguridad.java/html/sjava-1.html)

* [JCA Referencia oficial EN](https://docs.oracle.com/javase/9/security/java-cryptography-architecture-jca-reference-guide.htm#JSSEC-GUID-2BCFDD85-D533-4E6C-8CE9-29990DEB0190)
* [JSSE Referencia oficial EN](https://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/JSSERefGuide.html)
* [JAAS Referencia oficial EN](https://docs.oracle.com/javase/8/docs/technotes/guides/security/jaas/JAASRefGuide.html)


## Recursos de buenas prácticas

[INCIBE](https://www.incibe.es)

[Desarrollo seguro OWASP](https://www.owasp.org/images/9/93/Desarrollo_Seguro_Principios_y_Buenas_Pr%C3%A1cticas..pdf)

[Buenas prácticas INCIBE](https://www.incibe.es/sites/default/files/contenidos/dosieres/metad_buenas_practicas_en_el_area_de_informatica.pdf)

[Consejos Desarrollo Seguro ](https://www.welivesecurity.com/la-es/2015/03/12/10-consejos-desarrollo-seguro-de-aplicaciones/)