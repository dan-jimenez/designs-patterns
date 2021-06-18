package classes;

/**
 *
 * @author Danny Jimenez
 */
public class Main {

    public static ThreadControllerWindow controllerWindow = new ThreadControllerWindow();
    public static Controller controller = new Controller();
    
    public static void main(String[] args) {
        controller.run();
        controllerWindow.run();
    }
}
