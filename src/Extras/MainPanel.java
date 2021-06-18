package Extras;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Danny Jimenez
 */
public class MainPanel extends JPanel{

    private String ROUTE;
    
    public MainPanel(String route) {
        ROUTE = route;
    }
    
    /***
     * 
     * Este codigo es para obtener las dimensiones de la pantalla en la que estemos trabajando
     * 
     *  private GraphicsDevice Gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
     * private int screenHeight = Gd.getDisplayMode().getHeight();
     * private int screenWidth = Gd.getDisplayMode().getWidth(); 
     */
   
    
    @Override
    public void paint(Graphics g){
        Dimension dimension = this.getSize();
        ImageIcon background  = new ImageIcon(getClass().getResource(ROUTE));
        g.drawImage(background.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);   
        super.paintChildren(g);
        
    }
}
