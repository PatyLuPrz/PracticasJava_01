package main;
import model.ModelIMC;
import view.ViewIMC;
import controller.ControllerIMC;
public class Main {
    private static ViewIMC ViewIMC;
    private static ModelIMC ModelIMC;
    private static ControllerIMC ControllerIMC;
    public static void main(String[] args) {
        ViewIMC = new ViewIMC();
        ModelIMC = new ModelIMC();
        ControllerIMC = new ControllerIMC(ViewIMC, ModelIMC);
    }
    
}
