package fileManager;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReadSettings {

    ArrayList<String> text = new ArrayList<>();
    boolean isExist = false;
    String path = "C:\\ProgramData\\Avior\\settings.txt";
    File MyDirectory = new File("C:\\ProgramData\\Avior");

    public ReadSettings(){
        MyDirectory.mkdirs();
        if (new File (path).exists()) {
            isExist = true;
            text = new ReadFile(path).getText();
            for (String s : text) {
                //----------------------------Исправить-------------------
                //if (s.contains("login")) Main.login = getValue(s);
                //if (s.contains("password")) Main.pass = getValue(s);
            }
        }
        else {
            setProperty("login","root");
            setProperty("password","");
            updateRows();
        }


    }

    private String getValue(String text){
        int pos = text.indexOf("=");
        pos++;
        if (text.length() < pos) return "";
        return text.substring(pos);
    }

    public void changeProperty(String property,String value){
        for (int i = 0;i<text.size();i++){
            if (text.get(i).contains(property)) {
                String buff= property + "="+ value;
                text.set(i,buff);
                updateRows();
            }
        }
    }

    private void setProperty(String property,String value){
        String buff=  property + "="+ value;
        text.add(buff);
    }

    private void updateRows(){
        String outputFileName = path;
        String lineSeparator = System.getProperty("line.separator");
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String row : text) {
                writter.write(row + lineSeparator);
            }
            writter.flush();
            writter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }




}
