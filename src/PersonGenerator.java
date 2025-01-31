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

        ArrayList<Person> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        // Get the working directory
        String workingDirectory = System.getProperty("user.dir");
        Path file = Paths.get(workingDirectory, "personData.txt"); // Create the path for the file

        boolean doneInput = false;
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;
        String record = "";

        // Loop to input person data
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID [000001] ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your First Name ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your Last name ");
            title = SafeInput.getNonZeroLenString(in, "Enter your title ");
            YOB = SafeInput.getRangedInt(in, "Enter your year of birth ", 1000, 9999);
            record = String.format("%-10s %-15s %-15s %-25s %-10d", ID, firstName, lastName, title, YOB);
            System.out.println(record);

            Person person = new Person(ID, firstName, lastName, title, YOB);
            people.add(person);

            doneInput = SafeInput.getYNConfirm(in, "Are you done? [Y/N]");
        } while (!doneInput);

        // Print the people details
        System.out.println(String.format("%-10s %-15s %-15s %-25s %-10s", "ID#", "First Name", "Last Name", "Title", "YOB"));
        for (Person p : people) {
            System.out.println(String.format("%-10s %-15s %-15s %-25s %-10d", p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYOB()));
        }

        // Write the data to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
            for (Person p : people) {
                writer.write(p.toCSV());  // Write each person's CSV representation
                writer.newLine();
            }
            System.out.println("Data saved to file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

