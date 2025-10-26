import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();
        Scanner scanner = new Scanner(System.in);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);


        int choice;
        while (true) {
            System.out.println();
            System.out.println("Main Menu:");
            System.out.println("1. Add a DVD to cart");
            System.out.println("2. Remove a DVD from cart");
            System.out.println("3. Show total cost");
            System.out.println("4. Print all items in cart");
            System.out.println("5. Search for DVD by ID"); 
            System.out.println("6. Search for DVD by Title"); 
            System.out.println("7. Exit"); 
            System.out.println();
            System.out.print("Please choose an option (1-7): ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 

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
                        scanner.nextLine();
                        DigitalVideoDisc newDvd = new DigitalVideoDisc(title, category, director, length, cost);
                        anOrder.addDigitalVideoDisc(newDvd);
                        break;
                    case 2:
                        System.out.println();
                        anOrder.print();
                        System.out.print("Enter the title of the DVD to remove: ");
                        String titleToRemove = scanner.nextLine();

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
                        anOrder.print();
                        break;
                    case 5:
                        System.out.println();
                        System.out.print("Enter the ID to search for: ");
                        int idToSearch = scanner.nextInt();
                        scanner.nextLine(); 
                        anOrder.searchByID(idToSearch);
                        break;
                    case 6:
                        System.out.println();
                        System.out.print("Enter the Title to search for: ");
                        String titleToSearch = scanner.nextLine();
                        anOrder.searchByTitle(titleToSearch);
                        break;

                    case 7: 
                        System.out.println("Exiting the application. Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 7.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number or correct format.");
                scanner.nextLine();
            }
        }
    }
}