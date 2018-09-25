/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.ModelRegistro;
import view.ViewRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PatyPrz
 */
public class ControllerRegistro implements ActionListener{
    
    private final ModelRegistro modelRegistro;
    private final ViewRegistro viewRegistro;
    
    public ControllerRegistro(ModelRegistro modelRegistro, ViewRegistro viewRegistro){
        this.modelRegistro = modelRegistro;
        this.viewRegistro = viewRegistro;
        viewRegistro.JB_Save.addActionListener(this);
        initView();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewRegistro.JB_Save){
            modelRegistro.setPath("C:\\Users\\TeddyBear\\Documents\\UTEC\\TIC42\\Programacion\\PrimerParcial\\base.csv");
            modelRegistro.setTxt(modelRegistro.getText(viewRegistro.JTF_Name.getText(),viewRegistro.JTF_Email.getText()));
            modelRegistro.readFile(modelRegistro.getPath(), modelRegistro.getTxt());
            JOptionPane.showMessageDialog(viewRegistro, "El registro se ha guardado");
            viewRegistro.JTF_Name.setText(null);
            viewRegistro.JTF_Email.setText(null);
        }
    }

    private void initView() {
     viewRegistro.setTitle("Agenda v1.0");
     viewRegistro.setResizable(false);
     viewRegistro.setLocationRelativeTo(null);
     viewRegistro.setVisible(true);
    }    
}
