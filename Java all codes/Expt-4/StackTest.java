interface Stack {
    int size = 5;
    void push(int val);
    void pop();
    void display();
    void overflow();
    void underflow();
}

class IntegerStack implements Stack {
    int[] arr = new int[size];
    int top = -1;

    public void push(int val) {
        if (top == size - 1)
            overflow();
        else
            arr[++top] = val;
    }

    public void pop() {
        if (top == -1)
            underflow();
        else
            top--;
    }

    public void display() {
        for (int i = 0; i <= top; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void overflow() {
        System.out.println("Stack Overflow");
    }

    public void underflow() {
        System.out.println("Stack Underflow");
    }
}

public class StackTest {
    public static void main(String[] args) {
        IntegerStack s = new IntegerStack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.display();
        s.pop();
        s.pop();
        s.display();
    }
}
