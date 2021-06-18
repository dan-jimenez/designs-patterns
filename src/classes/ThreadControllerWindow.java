package classes;

import frames.ControllerPanel;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;

/**
 *
 * @author Danny Jimenez
 */
public class ThreadControllerWindow extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    public JFrame controllerFrame = new JFrame("Controller Window");
    public ControllerPanel mainPanel = new ControllerPanel();
    private static boolean run = true;
    
    
    

    public ThreadControllerWindow() {
        super("ControllerWindow");
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
        controllerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controllerFrame.setContentPane(mainPanel);
        controllerFrame.setSize(mainPanel.getSize());
        controllerFrame.setUndecorated(true);
        controllerFrame.setLocation(5,5);
        controllerFrame.pack();
        
    }
    
    public void stopFrame(){
        run = false;
    }
    
    
    
    @Override
    public void run() {
        controllerFrame.setVisible(true);
        while(run){
        }
        
    }
    
    
}
