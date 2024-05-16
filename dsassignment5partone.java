// Name: Chidera Anamege




import java.util.PriorityQueue;
import java.util.Scanner;
public class dsassignment5partone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create a priority queue to store chores
        PriorityQueue<Chore> choreQueue = new PriorityQueue<>();
        boolean running = true;
        while (running) {
            // display menu options
            System.out.println("Menu:");
            System.out.println("1. Add chore");
            System.out.println("2. Remove chore");
            System.out.println("3. Display chores");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            // switch case to handle user choices
            switch (choice) {
                // case to add a chore
                case 1:
                    System.out.print("Enter chore name: ");
                    // take chore name input
                    String choreName = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    // take chore priority input
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    // add chore to the priority queue
                    choreQueue.offer(new Chore(choreName, priority));
                    break;
                // case to remove a chore
                case 2:
                    // check if the queue is empty
                    if (choreQueue.isEmpty()) {
                        System.out.println("Chore queue is empty.");
                    } else {
                        // remove and display the chore with the highest priority
                        Chore nextChore = choreQueue.poll();
                        System.out.println("Removed chore: " + nextChore.getName() + " with priority: " + nextChore.getPriority());
                    }
                    break;
                // case to display all chores
                case 3:
                    // check if the queue is empty
                    if (choreQueue.isEmpty()) {
                        System.out.println("Chore queue is empty.");
                    } else {
                        // display all chores in the queue
                        System.out.println("Current chores:");
                        for (Chore chore : choreQueue) {
                            System.out.println(chore.getName() + " - Priority: " + chore.getPriority());
                        }
                    }
                    break;
                case 4:
                    running = false;
                    break;
                // default case for invalid input
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}

// class to represent/compare a chore
class Chore implements Comparable<Chore> {
    private String name;
    private int priority;

    // constructor to initialize chore
    public Chore(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    // getter method for chore name
    public String getName() {
        return name;
    }

    // getter method for chore priority
    public int getPriority() {
        return priority;
    }

    // method to compare chores based on priority
    @Override
    public int compareTo(Chore other) {
        return Integer.compare(this.priority, other.priority);
    }
}