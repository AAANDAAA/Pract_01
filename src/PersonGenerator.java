import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {

        ArrayList <String> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File("user.dir");
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");


        boolean doneInput = false;
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;
        String record = "";

        //create a loop to input person data
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID [000001] ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your First Name ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your Last name ");
            title = SafeInput.getNonZeroLenString(in, "Enter your title ");
            YOB = SafeInput.getRangedInt(in, "Enter your year of birth ", 1000, 9999);
            record = ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
            System.out.println(record);
            people.add(record);

            doneInput = SafeInput.getYNConfirm(in, "Are you done? [Y/N]");
        }
        while (!doneInput);

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

