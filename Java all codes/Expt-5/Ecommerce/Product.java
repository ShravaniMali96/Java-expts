package Ecommerce;

public class Product {
    public String name;
    public double price;

    public Product(String n, double p) {
        name = n;
        price = p;
    }

    public void display() {
        System.out.println("Product: " + name + ", Price: " + price);
    }
}
