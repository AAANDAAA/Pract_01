import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

public class Product {
    boolean doneInput = false;
    String ID = "";
    String name = "";
    String description = "";
    double cost = 0.0;

    public Product(boolean doneInput, String ID, String name, String description, double cost) {
        this.doneInput = doneInput;
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public boolean isDoneInput() {
        return doneInput;
    }

    public void setDoneInput(boolean doneInput) {
        this.doneInput = doneInput;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public String toCSV() {
        return ID + "," + name + "," + description + "," + cost;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Description: " + description + ", Cost: " + cost;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product other = (Product) obj;
        return Double.compare(other.cost, cost) == 0 &&
                ID.equals(other.ID) &&
                name.equals(other.name) &&
                description.equals(other.description);
    }

    // Save product details to file in CSV format (ID, Name, Description, Cost)
    public void saveToFile(BufferedWriter writer) throws IOException {
        writer.write(String.format("%s,%s,%s,%.2f", ID, name, description, cost));
        writer.newLine();
    }
    public String toJSON() {
        return "{" +
                "\"ID\":\"" + this.ID + "\"," +
                "\"name\":\"" + this.name + "\"," +
                "\"description\":\"" + this.description + "\"," +
                "\"cost\":" + String.format("%.2f", this.cost) +
                "}";
    }

    // Converts the Product object to an XML string
    public String toXML() {
        return "<Product>" +
                "<ID>" + this.ID + "</ID>" +
                "<Name>" + this.name + "</Name>" +
                "<Description>" + this.description + "</Description>" +
                "<Cost>" + String.format("%.2f", this.cost) + "</Cost>" +
                "</Product>";
    }
}




