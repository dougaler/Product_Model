import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ProductWriter {
    public static void main(String[] args) throws IOException {
        ArrayList<String> Persondata = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String IDnum = " ";
        String name = " ";
        String description = " ";
        String Fullguy = " ";
        double cost = 0;
        boolean done = false;
        System.out.println("Enter the following information when prompted: ID #, First Name, Last Name, Title, Year of Birth");
        do{
            IDnum = SafeInput.getNonZeroLenString(in,"Enter 6 digit ID number");
            name = SafeInput.getNonZeroLenString(in,"Enter name");
            description = SafeInput.getNonZeroLenString(in,"Enter description");
            cost = SafeInput.getDouble(in,"Enter cost");
            Fullguy = IDnum + ", " + name + ", " + description + ", " + cost;
            Persondata.add(Fullguy);
            done = SafeInput.getYNConfirm(in,"Would you like to end? Enter Y to quit. Enter N to add another");

        }while(!done);
        System.out.println(Persondata);
        Path path = Paths.get("C:\\Users\\legol\\IdeaProjects\\Product_Model\\src\\ProductTestData.txt");
        //create file
        try {
            Path createdFilePath = Files.createFile(path);
            System.out.println("Created a file at : "+createdFilePath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Files.write(path, Persondata);
    }
}