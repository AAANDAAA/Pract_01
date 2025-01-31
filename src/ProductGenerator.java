import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();  // Fixed variable name

        String workingDirectory = System.getProperty("user.dir");
        Path file = Paths.get(workingDirectory, "productData.txt"); // Create the path for the file

        boolean doneInput = false;
        String ID = "";
        String name = "";
        String description = "";
        double cost = 0.0;

        // Create a loop to input product data
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID [000001] ");
            name = SafeInput.getNonZeroLenString(in, "Enter your Name ");
            description = SafeInput.getNonZeroLenString(in, "Enter the description ");
            cost = SafeInput.getDouble(in, "Enter the cost of the product");

            Product product = new Product(doneInput, ID, name, description, cost);

            // Add the product to the ArrayList
            products.add(product);

            doneInput = SafeInput.getYNConfirm(in, "Are you done? [Y/N]");

        } while (!doneInput);  // Keep looping until the user is done

        System.out.println(String.format("%-15s %-15s %-25s %-15s", "ID#", "Name", "Description", "Cost"));

        // Print out the products in the ArrayList
        for (Product p : products) {
            System.out.println(p);
        }

        // Save the products to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
            for (Product p : products) {
                writer.write(p.toCSV());  // Write each product's CSV representation
                writer.newLine();
            }
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

