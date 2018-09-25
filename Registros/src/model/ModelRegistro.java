package model;
import java.io.*;
/**
 *
 * @author PatyPrz
 */
public class ModelRegistro {
    private String Path;
    private String Txt;

    public String getPath() {
        System.out.println("getPath");
        return Path;
    }

    public void setPath(String Path) {
        System.out.println("setPath");
        this.Path = Path;
    }

    public String getTxt() {
        System.out.println("getTxt");
        return Txt;
    }

    public void setTxt(String Txt) {
        System.out.println("setTxt");
        this.Txt = Txt;
    }
    /**
     * Este metodo genera la cadena que se guardara en el archivo CSV
     * @param name Nombre que se obtiene del view
     * @param email Email que se obtiene del view
     * @return 
     */
    public String getText(String name, String email){
        String txt=name+";"+email+"\n";
        System.out.println(txt);
        return txt;
    }
    /**
     * Este metodo guarda la información en un archivo .CSV
     * @param path La ruta en donde se encuentra el archivo CSV
     * @param txt  La información que se desea almacenar
     */
    public void readFile(String path, String txt){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            try(PrintWriter printWriter = new PrintWriter(fileWriter)){
                System.out.println("--------");
                System.out.println(txt);
                printWriter.println(txt);
                printWriter.close();
            }        
        }catch(IOException err){
            System.err.println("error "+err.getMessage());
        }
    }
}
