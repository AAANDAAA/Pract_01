    import java.util.Objects;

    public class Person {

        private String ID;
        private String firstName;
        private String lastName;
        private String title;
        private int YOB;

        // Constructor
        public Person(String ID, String firstName, String lastName, String title, int YOB) {
            this.ID = ID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.title = title;
            this.YOB = YOB;
        }

        // Getters and Setters
        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getYOB() {
            return YOB;
        }

        public void setYOB(int YOB) {
            this.YOB = YOB;
        }

        // toString Method
        @Override
        public String toString() {
            return "Person{" +
                    "ID='" + ID + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", title='" + title + '\'' +
                    ", YOB=" + YOB +
                    '}';
        }

        // Returns the full name (first name + last name)
        public String getFullName() {
            return this.getFirstName() + " " + this.getLastName();
        }

        // Returns the formal name (title + full name)
        public String getFormalName() {
            return this.getTitle() + " " + getFullName();
        }

        // Calculates the person's age based on the current year
        public int getAge() {
            int currentYear = 2025; // For simplicity, we use a fixed year
            return currentYear - this.YOB;
        }

        // Calculates the person's age for a specific year
        public int getAgeFor(int year) {
            return year - this.YOB;
        }

        // Converts the Person object to a CSV string
        public String toCSV() {
            return "\"" + ID + "\",\"" + firstName + "\",\"" + lastName + "\",\"" + title + "\"," + YOB;
        }

        // Compares this person to another person for equality
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Person person = (Person) obj;
            return YOB == person.YOB &&
                    ID.equals(person.ID) &&
                    firstName.equals(person.firstName) &&
                    lastName.equals(person.lastName) &&
                    title.equals(person.title);
        }

        // Generates the hashCode for this object to ensure consistency
        @Override
        public int hashCode() {
            return Objects.hash(ID, firstName, lastName, title, YOB);
        }

        // Converts the Person object to a JSON string
        public String toJSON() {
            return "{" +
                    "\"ID\":\"" + this.ID + "\"," +
                    "\"firstName\":\"" + this.firstName + "\"," +
                    "\"lastName\":\"" + this.lastName + "\"," +
                    "\"title\":\"" + (this.title == null ? "" : this.title) + "\"," +
                    "\"YOB\":" + this.YOB +
                    ",\" age\":" + getAge() + // Add age to the toString output
                    "}";
        }

        // Converts the Person object to an XML string
        public String toXML() {
            return "<Person>" +
                    "<ID>" + this.ID + "</ID>" +
                    "<FirstName>" + this.firstName + "</FirstName>" +
                    "<LastName>" + this.lastName + "</LastName>" +
                    "<Title>" + (this.title == null ? "" : this.title) + "</Title>" +
                    "<YOB>" + this.YOB + "</YOB>" +
                    "</Person>";
        }
    }
