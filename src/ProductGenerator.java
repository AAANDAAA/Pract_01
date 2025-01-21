import javax.naming.Name;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <String> people = new ArrayList<>();

        File workingDirectory = new File("user.dir");
        Path file = Paths.get(workingDirectory.getPath() +"_ProductData.txt");

        String line= "===============================================================================";
        boolean doneInput = false;
        String ID = "";
        String name = "";
        String description = "";
        double cost = 0.0;
        String record = "";

        //create a loop to input person data
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID [000001] ");
            name = SafeInput.getNonZeroLenString(in, "Enter your Name ");
            description = SafeInput.getNonZeroLenString(in, "Enter the description ");
            cost = SafeInput.getDouble(in, "Enter the cost of the product");
            record = String.format("%-15s %-15s %-25s %-15.2f", ID, name, description, cost);
            System.out.println(line);
            System.out.println(record);
            people.add(record);

            doneInput = SafeInput.getYNConfirm(in, "Are you done? [Y/N]");
        }
        while (!doneInput);
        System.out.println(String.format("%-15s %-15s %-25s %-15.4s", "ID#", "Name", "Description", "Cost"));

        for(String p:people)
            System.out.println(p);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
        {

            // Finally can write the file LOL!

            for( String rec : people)
            {
                writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}

