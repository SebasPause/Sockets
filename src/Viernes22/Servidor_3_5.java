package Viernes22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor_3_5 {
    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        Socket cliente;
        ServerSocket servidor;
        InputStream entrada=null;
        OutputStream salida=null;
        DataInputStream flujoEntrada=null;
        DataOutputStream flujoSalida=null;
        int numero;
        
        servidor = new ServerSocket(puerto);
        while(true){
            cliente = servidor.accept();
            System.out.println("Escuchando en "+ servidor.getLocalPort());
            entrada = cliente.getInputStream();
            salida = cliente.getOutputStream();
            flujoEntrada = new DataInputStream(entrada);
            flujoSalida =  new DataOutputStream(salida);

            numero = flujoEntrada.readInt();
            System.out.println("Numero recibido: "+ String.valueOf(numero));
            
            flujoSalida.writeUTF("Eres el cliente "+numero);
             
            flujoEntrada.close();
            flujoSalida.close();
            entrada.close();
            salida.close();
            //System.out.println("Quieres matar la escucha?(s/n)");
            //Scanner s = new Scanner(System.in);
            //String opcion = s.next();
            //if(opcion.equals("s")){
              //  servidor.close();
            //}
        }

    }
}
