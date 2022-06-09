package fileManager;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {

    private ArrayList<String> text = new ArrayList<>();

    ReadFile(File file){
        readFile(file);
    }
    ReadFile(InputStream file){
        readFile(file);
    }
    ReadFile(String file){
        readFile(file);
    }

    private void readFile(File file){
        try {
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), "UTF-8"));

            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                if (!line.equals("") || line.equals("\n")) {text.add(line);}
                //System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readFile(InputStream file){
        try {
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(file,"UTF-8"));

            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                if (!line.equals("") || line.equals("\n")) {text.add(line);}
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readFile(String path){
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);

            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                if (!line.equals("") || line.equals("\n")) {text.add(line);}
                //System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    public ArrayList<String> getText(){
        return text;
    }

}
