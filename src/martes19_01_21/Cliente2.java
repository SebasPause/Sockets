/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package martes19_01_21;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author victor
 */
public class Cliente2 {
    
    public static void main(String arg[]) throws IOException{
        
        String host="localhost";
        int puerto=6000;
        InetAddress i;
        Socket cliente;
        OutputStream salida=null;
        DataOutputStream flujoSalida=null;
        
        cliente = new Socket(host, puerto);
        
        i = cliente.getInetAddress();
        
        System.out.println("Puerto local: "+ cliente.getLocalPort());
        System.out.println("Puerto remoto: "+ cliente.getPort());
        System.out.println("Nombre host/ip: "+ cliente.getInetAddress());
        System.out.println("Host remoto: "+i.getHostName().toString());
        System.out.println("Host remoto: "+i.getHostAddress().toString());

        salida=cliente.getOutputStream();
        
        flujoSalida= new DataOutputStream(salida);
        
        flujoSalida.writeInt(cliente.getLocalPort());
        
        flujoSalida.close();
        salida.close();
        
        cliente.close();
    }
    
}
