package Stack.Stack_task;
// Q1: As a software developer, you have been assigned a task to implement a stack data structure in Java.
// Your goal is to create a Java class that represents a stack using an array. 
// Implement the following operations:
// push(int element): Adds an integer value element to the top of the stack.
// pop(): Removes and returns the element at the top of the stack.
// peek(): Returns the element at the top of the stack without removing it.
// isEmpty(): Checks if the stack is empty and returns a boolean value indicating the result.
// size(): Returns the number of elements currently in the stack.
// Ensure that the stack follows the last-in, first-out (LIFO) principle.

public class q1 {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public q1(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    // Adds an element to the top of the stack
    public void push(int element) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow. Cannot push " + element);
        } else {
            top++;
            stack[top] = element;
            System.out.println("Pushed: " + element);
        }
    }

    // Removes and returns the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow. Nothing to pop.");
            return -1;
        } else {
            int popped = stack[top];
            top--;
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

    // Returns the number of elements in the stack
    public int size() {
        return top + 1;
    }

    // Displays the current stack
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

    // Main method to test the stack
    public static void main(String[] args) {
        q1 myStack = new q1(5); // stack with size 5

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.peek();
        myStack.display();
        myStack.pop();
        myStack.display();
        System.out.println("Stack size: " + myStack.size());
        System.out.println("Is stack empty? " + myStack.isEmpty());
    }
}
