package martes2_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServidorEjemplo2 {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket socket =  new DatagramSocket(12345);
        
        System.out.println("Servidor esperando datagrama...");
        DatagramPacket recibo;
        
        byte[] buffer =  new byte[1024];
        recibo =  new DatagramPacket(buffer,buffer.length);
        socket.receive(recibo);
        
        String mensaje = new String(recibo.getData()).trim();
        System.out.println("Servidor recibe: "+mensaje);
        
        int contador=0;
        for(int i=0;i<mensaje.length();i++){
            if(mensaje.charAt(i)=='a' || mensaje.charAt(i)=='A'){
                contador++;
            }
        }
        
        InetAddress ipOrigen = recibo.getAddress();
        int puerto =  recibo.getPort();
        
        System.out.println("Enviando numero de apariciones de la letra a=> "+contador);
        byte b = (byte) contador;
        byte[] enviados = new byte[1024];
        enviados[0] = b;
        
        DatagramPacket envio =  new DatagramPacket(enviados,enviados.length,ipOrigen,puerto);
        socket.send(envio);
        System.out.println("Cerrando conexion...");
        socket.close();   
        
    }
}
