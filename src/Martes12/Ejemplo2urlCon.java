package Martes12;

import java.io.*;
import java.net.*;

public class Ejemplo2urlCon {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://localhost/vernombre.php");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);
            
            String cadena= "nombre=Sebastian &apellidos=Pauseniuc";
            
            //Escribir en la url
            PrintWriter output = new PrintWriter(conexion.getOutputStream());
            output.write(cadena);
            output.close(); //cerrar flujo
            
            //Leer de la url
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while((linea=reader.readLine()) != null){
                System.out.println(linea);
            }
            reader.close();
        } catch(MalformedURLException me){
            System.err.println("MalformedURLException: "+me);
        } catch(IOException ioe){
            System.err.println("IOException: "+ioe);
        }
    } //main
}
