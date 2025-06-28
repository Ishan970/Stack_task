package Stack.Stack_task;

// Q3: Design a program that simulates a supermarket queue management system using an array-based implementation of a queue.
// The system should allow customers to join the queue, get served, and exit the queue.
// Implement the following functionalities:
// a. Add a customer to the queue.
// b. Serve the next customer in the queue.
// c. Display the current queue.
// d. Display the number of customers in the queue.
// e. Exit the program.

import java.util.Scanner;

public class q3 {
    private static final int MAX_SIZE = 100;
    private String[] queue = new String[MAX_SIZE];
    private int front = 0;
    private int rear = -1;
    private int count = 0;

    // Add a customer to the queue
    public void addCustomer(String name) {
        if (count == MAX_SIZE) {
            System.out.println("Queue is full. Cannot add more customers.");
        } else {
            rear = (rear + 1) % MAX_SIZE;
            queue[rear] = name;
            count++;
            System.out.println(name + " added to the queue.");
        }
    }

    // Serve the next customer
    public void serveCustomer() {
        if (count == 0) {
            System.out.println("No customers to serve.");
        } else {
            System.out.println("Serving customer: " + queue[front]);
            front = (front + 1) % MAX_SIZE;
            count--;
        }
    }

    // Display the current queue
    public void displayQueue() {
        if (count == 0) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Current Queue: ");
            for (int i = 0; i < count; i++) {
                System.out.print(queue[(front + i) % MAX_SIZE] + " ");
            }
            System.out.println();
        }
    }

    // Display the number of customers in the queue
    public void displayCount() {
        System.out.println("Number of customers in the queue: " + count);
    }

    // Main method to run the system
    public static void main(String[] args) {
        q3 supermarketQueue = new q3();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Supermarket Queue System ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. Display Queue");
            System.out.println("4. Display Number of Customers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    supermarketQueue.addCustomer(name);
                    break;
                case 2:
                    supermarketQueue.serveCustomer();
                    break;
                case 3:
                    supermarketQueue.displayQueue();
                    break;
                case 4:
                    supermarketQueue.displayCount();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}

