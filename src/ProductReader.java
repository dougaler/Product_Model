import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        ArrayList<String> Persondata = new ArrayList<>();
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path Filename;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        try
        {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();

                inFile = new Scanner(target);
                int i = 5;
                Filename = target.getName(i);
                System.out.printf("%-12s","ID#");
                System.out.printf("%-12s","Name");
                System.out.printf("%-25s","Description");
                System.out.printf("%-12s","Cost");
                System.out.println();
                System.out.print("=======================================================");
                System.out.println();
                while(inFile.hasNextLine())
                {
                    line = inFile.nextLine();

                    List formater = Arrays.asList(line.split(", "));

                    for(int j= 0; j < formater.size(); j++) {
                        if(j == 2){
                            System.out.printf("%-25s", formater.get(j));
                        }else {
                            System.out.printf("%-12s", formater.get(j));
                        }
                    }
                    System.out.println();

                }

                inFile.close();
            }
            else
            {
                System.out.println("You did not choose a file. Quitting.");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }

}