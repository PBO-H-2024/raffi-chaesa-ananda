import controller.PersonController;
import view.GUI;

public class App {
    public static void main(String[] args) throws Exception {
        GUI gui = new GUI();
        PersonController pc = new PersonController(gui);
    }
}
