import Ecommerce.*;

public class EcommerceTest {
    public static void main(String[] args) {
        Product p = new Product("Phone", 29999);
        Customer c = new Customer("Bob", 101);
        Order o = new Order(p, c, 2);
        o.placeOrder();
    }
}
