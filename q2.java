package Stack.Stack_task;

// Q2: You are tasked with implementing a stack data structure in Java without using any built-in libraries. 
// Your goal is to create a CustomStack class that can handle various operations. 
// The class should have the following functionalities:
// push(int val): Adds an integer value val to the top of the stack.
// pop(): Removes and returns the element at the top of the stack.
// peek(): Returns the element at the top of the stack without removing it.
// isEmpty(): Checks if the stack is empty and returns a boolean value indicating the result.
// isFull(): Checks if the stack is full and returns a boolean value indicating the result.

public class q2 {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor
    public q2(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    // Adds an element to the top of the stack
    public void push(int val) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + val);
        } else {
            stack[++top] = val;
            System.out.println("Pushed: " + val);
        }
    }

    // Removes and returns the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to pop.");
            return -1;
        } else {
            int popped = stack[top--];
            System.out.println("Popped: " + popped);
            return popped;
        }
    }

    // Returns the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return -1;
        } else {
            System.out.println("Peek: " + stack[top]);
            return stack[top];
        }
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Checks if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Optional: Display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack (top to bottom): ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the CustomStack
    public static void main(String[] args) {
        q2 customStack = new q2(4); // create stack of size 4

        customStack.push(5);
        customStack.push(10);
        customStack.push(15);
        customStack.peek();
        customStack.display();
        customStack.pop();
        customStack.display();
        System.out.println("Is stack full? " + customStack.isFull());
        System.out.println("Is stack empty? " + customStack.isEmpty());
    }
}
