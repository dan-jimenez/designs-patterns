package flights;

/**
 *
 * @author Danny Jimenez
 */
public class Airplane{
    private int type;
    private int size;
    private String name;

    public Airplane(int type, int size, String name) {
        this.type = type;
        this.name = name;
        this.size = size;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setType(int type) {
        this.type = type;
    }

 
    public void setSize(int size) {
        this.size = size;
    }

    public int getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
        
    
    
    
}
