package main;
import model.ModelMessage;
import view.ViewMessage;
import controller.ControllerMessage;
public class Main 
{
    private static ViewMessage viewMessage;
    private static ModelMessage modelMessage;
    private static ControllerMessage controllerMessage;
    
    public static void main(String[] args) 
    {
        viewMessage = new ViewMessage();
        modelMessage = new ModelMessage();
        controllerMessage= new ControllerMessage(viewMessage, modelMessage);
    }   
}
