## Examen 2ª evaluación.

* Se debe entregar para cada ejercicio el código fuente que se ha utilizado, así como los ficheros que resulten de la realización de los ejercicios.
* Se entrega por github.
* Cada 30 minutos se debe hacer un commit.
* La valoración de cada ejercicio pondera 80% obtener el resultado pedido y un 20% otros aspectos como la estructura y orden del código.
* Los ejercicios son 7 puntos sobre 10 del examen, los 3 puntos restantes corresponden al test.


1. (4 puntos) Se proporciona un programa que modela un servidor que admite la conexión de un cliente mediante socket TCP. Desarrollar el cliente apropiado que se conecte al servidor y le envíe una cadena de texto indicando que es un ejercicio del examen.


```java
import java.io.*;
import java.net.*;

public class TCPServer {

  public static void main(String[] arg) throws IOException {

	int portNumber = 5050; 

	ServerSocket server = new ServerSocket(portNumber);
	Socket client = null;

	System.out.println("Waiting for clients...");
	client = server.accept();


	InputStream input = null;
	input = client.getInputStream();
	DataInputStream inputData = new DataInputStream(input);
	System.out.println("RECEIVED FROM CLIENT: \n\t" + inputData.readUTF());

	
	OutputStream output = null;
	output = client.getOutputStream();
	DataOutputStream outputData = new DataOutputStream(output);
	outputData.writeUTF("Greetings from server side");

	input.close();
	inputData.close();

	output.close();
	outputData.close();

	client.close();
	server.close();
  }
}
```

2. (3 puntos) El siguiente código arroja excepciones de seguridad. Crea un fichero de políticas apropiado para que puedan leerse las propiedades. Entrega el fichero de políticas para que se puedan leer las propiedades incluidas en el array así como la salida que arroja la consola en un fichero de texto.

```java
public class SystemProperties {
	public static void main(String[] args) {	
		String t[] = { "os.name", "os.version",  "os.arch",
					"line.separator", "path.separator",
					"user.dir", "user.home", "user.name",
					"java.class.path", "java.home", 
					"java.vendor", "java.version" };
		
		//SecurityManager sm = new SecurityManager();
		//System.setSecurityManager(sm);
        
		for (int i = 0; i < t.length; i++) {
			System.out.print("Property:" + t[i]);
			try {
				String s = System.getProperty(t[i]);
				System.out.println("\t==> " + s);
			} catch (Exception e) {
				System.err.println("\n\tException " + e.toString());
			}
		}
	}
}
```

```
Ejemplo llamada por línea de comandos para ejecutar con SecurityManager.

java -classpath <ruta_carpeta_clases>/bin/ 
	-Djava.security.manager -Djava.security.policy=<fichero.policy> <package.nombre_clase>
	-Dfile.encoding=UTF-8 -classpath <ruta_carpeta_clases>/bin <package.nombre_clase>
```