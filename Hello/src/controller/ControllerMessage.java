package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModelMessage;
import view.ViewMessage;

public class ControllerMessage implements ActionListener
{
    private final ModelMessage modelMessage;
    private final ViewMessage viewMessage;
    
    public ControllerMessage(ViewMessage viewMessage, ModelMessage modelMessage)
    {
        this.viewMessage = viewMessage;
        this.modelMessage = modelMessage;
        viewMessage.jb_hi.addActionListener(this);
        initView();
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource()==viewMessage.jb_hi)
       {
           modelMessage.setMessage("Hello! "+viewMessage.jtf_name.getText());
           viewMessage.jl_txt.setText(modelMessage.getMessage());
       }
    }

    private void initView() 
    {
        viewMessage.setTitle("Hello MVC");
        viewMessage.setLocationRelativeTo(null);
        viewMessage.jl_txt.setText(modelMessage.getMessage());
        viewMessage.setVisible(true);
    }

}
