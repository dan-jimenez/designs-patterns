package classes;

/**
 *
 * @author Danny Jimenez
 */
public class Gate {
    private double sizeCapacity;
    private String name;
    private int airplaneCapacity;

    public Gate(double sizeCapacity, String name, int airplaneCapacity) {
        this.sizeCapacity = sizeCapacity;
        this.name = name;
        this.airplaneCapacity = airplaneCapacity;
    }

    public double getSizeCapacity() {
        return sizeCapacity;
    }

    public String getName() {
        return name;
    }

    public int getAirplaneCapacity() {
        return airplaneCapacity;
    }

    public void setSizeCapacity(double sizeCapacity) {
        this.sizeCapacity = sizeCapacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAirplaneCapacity(int airplaneCapacity) {
        this.airplaneCapacity = airplaneCapacity;
    }
}
