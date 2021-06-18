package classes;

/**
 *
 * @author Danny Jimenez
 */
public class Flights {
    private int stateFlight;
    private Airplane airplane;

    public Flights(Airplane airplane, int stateFlight) {
        this.airplane = airplane;
        this.stateFlight = stateFlight;
    }
    
    public Flights flightGenerator(){
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
        Flights flight = new Flights(airplaneRandom,1);
        
        return flight;
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
    
    
    
}
