package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.ViewCalculadora;
import model.ModelCalculadora;
public class ControllerCalculadora implements ActionListener{
    private final ModelCalculadora modelCalculadora;
    private final ViewCalculadora viewCalculadora;
    
    public ControllerCalculadora(ViewCalculadora viewCalculadora, ModelCalculadora modelCalculadora){
        this.modelCalculadora = modelCalculadora;
        this.viewCalculadora = viewCalculadora;
        this.viewCalculadora.jb_division.addActionListener(this);
        this.viewCalculadora.jb_suma.addActionListener(this);
        this.viewCalculadora.jb_multiplicacion.addActionListener(this);
        this.viewCalculadora.jb_resta.addActionListener(this);
        this.viewCalculadora.jb_modulo.addActionListener(this);
        this.viewCalculadora.jb_clean.addActionListener(this);
        initView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            modelCalculadora.setNum1(Float.parseFloat(viewCalculadora.jtf_num1.getText()));
            modelCalculadora.setNum2(Float.parseFloat(viewCalculadora.jtf_num2.getText()));
            float num_1 = modelCalculadora.getNum1();
            float num_2 = modelCalculadora.getNum2();
            float resultado = 0.0f;
            System.out.println("Obtener numeros - Controlador");
            if(e.getSource()==viewCalculadora.jb_suma){
                resultado = num_1+num_2;
                viewCalculadora.jl_resultado.setText("Resulatado: "+resultado);
            }
            else if(e.getSource()==viewCalculadora.jb_resta){
                resultado = num_1-num_2;
                viewCalculadora.jl_resultado.setText("Resulatado: "+resultado);
            }
            else if(e.getSource()==viewCalculadora.jb_multiplicacion){
                resultado = num_1*num_2;
                viewCalculadora.jl_resultado.setText("Resulatado: "+resultado);
            }
            else if(e.getSource()==viewCalculadora.jb_division){
                resultado = num_1/num_2;
                viewCalculadora.jl_resultado.setText("Resulatado: "+resultado);
            }
            else if(e.getSource()==viewCalculadora.jb_modulo){
                resultado = num_1%num_2;
                viewCalculadora.jl_resultado.setText("Resulatado: "+resultado);
            }
            else if(e.getSource()==viewCalculadora.jb_clean){
                viewCalculadora.jl_resultado.setText(null);
                viewCalculadora.jtf_num1.setText(null);
                viewCalculadora.jtf_num2.setText(null);
            }
        }
        catch(Exception x){
           JOptionPane.showMessageDialog(viewCalculadora,"Upps! No puedo dejar que escribas eso ahi");    
        }
    }

    private void initView() {
        viewCalculadora.setTitle("Calculadora");
        viewCalculadora.setLocationRelativeTo(null);
        viewCalculadora.setVisible(true);
    }
}
