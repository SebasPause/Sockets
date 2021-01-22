
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestInetAddress {
    public static void main(String[] args) {
        InetAddress dir = null;
        System.out.println("=================================");
        System.out.println("Salida para localhost: ");
        
        try{
            //Localhost
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);
            
            //url google
            System.out.println("=============================");
            System.out.println("Salida para una url: ");
            dir = InetAddress.getByName("www.google.es");
            pruebaMetodos(dir);
            
            
            //Array de tipo InetAddress con todas las direcciones IP asignadas a google
            System.out.println("\tDirecciones IP para: "+dir.getHostName());
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
            for(int i=0;i<direcciones.length;i++){
                System.out.println("\t\t"+direcciones[i].toString());
            }
            System.out.println("=========================================");
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(TestInetAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static void pruebaMetodos(InetAddress dir){
        System.out.println("\tMetodo getByName(): "+dir);
        
        //Metodos de clase
        System.out.println("\tMetodo getHostName(): "+dir.getHostName());
        System.out.println("\tMetodo getHostAddress(): "+dir.getHostAddress());
        System.out.println("\tMetodo toString(): "+dir.toString());
        System.out.println("\tMetodo getCanonicalHostName(): "+dir.getCanonicalHostName());
        
    }//prueba metodos
    
    
}
