package controller;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danny Jimenez
 */


public class Controller extends Thread {
    private ServerSocket serverSocket;
    private Socket controllerWindowSocket;
    private ObjectOutputStream output;
    private final int PORT = 6666;
    private ObjectInputStream input;
    private String message;
    private Gate[] gatesArray;
    private LandingStrip[] landingArray;
    public boolean run = true;
    
    public static Controller controller = new Controller();

    public Controller() {
        this.landingArray = new LandingStrip[5];
        this.gatesArray = new Gate[5];
    }
    
    /*
    Dentro de este metodo se inicia el server y se inicia la lectura de datos
    Parametros:
    Returna:
    */
    public void startServer() throws IOException, ClassNotFoundException{
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor Inciado");
        
    }
    
    public void connection() throws IOException, ClassNotFoundException{
        controllerWindowSocket = serverSocket.accept();
        System.out.println("User conected");
        
        messagesCatch();
    }
    
    public void answers(String message) throws IOException{
        output = new ObjectOutputStream(controllerWindowSocket.getOutputStream());
        output.writeObject(message);
        System.out.println("Mensaje enviado");
    }
    public void messagesCatch() throws IOException, ClassNotFoundException{        
        input = new ObjectInputStream(controllerWindowSocket.getInputStream());
        message = (String) input.readObject();
        
        traslate(message);
    }
    
    
    public void gatesGenerator(){
        String name;
        int maximun = 130;
        int minimun;
        boolean disponibility = true;
        for(int i = 0; i<7; i++){
            name = i +"";
            maximun += 10;
            minimun = maximun + 1;
            gatesArray[i] = new Gate(minimun,maximun, name, disponibility);
            
    }
    }
    
    public void landingGenerator(){
        String name;
        int maximun = 130;
        int minimun;
        boolean disponibility = true;
        for(int i = 0; i<7; i++){
            name = i+"";
            maximun += 10;
            minimun = maximun + 1;
            landingArray[i] = new LandingStrip(minimun, name, maximun, disponibility);
        }
    }
    
    public void charge(){
        
    }
    
    public void stopServer() throws IOException {
        input.close();
        output.close(); 
        controllerWindowSocket.close();
        serverSocket.close();
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        controller.landingGenerator();
        controller.gatesGenerator();
        controller.startServer();
        
    }

    private void traslate(String message) {
        if(message.equalsIgnoreCase("charge")){
            charge();
        }
    }

    @Override
    public void run() {
        while (run){
            try {
                controller.connection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
