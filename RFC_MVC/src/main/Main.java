package main;
import view.ViewRFC;
import model.ModelRFC;
import controller.ControllerRFC;
public class Main {
    private static ModelRFC modelRFC;    
    private static ViewRFC viewRFC;
    private static ControllerRFC controllerRFC;
    
    public static void main(String[] args) {
        modelRFC = new ModelRFC();
        viewRFC = new ViewRFC();
        controllerRFC = new ControllerRFC(viewRFC, modelRFC);
    }
    
}
