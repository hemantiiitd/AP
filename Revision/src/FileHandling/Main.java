package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {

        // Opening a file
        try {
            File myFile = new File("test.txt");
            myFile.createNewFile();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // code to write a file
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("test.txt",true);
            fileWriter.write("\nBc I am making file yeyeye!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if(fileWriter!=null)fileWriter.close();
        }

        File file = new File("test.txt");

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line  = sc.nextLine();
                System.out.println(line);
            }

            sc.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        file.delete();
    }
}