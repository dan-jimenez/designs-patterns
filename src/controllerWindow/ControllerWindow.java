package controllerWindow;

import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Danny Jimenez
 * ControllerWindow is a client
 */
public class ControllerWindow extends JFrame implements Runnable{
    
    private ServerSocket serverSocket;
    private Socket controllerWindowSocket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    public ControllerPanel mainPanel = new ControllerPanel();
    private final String IP = "localhost";
    private final int PORT = 6666;
    private final int PORT2 = 9000;
    private String message;
    private boolean connected;
    private Socket client;
    
    public static Thread threadControllerWindow;
    public static ControllerWindow controllerWindow;
    
    
    
    public ControllerWindow(){
        super("Controller Window");
        
        initComponents();
    }
    
    public void startConnection() throws IOException, ClassNotFoundException {
        controllerWindowSocket = new Socket(IP, PORT);
        serverSocket = new ServerSocket(PORT2);
        System.out.println("Conectado a: " + IP + " en el puerto..." + PORT);
        
        
        
    }
    
    public void startServer() throws IOException, ClassNotFoundException{
        client = serverSocket.accept();
        messageReader();
        
    }
    public String messageReader() throws IOException, ClassNotFoundException{
        input = new ObjectInputStream(client.getInputStream());        
        
        try{
            message = (String) input.readObject();
        }catch(IOException e){
            System.out.println("Error desconocido con la recepción de mensajes del servidor");
            connected = false;
        }
                
        System.out.println(message);
        return message;
        
    }

    
    public void translater(String message){
        
    }
    public void sendMessage(String message) throws IOException {
        output = new ObjectOutputStream(controllerWindowSocket.getOutputStream());
        output.writeObject(message);
        
    }

    public void stopConnection() throws IOException {
        input.close();
        output.close();
        controllerWindowSocket.close();
    }
    
    public void initComponents(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(mainPanel.getSize());
        this.setUndecorated(true);
        this.setLocation(5,5);
        this.pack();
        
    } 
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControllerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        controllerWindow = new ControllerWindow();
        threadControllerWindow = new Thread(controllerWindow);
        threadControllerWindow.start();
        
        
    }

    @Override
    public void run() {
        connected = true;
        while(connected){
            controllerWindow.setVisible(connected);
            try {
                controllerWindow.startConnection();
                controllerWindow.startServer();
                translater(messageReader());
            } catch (IOException | ClassNotFoundException ex) {
            }
            
        }
    }
    
}
