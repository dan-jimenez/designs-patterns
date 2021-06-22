package controller;

import java.io.*;
import java.net.*;

/**
 *
 * @author Danny Jimenez
 */
public class Controller{
    private ServerSocket serverSocket;
    private Socket controllerWindowSocket;
    private ObjectOutputStream output;
    private final int PORT = 6666;
    private ObjectInputStream input;
    private String message;
    private Gate[] gatesArray = new Gate[5];
    private LandingStrip[] landingArray = new LandingStrip[5];
    public boolean run = true;
    
    public static Controller controller = new Controller();

    public Controller() {
    }
    
    /*
    Dentro de este metodo se inicia el server y se inicia la lectura de datos
    Parametros:
    Returna:
    */
    public void startServer() throws IOException, ClassNotFoundException{
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor Inciado");
        while(run){
            controllerWindowSocket = serverSocket.accept();
            System.out.println("Controller Window conected");
        
            messagesCatch();
            answers("Succesful connection");
        }
        
        
        
    }
    
    public void answers(String message) throws IOException{
        output = new ObjectOutputStream(controllerWindowSocket.getOutputStream());
        output.writeObject(message);
        System.out.println("Mensaje enviado");
    }
    public void messagesCatch() throws IOException, ClassNotFoundException{        
        input = new ObjectInputStream(controllerWindowSocket.getInputStream());
        message = (String) input.readObject();
        
        if ("hello server".equalsIgnoreCase(message)){
            System.out.println("message: " + message);
        }else if("callate gilipollas".equalsIgnoreCase(message)){
            System.out.println("Message: " + message);
        }
        else{
            System.out.println("Mensaje: " + message);
        }
    }
    
    
    public void gatesGenerator(){
        String name = "null";
        int maximun = 130;
        int minimun = 120;
        boolean disponibility = true;
        for(int i = 0; i<7; i++){
            name = i +"";
            maximun += 10;
            minimun = maximun + 1;
            gatesArray[i] = new Gate(minimun,maximun, name, disponibility);
            
    }
    }
    
    public void landingGenerator(){
        String name = "null";
        int maximun = 130;
        int minimun = 120;
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
    
}
