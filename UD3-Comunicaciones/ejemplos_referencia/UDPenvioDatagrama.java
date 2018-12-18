import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPenvioDatagrama{
  public static void main(String[] argv) throws Exception {
	  int port = 12345; //puerto por el que escucha
	  InetAddress destino = InetAddress.getLocalHost();//IP host local

	  byte[] mensaje = new byte[1024]; //matriz de bytes      
	  String Saludo = "Enviando Saludos !!";
	  mensaje = Saludo.getBytes();  //codificarlo a bytes para enviarlo
	   
	  //construyo el datagrama a enviar
	  DatagramPacket envio = new DatagramPacket
		                  (mensaje, mensaje.length, destino, port);

      DatagramSocket socket = new DatagramSocket(34567);
	  socket.send(envio);//envio datagrama a destino y port
	  
	  socket.close();

  }
}

   