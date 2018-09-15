package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelRFC {
    private String Nombre;
    private String AP;
    private String AM;
    private String FNac;
    private String RFC;

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getAP() {
        return AP;
    }

    public void setAP(String AP) {
        this.AP = AP;
    }

    public String getAM() {
        return AM;
    }

    public void setAM(String AM) {
        this.AM = AM;
    }

    public String getFNac() {
        return FNac;
    }

    public void setFNac(String FNac) {
        this.FNac = FNac;
    }
    
    public String obtenerPP(String value){
        String result = value;
        String[] arrayResult = result.split(" ");
        for (int i=0;i< arrayResult.length; i++){
            result = arrayResult[i];
        }
        String str = result;
        Character primerLRFC = null;
        Character primerLVRFC = null;
        
        for (int x =0; x < str.length(); x++){
            if (x==0){
                primerLRFC = str.charAt(x);
            } else if (str.charAt(x)=='a' || str.charAt(x) == 'e' || str.charAt(x) == 'i' || str.charAt(x) == 'o' || str.charAt(x) == 'u'){
                primerLVRFC = str.charAt(x);
                break;
            }
        }
        value = Character.toString(primerLRFC) + Character.toString(primerLVRFC);
        return value.toUpperCase();
    }
    
    public String obtenerSP(String valueDos){
        String result = valueDos;
        String[] arrayResult = result.split(" ");
        for (int i=0;i<arrayResult.length;i++){
            result = arrayResult[i];
        }
        
        String str = result;
        Character primerLRFC = null;
        
        for (int x=0;x<str.length();x++){
            if(x==0){
                primerLRFC = str.charAt(x);
                break;
            }
        }
        valueDos=Character.toString(primerLRFC);
        return valueDos.toUpperCase();
    }
    
    public String obtenerN(String valueTres){
        String str = valueTres;
        Character primerLRFC = str.charAt(0);
        valueTres=Character.toString(primerLRFC);
        return valueTres.toUpperCase();
    }
    
    public String fecha(Date fecha) {
        Date fechaDos = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        return sdf.format(fecha);
    }
}
