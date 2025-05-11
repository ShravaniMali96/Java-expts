import java.util.*;

public class StackQueueDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack pop: " + stack.pop());

        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Queue remove: " + queue.remove());
    }
}
