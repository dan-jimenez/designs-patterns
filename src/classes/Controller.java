package classes;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danny Jimenez
 */
public class Controller extends Thread{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Controller() {
    }
    
        
    public void startServer(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
        if ("hello server".equals(greeting)) {
            out.println("hello client");
        }
        else {
            out.println("unrecognised greeting");
        }
    }
        
    public void stopServer() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    @Override
    public void run() {
        try {
            startServer(6666);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
