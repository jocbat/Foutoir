import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Serveur {
 
	public static void main(String[] zero) {
        
        ServerSocket socketserver  ;
        Socket socketduserveur ;
        BufferedReader in;
        PrintWriter out;
         
        try {
         
            socketserver = new ServerSocket(2010);
            socketduserveur = socketserver.accept(); 
            
            socketduserveur.getInputStream();

                out = new PrintWriter(socketduserveur.getOutputStream());
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type : text/plain");
                out.println("");
                out.println("Hello !!");
                
                out.flush();
                         
                socketduserveur.close();
                socketserver.close();
                System.out.println("FINI !");
                 
        }catch (IOException e) {
             
            e.printStackTrace();
        }
    }
 
}