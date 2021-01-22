package Viernes22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host="localhost";
        int puerto=6000;
        Socket cliente;
        OutputStream salida=null;
        InputStream entrada=null;
        DataOutputStream flujoSalida=null;
        DataInputStream flujoEntrada=null;
        String cadena;
        
        cliente = new Socket(host, puerto);

        salida=cliente.getOutputStream();
        entrada = cliente.getInputStream();
        
        flujoSalida= new DataOutputStream(salida);
        flujoEntrada = new DataInputStream(entrada);
        
        flujoSalida.writeUTF("HOLA, QUE TAL ESTAS?");
        cadena = flujoEntrada.readUTF();
        System.out.println("Servidor devuelve: "+cadena);
        
        
        flujoSalida.close();
        flujoEntrada.close();
        salida.close();
        entrada.close();
        
        cliente.close();
        
    }
}
