package Martes26;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Mensajero {
    public static void main(String[] args) throws UnknownHostException {
        int port = 12345;
        InetAddress destino = InetAddress.getLocalHost();
        
        byte[] mensaje = new byte[1024];
        String saludo = "Enviando Saludos !!";
        mensaje = saludo.getBytes();
        
        DatagramPacket envio = new DatagramPacket(mensaje,mensaje.length,destino,port);
        
    }
}
