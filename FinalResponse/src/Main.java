// 123220145 Raffi Chaesa Ananda

public class Main {
    public static void main(String[] args) {
        ModelContact model = new ModelContact();
        ViewContact view = new ViewContact();
        ControllerContact controller = new ControllerContact(model, view);
    }
}