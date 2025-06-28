package Stack.Stack_task;

// Q4: Implement a call center queue using an array-based implementation of a queue. 
// The program should allow call center agents to handle incoming calls in a fair manner.
// Implement the following functionalities:
// a. Add an incoming call to the queue.
// b. Serve and handle the next call in the queue.
// c. Display the current call queue.
// d. Display the number of pending calls.
// e. Exit the program.

import java.util.Scanner;

public class q4 {
    private static final int MAX_CALLS = 100;
    private String[] callQueue = new String[MAX_CALLS];
    private int front = 0;
    private int rear = -1;
    private int count = 0;

    // Add an incoming call to the queue
    public void addCall(String caller) {
        if (count == MAX_CALLS) {
            System.out.println("Call queue is full. Cannot accept more calls.");
        } else {
            rear = (rear + 1) % MAX_CALLS;
            callQueue[rear] = caller;
            count++;
            System.out.println("Incoming call from " + caller + " added to the queue.");
        }
    }

    // Serve and handle the next call in the queue
    public void serveCall() {
        if (count == 0) {
            System.out.println("No pending calls to serve.");
        } else {
            System.out.println("Handling call from: " + callQueue[front]);
            front = (front + 1) % MAX_CALLS;
            count--;
        }
    }

    // Display the current call queue
    public void displayQueue() {
        if (count == 0) {
            System.out.println("Call queue is empty.");
        } else {
            System.out.print("Current Call Queue: ");
            for (int i = 0; i < count; i++) {
                System.out.print(callQueue[(front + i) % MAX_CALLS] + " ");
            }
            System.out.println();
        }
    }

    // Display the number of pending calls
    public void displayPendingCalls() {
        System.out.println("Number of pending calls: " + count);
    }

    // Main method to run the call center system
    public static void main(String[] args) {
        q4 callCenter = new q4();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Call Center Queue System ---");
            System.out.println("1. Add Incoming Call");
            System.out.println("2. Serve Next Call");
            System.out.println("3. Display Call Queue");
            System.out.println("4. Display Number of Pending Calls");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter caller name or ID: ");
                    String caller = scanner.nextLine();
                    callCenter.addCall(caller);
                    break;
                case 2:
                    callCenter.serveCall();
                    break;
                case 3:
                    callCenter.displayQueue();
                    break;
                case 4:
                    callCenter.displayPendingCalls();
                    break;
                case 5:
                    System.out.println("Exiting Call Center System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}

