package flights;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Danny Jimenez
 */
public class Flights extends Thread{
    private int stateFlight;
    private Airplane airplane;
    private Socket flightSocket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private final String IP = "localhost";
    private final int PORT = 6666;
    private boolean connected;
    
    public static Flights threadFlight = new Flights();

    public Flights() {
       
    }
    
    public String flightGenerator(){
        int size = (int) Math.floor(Math.random()*(200-130)+130);
        int type = (int) Math.floor(Math.random()*3);
        String name = "Null";
        
        switch (type){
            case 0:
                name = "Carga";
                break;
            case 1:
                name = "Pasajeros";
                break;
            case 3:
                name = "Privado";
                break;
        }
        
        
        Airplane airplaneRandom = new Airplane(type, size, name);      
        
        return name;
    }
    
    
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public void setStateFlight(int stateFlight) {
        this.stateFlight = stateFlight;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public int getStateFlight() {
        return stateFlight;
    }
    public void startConnection() throws IOException, ClassNotFoundException {
        flightSocket = new Socket(IP, PORT);
        System.out.println("Conectado a: " + IP + " en el puerto..." + PORT);
        
        
        
    }
    
    
    public void sendMessage(String message) throws IOException {
        output = new ObjectOutputStream(flightSocket.getOutputStream());
        output.writeObject(message);
        
    }

    public void stopConnection() throws IOException {
        input.close();
        output.close();
        flightSocket.close();
    }
    
    public static void main(String[] args) {
        threadFlight.start();
    }

    @Override
    public void run() {
        connected = true;
        while(connected){
            try{
                threadFlight.startConnection();
            }catch(IOException | ClassNotFoundException e){
                
            }
        }
    }
    
    
    
}
