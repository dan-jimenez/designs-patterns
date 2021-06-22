package controller;

/**
 *
 * @author Danny Jimenez
 */
public class Gate {
    private double minimumCapacity;
    private String name;
    private double maximumCapacity;
    private boolean disponibility;

    public Gate(double sizeCapacity, double maximunCapacity, String name, boolean disponibility) {
        this.minimumCapacity = sizeCapacity;
        this.maximumCapacity = maximunCapacity;
        this.name = name;
        this.disponibility = disponibility;
    }

    public double getMinimunCapacity() {
        return minimumCapacity;
    }

    public double getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }
    
    public String getName() {
        return name;
    }

    public void setMinimunCapacity(double sizeCapacity) {
        this.minimumCapacity = sizeCapacity;
    }

    public void setName(String name) {
        this.name = name;
    }
}
