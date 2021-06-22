package controller;

/**
 *
 * @author Danny Jimenez
 */
public class LandingStrip {
    private double minimunCapacity;
    private String name;
    private int maximunCapacity;
    private boolean disponibility;

    public LandingStrip(double minimun, String name, int maximun, boolean disponibility) {
        this.minimunCapacity = minimun;
        this.name = name;
        this.maximunCapacity = maximun;
        this.disponibility= disponibility;
    }

    public double getMinimunCapacity() {
        return minimunCapacity;
    }

    public String getName() {
        return name;
    }

    public int getMaximunCapacity() {
        return maximunCapacity;
    }

    public void setMinimunCapacity(double minimunCapacity) {
        this.minimunCapacity = minimunCapacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaximunCapacity(int maximunCapacity) {
        this.maximunCapacity = maximunCapacity;
    }
    
    
    
}
