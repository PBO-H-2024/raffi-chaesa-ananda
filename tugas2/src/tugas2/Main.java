package tugas2;

public class Main {
    public static void main(String[] args) {
        ViewContact view = new ViewContact();
        ModelContact model = new ModelContact();
        ControllerContact controller = new ControllerContact(view, model);
    }
}
