import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();
        Scanner scanner = new Scanner(System.in);

        // Add a few initial DVDs to the cart for a starting point
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);

        int choice;
        while (true) {
            System.out.println();
            System.out.println("Main Menu:");
            System.out.println("1. Add a DVD to cart");
            System.out.println("2. Remove a DVD from cart");
            System.out.println("3. Show total cost");
            System.out.println("4. Print all items in cart"); // Changed to show all items
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Please choose an option (1-5): ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        System.out.println();
                        System.out.println("Enter DVD details to add to the cart:");
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Category: ");
                        String category = scanner.nextLine();
                        System.out.print("Director: ");
                        String director = scanner.nextLine();
                        System.out.print("Length (minutes): ");
                        int length = scanner.nextInt();
                        System.out.print("Cost ($): ");
                        float cost = scanner.nextFloat();
                        scanner.nextLine(); // Consume newline left-over

                        DigitalVideoDisc newDvd = new DigitalVideoDisc(title, category, director, length, cost);
                        anOrder.addDigitalVideoDisc(newDvd);
                        break;
                    case 2:
                        System.out.println();
                        anOrder.print(); // Display current items in cart to help the user choose
                        System.out.print("Enter the title of the DVD to remove: ");
                        String titleToRemove = scanner.nextLine();

                        // Use findByTitle to get the actual DVD object for removal
                        DigitalVideoDisc dvdToRemove = anOrder.findByTitle(titleToRemove);
                        if (dvdToRemove != null) {
                            anOrder.removeDigitalVideoDisc(dvdToRemove);
                        } else {
                            System.out.println("DVD not found in the cart.");
                        }
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("Total Cost is: " + anOrder.totalCost());
                        break;
                    case 4:
                        anOrder.print(); // Call the print() method from the Cart class
                        break;
                    case 5:
                        System.out.println("Exiting the application. Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number or correct format.");
                scanner.nextLine();
            }
        }
    }
}