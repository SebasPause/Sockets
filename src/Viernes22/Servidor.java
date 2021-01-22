package Viernes22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto=6000;
        Socket cliente;
        InputStream entrada=null;
        DataInputStream flujoEntrada=null;
        OutputStream salida=null;
        DataOutputStream flujoSalida=null;
        String cadena;
                
                
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando en "+ servidor.getLocalPort());
        
        for(int i=0;i<5;i++){
            cliente = servidor.accept();
            System.out.println("Puerto local: " +cliente.getLocalPort());
            System.out.println("Puerto remoto: " +cliente.getPort());
            
            entrada = cliente.getInputStream();
            salida = cliente.getOutputStream();
            
            flujoEntrada = new DataInputStream(entrada);
            flujoSalida =  new DataOutputStream(salida);
            
            cadena = flujoEntrada.readUTF();
            
            //Procesar la entrada
            System.out.println("Cliente manda: "+cadena);
            
            //Enviamos el mensaje de vuelta en minusculas
            flujoSalida.writeUTF(cadena.toLowerCase());
            
            
            flujoEntrada.close();
            flujoSalida.close();
            entrada.close();
            salida.close();
        }
        
        servidor.close();
        
        
    }
}
