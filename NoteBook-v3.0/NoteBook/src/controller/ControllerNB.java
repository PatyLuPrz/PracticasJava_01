package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import model.ModelNB;
import view.ViewNB;
/**
 *
 * @author PatyPrz
 */
public class ControllerNB implements ActionListener{
    
    private final ModelNB modelNB;
    private final ViewNB viewNB;
    FileFilter filtro = new FileNameExtensionFilter("Archivos adty","adty");
    
    public ControllerNB(ModelNB modelNB, ViewNB viewNB){
        this.modelNB = modelNB;
        this.viewNB = viewNB;
        viewNB.JMI_Read.addActionListener(this);
        viewNB.JMI_Write.addActionListener(this);
        viewNB.JMI_Encrypt.addActionListener(this);
        viewNB.JMI_Decrypt.addActionListener(this);
        initView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewNB.JMI_Read){
            JFileChooser file=new JFileChooser();
            file.addChoosableFileFilter(filtro);
            file.showOpenDialog(null);
            modelNB.readFile(modelNB.getPath());      
            viewNB.JTA_Txt.setText(modelNB.getMessage());
        }else if(e.getSource()==viewNB.JMI_Write){
            JFileChooser file=new JFileChooser();
            file.addChoosableFileFilter(filtro);
            file.showSaveDialog(null);
            modelNB.setPath(""+file.getSelectedFile());
            modelNB.setMessage(viewNB.JTA_Txt.getText());
            modelNB.writeFile(modelNB.getPath(), modelNB.getMessage());
        }else if(e.getSource()==viewNB.JMI_Encrypt){
            JFileChooser file=new JFileChooser();
            file.addChoosableFileFilter(filtro);
            file.showSaveDialog(null);
            modelNB.setPath(""+file.getSelectedFile());
            modelNB.setMessage(viewNB.JTA_Txt.getText());
            modelNB.writeFileEncrypted(modelNB.getPath(), modelNB.getMessage());
        }else if(e.getSource()==viewNB.JMI_Decrypt){
            JFileChooser file=new JFileChooser();
            file.addChoosableFileFilter(filtro);
            file.showOpenDialog(null);
            modelNB.readFileDecrypted(modelNB.getPath());      
            viewNB.JTA_Txt.setText(modelNB.getMessage());
        }
    }
    private void initView() {
        viewNB.setTitle("Block de notas");
        viewNB.setResizable(false);
        viewNB.setLocationRelativeTo(null);
        viewNB.setVisible(true);
    }
}
