package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import model.ModelNB;
import view.ViewNB;
/**
 *
 * @author PatyPrz
 */
public class ControllerNB implements ActionListener{
    
    private final ModelNB modelNB;
    private final ViewNB viewNB;
    
    public ControllerNB(ModelNB modelNB, ViewNB viewNB){
        this.modelNB = modelNB;
        this.viewNB = viewNB;
        viewNB.JMI_Read.addActionListener(this);
        viewNB.JMI_Write.addActionListener(this);
        initView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewNB.JMI_Read){
            seleccionarRuta();
            modelNB.readFile(modelNB.getPath());      
            viewNB.JTA_Txt.setText(modelNB.getMessage());
        }else if(e.getSource()==viewNB.JMI_Write){
            seleccionarRuta();
            modelNB.setMessage(viewNB.JTA_Txt.getText());
            modelNB.writeFile(modelNB.getPath(), modelNB.getMessage());
        }
    }
    private void initView() {
        viewNB.setTitle("Block de notas");
        viewNB.setResizable(false);
        viewNB.setLocationRelativeTo(null);
        viewNB.setVisible(true);
    }   

    private void seleccionarRuta() {
        JFileChooser file=new JFileChooser();
        file.showSaveDialog(null);
        modelNB.setPath(""+file.getSelectedFile());
    }

}
