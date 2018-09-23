package model;
import java.io.*;
/**
 *
 * @author PatyPrz
 */
public class ModelNB {
    private String path;
    private String message;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void readFile(String path){
        try{
            String cifrado = "";
            char caracter;
            int ascii;
            String row;
            String txt="";
            String mensaje="";
            try(FileReader file = new FileReader(path)){
                BufferedReader bufferedReader;
                bufferedReader = new BufferedReader(file);
                while((row = bufferedReader.readLine()) != null){
                    txt=txt+"\n"+row;
                    for(int x=0; x<txt.length();x++){
                        caracter=txt.charAt(x);
                        ascii=(int)caracter;
                        ascii-=10;
                        cifrado+=(char)ascii;
                    }
                    mensaje+=cifrado;
                } 
                
                this.setMessage(mensaje);
                bufferedReader.close();
            }catch(FileNotFoundException err){
                System.out.println("Error! "+err.getMessage());   
            }
            }catch(IOException err){
                System.out.println("Error! "+err.getMessage());
        }
    }
    
    public void writeFile(String path, String message){
        try{
            String cifrado = "";
            char caracter;
            String cadena;
            int ascii;
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            try(PrintWriter printWriter = new PrintWriter(fileWriter)){
                for(int x=0;x<message.charAt(x);x++){
                    caracter = message.charAt(x);
                    ascii=(int)caracter;
                    ascii+=10;
                    cifrado+=(char)ascii;
                }
                printWriter.println(cifrado);
                printWriter.close();
            }        
        }catch(IOException err){
            System.err.println("error "+err.getMessage());
        }
    }
}
