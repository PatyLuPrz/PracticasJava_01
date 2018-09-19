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
            String row;
            String txt="";
            try(FileReader file = new FileReader(path)){
                BufferedReader bufferedReader;
                bufferedReader = new BufferedReader(file);
                while((row = bufferedReader.readLine()) != null){
                    txt=txt+"\n"+row;
                    System.out.println(row);
                } 
                this.setMessage(txt);
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
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            try(PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(message);
                printWriter.close();
            }        
        }catch(IOException err){
            System.err.println("error "+err.getMessage());
        }
    }
}
