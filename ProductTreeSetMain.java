import java.util.TreeSet;

class Product implements Comparable<Product> {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void display() {
        System.out.println("Product [ID: " + productId + " | Name: " + name + " | Price: $" + price + "]");
    }

    // Implement compareTo to sort by price ascending
    @Override
    public int compareTo(Product other) {
        if (this.price != other.price) {
            return Double.compare(this.price, other.price);
        }
        return Integer.compare(this.productId, other.productId);
    }
}

public class ProductTreeSetMain {
    public static void main(String[] args) {
        TreeSet<Product> productSet = new TreeSet<>();

        productSet.add(new Product(1, "Laptop", 1200.50));
        productSet.add(new Product(2, "Mouse", 25.00));
        productSet.add(new Product(3, "Keyboard", 45.99));
        productSet.add(new Product(4, "Monitor", 300.00));
        productSet.add(new Product(5, "Headphones", 85.00));

        System.out.println("=== Products Sorted by Price (Ascending Order) ===");
        for (Product p : productSet) {
            p.display();
        }
    }
}
