/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package martes19_01_21;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author victor
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int puerto=6000;
        Socket cliente;
        
                
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando en "+ servidor.getLocalPort());
        
        for(int i=0;i<5;i++){
            cliente = servidor.accept();
            System.out.println("Puerto local: " +cliente.getLocalPort());
            System.out.println("Puerto remoto: " +cliente.getPort());
        }
        
        servidor.close();
    }
    
}
