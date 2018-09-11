package main;
import model.ModelCalculadora;
import view.ViewCalculadora;
import controller.ControllerCalculadora;
public class Main {
    private static ModelCalculadora modelCalculadora;
    private static ControllerCalculadora controllerCalculadora;
    private static ViewCalculadora viewCalculadora;

    public static void main(String[] args) {
        viewCalculadora = new ViewCalculadora();
        modelCalculadora = new ModelCalculadora();
        controllerCalculadora = new ControllerCalculadora(viewCalculadora, modelCalculadora);
    }
    
}
