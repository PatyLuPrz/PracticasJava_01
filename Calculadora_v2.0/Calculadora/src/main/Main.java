package main;
import model.ModelCalculadora;
import view.ViewCalculadora;
import extras.DataValidation;
import controller.ControllerCalculadora;
public class Main {
    private static ModelCalculadora modelCalculadora;
    private static ControllerCalculadora controllerCalculadora;
    private static ViewCalculadora viewCalculadora;
    private static DataValidation dataValidation;

    public static void main(String[] args) {
        viewCalculadora = new ViewCalculadora();
        modelCalculadora = new ModelCalculadora();
        dataValidation = new DataValidation();
        controllerCalculadora = new ControllerCalculadora(viewCalculadora, modelCalculadora);
    }
}
