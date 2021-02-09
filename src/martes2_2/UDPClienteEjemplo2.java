package martes2_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClienteEjemplo2 {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        
        
        InetAddress ipServidor = InetAddress.getLocalHost();
        int puerto = 12345;
        
        System.out.println("Introduce mensaje: ");
        String cadena = sc.nextLine();
        
        byte[] enviados =  new byte[1024];
        enviados = cadena.getBytes();
        
        DatagramPacket envio =  new DatagramPacket(enviados, enviados.length,ipServidor,puerto);
        clientSocket.send(envio);

        byte[] recibidos = new byte[2];
        DatagramPacket recibo =  new DatagramPacket(recibidos,recibidos.length);
        System.out.println("Esperando datagrama...");
        clientSocket.receive(recibo);
        
        byte[] hh = recibo.getData();
        int numero = hh[0];
        
        System.out.println("Recibo nº de caracteres que son a=> "+numero);
        
        
        
        
        
    }
    
}
