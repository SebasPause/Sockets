
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestInetAddress2 {
    public static void main(String[] args) {
        InetAddress dir = null;
        String host = "localhost";
        if(args.length>0){
            host = args[0];
        }
        
        System.out.println("=================================");
        System.out.println("Salida: "+host);
        
        try{
            //Localhost
            dir = InetAddress.getByName(host);
            pruebaMetodos(dir);  
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
