package Ecommerce;

public class Customer {
    public String name;
    public int id;

    public Customer(String n, int i) {
        name = n;
        id = i;
    }

    public void display() {
        System.out.println("Customer: " + name + ", ID: " + id);
    }
}
