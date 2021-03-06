# Manejo de procesos con Java

- [Ejecutar una aplicación](https://github.com/franlu/DAM-PSP/blob/master/creacion_procesos/ejecutarApp.java)
- [Lanzar un proceso-aplicación](https://github.com/franlu/DAM-PSP/blob/master/creacion_procesos/lanzadorProceso.java)
- [Sumar](https://github.com/franlu/DAM-PSP/blob/master/creacion_procesos/Sumador.java) Clase para sumar valores enteros consecutivos.
- [Lanzador](https://github.com/franlu/DAM-PSP/blob/master/creacion_procesos/Lanzador.java) Se ejecuta un proceso que utiliza la clase anterior.
- [Leer Stream](https://github.com/franlu/DAM-PSP/blob/master/creacion_procesos/LanzadorStreamSalida.java) Lee el stream de salida del proceso.

**Actividad:** Crea un programa que admita argumentos desde el main y devuelva con  ```System.exit()``` los siguientes valores:
- Sí el número de argumentos es menor que 1 debe devolver 1.
- Si el argumento es una cadena debe devolver 2.
- Sí el argumento es un número entero menor que 0 debe devolver 3.
- En cualquier otra situación debe devolver 0.
	
A continuación, crea otro programa que ejecute al anterior. Deberá mostrar en pantalla lo que pasa dependiendo del valor devuelto al ejecutar el programa anterior.	

**Actividad:** Crea un programa en Java que visualice 5 veces la cadena que se le envía desde los argumentos de ```main()```. Si no se le envia ninguna cadena que muestre un mensaje indicándolo y que finalice le programa con ```System.exit(1)```.
A continuación, crea un segundo programa Java que introduzca por teclado una cadena y ejecute el programa anterior para visualizar 5 veces esa cadena.

#### Enviar datos al stream de entrada del proceso

- [Enviar datos](https://github.com/franlu/DAM-PSP/blob/master/creacion_procesos/EnviarDatos.java).

#### Redireccionando la salida

- [Redireccionar](https://github.com/franlu/DAM-PSP/blob/master/creacion_procesos/RedireccionarSalida.java)

**Actividad:** Escribe un programa que lea cadenas desde la entrada estándar hasta escribir un ```*```. Escribe otro programa que ejecute el anterior.

Modifica el programa anterior para que al ejecutar el programa la entrada al proceso se obtenga a partir de un fichero de texto.