package Ecommerce;

public class Order {
    public Product product;
    public Customer customer;
    public int quantity;

    public Order(Product p, Customer c, int q) {
        product = p;
        customer = c;
        quantity = q;
    }

    public void placeOrder() {
        customer.display();
        product.display();
        System.out.println("Total: " + (product.price * quantity));
    }
}
