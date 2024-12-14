import java.util.Scanner;
import java.util.ArrayList;

public class Lab_11_Listmaker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        boolean quit = false;

        do {
            displayMenu();
            String choice = SafeInput.getRegExString(scan, "Choose an option", "[AaDdIiPpQq]").toUpperCase();

            switch(choice) {
                case "A":
                    System.out.print("Enter the item to add: ");
                    String item = SafeInput.getNonZeroLenString(scan, "Enter the item to add");
                    list.add(item);
                    System.out.println("Item added!");
                    break;
                case "D":
                    if(list.isEmpty()) {
                        System.out.println("The list is empty. Nothing to delete.");
                    } else {
                        printList(list);
                        int index = SafeInput.getRangedInt(scan, "Enter the number of the item to delete", 1, list.size()) - 1;
                        String removedItem = list.remove(index);
                        System.out.println("Removed: " + removedItem);
                    }
                    break;
                case "I":
                    if(list.isEmpty()) {
                        System.out.println("The list is empty. Adding the item to the first position.");
                        String newItem = SafeInput.getNonZeroLenString(scan, "Enter the item to insert: ");
                        list.add(newItem);
                    } else {
                        printList(list);
                        int position = SafeInput.getRangedInt(scan, "Enter the position to insert at", 1, list.size() + 1) - 1;
                        String newItem = SafeInput.getNonZeroLenString(scan, "Enter the item to insert: ");
                        list.add(position, newItem);
                        System.out.println("Item inserted!");
                    }
                    break;
                case "P":
                    printList(list);
                    break;
                case "Q":
                    quit = SafeInput.getYNConfirm(scan, "Are you sure you want to quit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while(!quit);
        System.out.println("Goodbye!");
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void printList(ArrayList<String> list) {
        System.out.println("\nCurrent List:");
        if(list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for(int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ": " + list.get(i));
            }
        }
    }
}
