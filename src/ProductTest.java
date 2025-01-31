import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductDetails() {
        // Given data
        String id = "00001";
        String name = "ABI";
        String description = "hahahshsh";
        double cost = 32.12;

        // Create a Product object
        Product product = new Product(false, id, name, description, cost);

        // Test the product details
        assertEquals(id, product.getID(), "Product ID should be 00001");
        assertEquals(name, product.getName(), "Product Name should be ABI");
        assertEquals(description, product.getDescription(), "Product Description should be hahahshsh");
        assertEquals(cost, product.getCost(), 0.01, "Product Cost should be 32.12");
    }

    @Test
    public void testToString() {
        // Given data
        String id = "00001";
        String name = "ABI";
        String description = "hahahshsh";
        double cost = 32.12;

        Product product = new Product(false, id, name, description, cost);

        // Test the toString() method output
        String expectedToString = "ID: 00001, Name: ABI, Description: hahahshsh, Cost: 32.12";
        assertEquals(expectedToString, product.toString(), "Product toString output is incorrect");
    }


    @Test
    public void testToCSV() {
        // Given data
        String id = "00001";
        String name = "ABI";
        String description = "hahahshsh";
        double cost = 32.12;

        Product product = new Product(false, id, name, description, cost);

        // Test the toCSV() method output
        String expectedCSV = "00001,ABI,hahahshsh,32.12";
        assertEquals(expectedCSV, product.toCSV(), "Product toCSV output is incorrect");
    }

    @Test
    public void testEquals() {
        // Given data
        String id = "00001";
        String name = "ABI";
        String description = "hahahshsh";
        double cost = 32.12;

        Product product1 = new Product(false, id, name, description, cost);
        Product product2 = new Product(false, id, name, description, cost);

        // Test equality
        assertTrue(product1.equals(product2), "Products should be equal");
    }

    @Test
    public void testNotEquals() {
        // Given data
        String id1 = "00001";
        String name1 = "ABI";
        String description1 = "hahahshsh";
        double cost1 = 32.12;

        String id2 = "00002";
        String name2 = "John";
        String description2 = "something";
        double cost2 = 15.50;

        Product product1 = new Product(false, id1, name1, description1, cost1);
        Product product2 = new Product(false, id2, name2, description2, cost2);

        // Test inequality
        assertFalse(product1.equals(product2), "Products should not be equal");
    }

}

