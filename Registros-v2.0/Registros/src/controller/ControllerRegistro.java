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
 * Esta clase contiene todos los metodos necesarios para la conexión entre el 
 * modelo y el view, y asi, la aplicación pueda funcionar de la manera esperada.
 * @author PatyPrz
 */
public class ControllerRegistro implements ActionListener{
    
    private final ModelRegistro modelRegistro;
    private final ViewRegistro viewRegistro;
    
    public ControllerRegistro(ModelRegistro modelRegistro, ViewRegistro viewRegistro){
        this.modelRegistro = modelRegistro;
        this.viewRegistro = viewRegistro;
        viewRegistro.JB_Siguiente.addActionListener(this);
        viewRegistro.JB_Anterior.addActionListener(this);
        viewRegistro.JB_Save.addActionListener(this);
        viewRegistro.JB_Primero.addActionListener(this);
        viewRegistro.JB_Ultimo.addActionListener(this);
        viewRegistro.JB_Clean.addActionListener(this);
        initView();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int contador=0;
        if(e.getSource()==viewRegistro.JB_Save){
            modelRegistro.setPath("C:\\Users\\TeddyBear\\Documents\\UTEC\\TIC42\\Programacion\\PrimerParcial\\base.csv");
            modelRegistro.setTxt(modelRegistro.getText(viewRegistro.JTF_Name.getText(),viewRegistro.JTF_Email.getText()));
            modelRegistro.witreFile(modelRegistro.getPath(), modelRegistro.getTxt());
            JOptionPane.showMessageDialog(viewRegistro, "El registro se ha guardado");
            viewRegistro.JTF_Name.setText(null);
            viewRegistro.JTF_Email.setText(null);
        } else if(e.getSource()==viewRegistro.JB_Anterior){
            modelRegistro.setContador(modelRegistro.getContador()-1);
            contador+=modelRegistro.getContador();
            System.out.println(contador);
            obtenerPath();
            modelRegistro.verRegistros(modelRegistro.getTxt(), contador);
            mostrarJTF();
        } else if(e.getSource()==viewRegistro.JB_Primero){
            obtenerPath();
            modelRegistro.primerRegistro(modelRegistro.getTxt());
            mostrarJTF();
        } else if(e.getSource()==viewRegistro.JB_Ultimo){
            obtenerPath();
            modelRegistro.ultimoRegistro(modelRegistro.getTxt());
            mostrarJTF();
        } else if(e.getSource() == viewRegistro.JB_Siguiente){
            modelRegistro.setContador(modelRegistro.getContador()+1);
            contador+=modelRegistro.getContador();
            System.out.println(contador);
            obtenerPath();
            modelRegistro.verRegistros(modelRegistro.getTxt(), contador);
            mostrarJTF();
        } else if(e.getSource()==viewRegistro.JB_Clean){
            modelRegistro.setEmail(null);
            modelRegistro.setName(null);
            mostrarJTF();
        }
    }

    private void initView() {
        viewRegistro.setTitle("Agenda v2.0");
        viewRegistro.setResizable(false);
        viewRegistro.setLocationRelativeTo(null);
        viewRegistro.setVisible(true);
        obtenerPath();
        modelRegistro.primerRegistro(modelRegistro.getTxt());
        mostrarJTF();
    }    

    private void obtenerPath() {
        modelRegistro.setPath("C:\\Users\\TeddyBear\\Documents\\UTEC\\TIC42\\Programacion\\PrimerParcial\\base.csv");
        modelRegistro.readFile(modelRegistro.getPath());
    }

    private void mostrarJTF() {
        viewRegistro.JTF_Name.setText(modelRegistro.getName());
        viewRegistro.JTF_Email.setText(modelRegistro.getEmail());
    }
}
