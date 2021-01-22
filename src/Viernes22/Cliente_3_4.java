package Viernes22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente_3_4 {
    public static void main(String[] args) throws IOException {
        String host="localhost";
        int puerto=6000;
        Socket cliente;
        OutputStream salida=null;
        InputStream entrada=null;
        DataOutputStream flujoSalida=null;
        DataInputStream flujoEntrada=null;
        int numero;
        
        cliente = new Socket(host,puerto);
        salida = cliente.getOutputStream();
        entrada = cliente.getInputStream();
        flujoSalida = new DataOutputStream(salida);
        flujoEntrada = new DataInputStream(entrada);
        
        System.out.println("Introduce un numero: ");
        Scanner s = new Scanner(System.in);
        numero = s.nextInt();
        
        flujoSalida.writeInt(numero);
        numero = flujoEntrada.readInt();
        System.out.println("Servidor devuelve el cuadrado: "+numero);
        
        flujoSalida.close();
        flujoEntrada.close();
        salida.close();
        entrada.close();
        
        
    }
}
