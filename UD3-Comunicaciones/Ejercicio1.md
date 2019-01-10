## Ejercicio comunicaciones en red

Elabora un programa servidor con interfaz gráfica ue escuche en el puerto 54321. Cada vez que se conecte un cliente se deberá crear un hilo que lo gestione. Además, se deberá mostrar la IP del cliente y se deberá informar que el cliente se ha desconectado cuando lo haga.

En el hilo que debe gestionar a los clientes recibiendo sus mensajes, mientras que el cliente no envíe la palabra __adios__, se le devolverá el mensaje que haya enviado, pero del revés. Por ejemplo, si el cliente envía _hola_, recibirá _aloh_.

En el programa cliente, se debe por lo tanto recoger el texto a enviar y mostrar el recibido invertido.