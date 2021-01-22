/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package martes19_01_21;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author victor
 */
public class Cliente {
    
    public static void main(String arg[]) throws IOException{
        
        String host="localhost";
        int puerto=6000;
        InetAddress i;
        Socket cliente;
        
        cliente = new Socket(host, puerto);
        
        i = cliente.getInetAddress();
        
        System.out.println("Puerto local: "+ cliente.getLocalPort());
        System.out.println("Puerto remoto: "+ cliente.getPort());
        System.out.println("Nombre host/ip: "+ cliente.getInetAddress());
        System.out.println("Host remoto: "+i.getHostName().toString());
        System.out.println("Host remoto: "+i.getHostAddress().toString());

        cliente.close();
    }
    
}
