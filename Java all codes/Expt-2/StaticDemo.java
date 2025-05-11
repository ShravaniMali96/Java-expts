public class StaticDemo {
    static int count;
    static {
        count = 5;
        System.out.println("Static block called");
    }

    static void display() {
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        StaticDemo.display();
    }
}
