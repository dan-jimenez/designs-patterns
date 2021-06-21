package controllerWindow;

import java.io.*;
import java.net.*;
import javax.swing.JFrame;

/**
 *
 * @author Danny Jimenez
 */
public class ControllerWindow extends JFrame {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    public ControllerPanel mainPanel = new ControllerPanel();
    
    public ControllerWindow(){
        super("Controller Window");
        initComponents();
    }
    
    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
    
    public void initComponents(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(mainPanel.getSize());
        this.setUndecorated(true);
        this.setLocation(5,5);
        this.pack();
        
    } 
    
}
