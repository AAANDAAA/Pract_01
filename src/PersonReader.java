import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PersonReader {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();  // List to store Person objects

        final int FIELDS_LENGTH = 5;

        String id, firstName, lastName, title;
        int yob;

        try {

            // Use the toolkit to get the current working directory of the IDE
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                // Read the file using BufferedReader
                InputStream in = new BufferedInputStream(Files.newInputStream(file));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    lines.add(rec);  // Add each line to the list
                    line++;
                    System.out.printf("\nLine %4d %-60s ", line, rec);
                }
                reader.close();
                System.out.println("\n\nData file read!");

                // Process the lines and create Person objects
                String[] fields;
                for (String l : lines) {
                    fields = l.split(",");

                    if (fields.length == FIELDS_LENGTH) {
                        id = fields[0].trim().replace("\"", "");
                        firstName = fields[1].trim().replace("\"", "");
                        lastName = fields[2].trim().replace("\"", "");
                        title = fields[3].trim().replace("\"", "");
                        yob = Integer.parseInt(fields[4].trim());

                        // Create a Person object and add it to the list
                        Person person = new Person(id, firstName, lastName, title, yob);
                        people.add(person);  // Add the Person to the list
                    } else {
                        System.out.println("Found a record that may be corrupt: ");
                        System.out.println(l);
                    }
                }

                // Now print the list of all Person objects
                System.out.println("\n\nList of all Persons:");
                for (Person person : people) {
                    System.out.println(person);  // This will call the toString() method
                }

            } else {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

