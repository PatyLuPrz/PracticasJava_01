package controller;
import model.ModelIMC;
import view.ViewIMC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ControllerIMC implements ActionListener{
    private final ModelIMC modelIMC;
    private final ViewIMC viewIMC;
    
    public ControllerIMC(ViewIMC ViewIMC, ModelIMC ModelIMC){
        this.modelIMC = ModelIMC;
        this.viewIMC = ViewIMC;
        viewIMC.jb_clean.addActionListener(this);
        viewIMC.jb_calcular.addActionListener(this);
        initView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewIMC.jb_calcular){
        try {
            modelIMC.setAltura(Double.parseDouble(viewIMC.jtf_altura.getText()));
            modelIMC.setPeso(Double.parseDouble(viewIMC.jtf_peso.getText()));
            
            double peso;
            double altura;
            double imc;
            peso = modelIMC.getPeso();
            altura = modelIMC.getAltura();
            
            if(peso==0 || altura==0){
                JOptionPane.showMessageDialog(viewIMC,"No puedes poner el cero ahi");
            }
            else if(peso<0 || altura<0){
                JOptionPane.showMessageDialog(viewIMC,"Upps! No puedes usar numeros negativos");
            }
            else if(altura>250){
                JOptionPane.showMessageDialog(viewIMC,"A menos que seas pie grande,\nte recomendamos usar tu altura real");
            }
            else if(altura<50){
                JOptionPane.showMessageDialog(viewIMC,"A menos que seas Chandra Bahadur Dangi,\nte recomendamos usar tu altura real");
            }
            else if(peso<25){
                JOptionPane.showMessageDialog(viewIMC,"A menos que seas Valeria Levitin,\nte recomendamos usar tu peso real");
            }
            else{
                altura=altura/100;
                imc=peso/(altura*altura);
                DecimalFormat formato = new DecimalFormat("#.00");

                switch (viewIMC.jcb_sex.getSelectedIndex()){
                    case 0:
                        JOptionPane.showMessageDialog(viewIMC,"Upps! Olvidaste especificar tu sexo");
                        break;
                    case 1:
                        if(imc<19){
                            JOptionPane.showMessageDialog(viewIMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes desnutricion");
                        }
                        else if(imc>=19 && imc<24){
                            JOptionPane.showMessageDialog(viewIMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tu peso es normal");
                        }
                        else if(imc>=24 && imc<27){
                            JOptionPane.showMessageDialog(viewIMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes sobrepeso");
                        }
                        else if(imc>=27 && imc<32){
                            JOptionPane.showMessageDialog(viewIMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes obesidad");
                        }
                        else if(imc>=32){
                            JOptionPane.showMessageDialog(viewIMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes obesidad grave");
                        }
                        break;
                        case 2: // hombre
                        if(imc<20){
                            JOptionPane.showMessageDialog(viewIMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes desnutricion");
                        }
                        else if(imc>=20 && imc<24){
                            JOptionPane.showMessageDialog(viewIMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tu peso es normal");
                        }
                        else if(imc>=24 && imc<30){
                            JOptionPane.showMessageDialog(viewIMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes sobrepeso");
                        }
                        else if(imc>=30 && imc<40){
                            JOptionPane.showMessageDialog(viewIMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes obesidad");
                        }
                        else if(imc>=40){
                            JOptionPane.showMessageDialog(viewIMC,"Tu IMC es de: "+formato.format(imc)+"\n Esto significa que tienes obesidad grave");
                        }
                        break;
                }
            }
        }
        catch (Exception x){
            JOptionPane.showMessageDialog(viewIMC, "Upps! No puedo dejar que escribas eso ahi");
        }
      }
        else if(e.getSource()==viewIMC.jb_clean){
            viewIMC.jtf_altura.setText(null);
            viewIMC.jtf_peso.setText(null);
            viewIMC.jcb_sex.setSelectedIndex(0);
        }
    }
    private void initView() {
        viewIMC.setTitle("Calculadora de IMC");
        viewIMC.setLocationRelativeTo(null);
        viewIMC.setVisible(true);
    }
    
}
