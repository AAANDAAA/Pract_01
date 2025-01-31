import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ProductReader {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();  // List to store Product objects

        final int FIELDS_LENGTH = 4;  // Adjusted for product fields (ID, Name, Description, Cost)

        String ID, name, description;
        double cost;

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
                    System.out.printf("\nLine %4d %-60s ", line, rec);  // Output each line (optional)
                }
                reader.close();
                System.out.println("\n\nData file read!");

                // Process the lines and create Product objects
                String[] fields;
                for (String l : lines) {
                    fields = l.split(",");  // Split the line by commas

                    if (fields.length == FIELDS_LENGTH) {
                        // Trim and clean the data (remove quotes if needed)
                        ID = fields[0].trim().replace("\"", "");
                        name = fields[1].trim().replace("\"", "");
                        description = fields[2].trim().replace("\"", "");
                        try {
                            cost = Double.parseDouble(fields[3].trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Skipping invalid cost value: " + fields[3]);
                            continue;  // Skip this line if there's an error in cost
                        }

                        // Create a Product object and add it to the list
                        Product product = new Product(false, ID, name, description, cost);
                        products.add(product);  // Add the Product to the list
                    } else {
                        System.out.println("Found a record that may be corrupt: ");
                        System.out.println(l);
                    }
                }

                // Now print the list of all Product objects
                System.out.println("\n\nList of all Products:");
                for (Product product : products) {
                    System.out.println(product);  // This will call the toString() method of Product
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
