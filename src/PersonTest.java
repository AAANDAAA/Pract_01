import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testFullName() {
        Person person = new Person("12345", "Abi", "Reg", "Mr.", 2004);
        assertEquals("Abi Reg", person.getFullName());
    }

    @Test
    public void testFormalName() {
        Person person = new Person("12345", "Abi", "Reg", "Mr.", 2004);
        assertEquals("Mr. Abi Reg", person.getFormalName());
    }

    @Test
    public void testGetAge() {
        Person person = new Person("12345", "Abi", "Reg", "Mr.", 2004);
        int currentYear = 2025;  // Adjust the current year accordingly
        assertEquals(currentYear - 2004, person.getAge());
    }

    @Test
    public void testGetAgeFor() {
        Person person = new Person("12345", "Abi", "Reg", "Mr.", 2004);
        assertEquals(11, person.getAgeFor(2015)); // 2015 - 2004 = 11
    }

    @Test
    public void testToCSV() {
        Person person = new Person("12345", "Abi", "Reg", "Mr.", 2004);
        assertEquals("\"12345\",\"Abi\",\"Reg\",\"Mr.\",2004", person.toCSV());
    }

    @Test
    public void testEquals() {
        Person person1 = new Person("12345", "Abi", "Reg", "Mr.", 2004);
        Person person2 = new Person("12345", "Abi", "Reg", "Mr.", 2004);
        assertTrue(person1.equals(person2));
    }

    @Test
    public void testNotEquals() {
        Person person1 = new Person("12345", "Abi", "Reg", "Mr.", 2004);
        Person person2 = new Person("54321", "Aps", "Reeg", "Ms.", 2000);
        assertFalse(person1.equals(person2));
    }
}
