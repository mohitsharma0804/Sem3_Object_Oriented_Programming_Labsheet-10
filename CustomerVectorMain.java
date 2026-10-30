import java.util.Vector;

class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    public void displayDetails() {
        System.out.println("Customer [ID: " + id + " | Name: " + name + " | Email: " + email + "]");
    }
}

public class CustomerVectorMain {
    public static void main(String[] args) {
        Vector<Customer> customerVector = new Vector<>();

        customerVector.add(new Customer(1, "Amit Patel", "amit@example.com"));
        customerVector.add(new Customer(2, "Pooja Verma", "pooja@example.com"));
        customerVector.add(new Customer(3, "Ramesh Shah", "ramesh@example.com"));

        System.out.println("=== Stored Customers in Vector ===");
        for (Customer c : customerVector) {
            c.displayDetails();
        }
    }
}
