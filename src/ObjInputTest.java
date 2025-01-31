import java.util.Scanner;

public class ObjInputTest {
    public static void main(String[] args) {
        // Create a SafeInputObj instance using default constructor (System.in)
        SafeInputObj input = new SafeInputObj();

        // Test getNonZeroLenString method
        String name = input.getNonZeroLenString("Enter your name");
        System.out.println("Name entered: " + name);

        // Test getRangedInt method
        int age = input.getRangedInt("Enter your age", 0, 100);
        System.out.println("Age entered: " + age);

        // Test getYNConfirm method
        boolean confirmed = input.getYNConfirm("Do you confirm?");
        System.out.println("Confirmation: " + (confirmed ? "Yes" : "No"));
    }
    }

