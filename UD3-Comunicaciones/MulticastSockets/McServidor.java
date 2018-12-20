import java.io.*; 
import java.net.*; 
 
public class McServidor { 
  public static void main(String args[]) throws Exception { 
    // FLUJO PARA ENTRADA ESTANDAR
    BufferedReader in = new 
                BufferedReader(new InputStreamReader(System.in));
    
    int puerto = 6789;
    
    //Se crea el socket multicast. 
    MulticastSocket ms = new MulticastSocket(puerto); 
    
    InetAddress grupo = InetAddress.getByName("225.26.38.12");//Grupo

    String cadena="";

    while(!cadena.trim().equals("*")) {            
      System.out.print("Datos a enviar al grupo: "); 
      cadena = in.readLine();		  
	// ENVIANDO AL GRUPO
	DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
	System.out.println("enviado");
      ms.send (paquete); 
    }
    ms.close ();//cierro socket
    System.out.println ("Socket cerrado...");
   } 
} 