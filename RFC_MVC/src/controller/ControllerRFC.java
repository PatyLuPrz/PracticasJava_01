package controller;
import model.ModelRFC;
import view.ViewRFC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerRFC implements ActionListener{
    private final ModelRFC modelRFC;
    private final ViewRFC viewRFC;
    
    public ControllerRFC(ViewRFC viewRFC, ModelRFC modelRFC){
        this.modelRFC = modelRFC;
        this.viewRFC = viewRFC;
        viewRFC.jb_calcular.addActionListener(this);
        initView();
    }
          
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewRFC.jb_calcular){
            consultar();
        }
    }

    private void initView() {
        viewRFC.setTitle("RFC");
        viewRFC.setResizable(false);
        viewRFC.setLocationRelativeTo(null);
        viewRFC.setVisible(true);
        
    }

    private void consultar() {
        modelRFC.setAP(modelRFC.obtenerPP(viewRFC.jtf_ap.getText()));
        modelRFC.setAM(modelRFC.obtenerSP(viewRFC.jtf_am.getText()));
        modelRFC.setNombre(modelRFC.obtenerN(viewRFC.jtf_nombre.getText()));
        modelRFC.setFNac(modelRFC.fecha(viewRFC.jdc_fnac.getDate()));
        String ResultadoRFC = modelRFC.getAP()+modelRFC.getAM()+modelRFC.getNombre()+modelRFC.getFNac();
        viewRFC.jl_result.setText(""+ResultadoRFC);
    }
    
}
