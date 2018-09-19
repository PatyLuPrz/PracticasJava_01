/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import model.ModelNB;
import view.ViewNB;
import controller.ControllerNB;
/**
 *
 * @author PatyPrz
 */
public class Main {
    private static ModelNB modelNB;
    private static ViewNB viewNB;
    private static ControllerNB controllerNB;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        modelNB = new ModelNB();
        viewNB = new ViewNB();
        controllerNB = new ControllerNB(modelNB, viewNB);
    }
}
