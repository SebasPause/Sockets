package Viernes22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente_3_5 {
    public static void main(String[] args) throws IOException {
        String host="localhost";
        int puerto=6000;
        Socket cliente;
        String cadena;
        OutputStream salida=null;
        InputStream entrada=null;
        DataOutputStream flujoSalida=null;
        DataInputStream flujoEntrada=null;
        Scanner s =  new Scanner(System.in);
        System.out.println("Introduce el numero de clientes: ");
        int numero = s.nextInt();
        
        for(int i=0;i<numero;i++){
            cliente = new Socket(host,puerto);
            salida = cliente.getOutputStream();
            entrada = cliente.getInputStream();
            flujoSalida = new DataOutputStream(salida);
            flujoEntrada = new DataInputStream(entrada);
            flujoSalida.writeInt(i+1);
            cadena = flujoEntrada.readUTF();
            System.out.println("Servidor devuelve: "+cadena);
            flujoSalida.close();
            flujoEntrada.close();
            salida.close();
            entrada.close();
            cliente.close();
            
        }
        
            
        
        
    }

}
