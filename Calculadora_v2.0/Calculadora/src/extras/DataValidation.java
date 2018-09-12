package extras;
import javax.swing.JOptionPane;
public class DataValidation {
    public int stringToInt(String value){
        int result = 0;
        try{
            result = Integer.parseInt(value);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Upps! No puedo dejar que escribas eso ahi");
            result = 0;
        }
        return result;
    }
    
    public float stringToFloat(String value){
        float result = 0.0f;
        try{
            result = Float.parseFloat(value);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Upps! No puedo dejar que escribas eso ahi");
            result = 0;
        }
        return result;
    }
    
    public double stringToDouble(String value){
        double result = 0;
        try{
            result = Double.parseDouble(value);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Upps! No puedo dejar que escribas eso ahi");
            result = 0;
        }
        return result;
    }
}
