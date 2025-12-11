package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import hust.soict.dsai.aims.media.Media;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full! Cannot add " + media.getTitle());
            return;
        }

        if (itemsOrdered.contains(media)) {
            System.out.println(media.getTitle() + " is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("The media is not in the cart.");
        }
    }
    
    public void removeMediaByTitle(String title) {
        Media m = searchByTitle(title);
        if (m != null) {
            itemsOrdered.remove(m);
            System.out.println("Removed: " + title);
        } else {
            System.out.println("No media found with title: " + title);
        }
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void printCart() {
        System.out.println("******** CART ********");
        for (Media m : itemsOrdered) System.out.println(m.toString());
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("**********************");
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void filterMenu() {
        System.out.println("Filter by:");
        System.out.println("1. By ID (index)");
        System.out.println("2. By title");
        System.out.print("Your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Enter ID (index starting from 0): ");
                int id = Integer.parseInt(scanner.nextLine());

                if (id >= 0 && id < itemsOrdered.size()) {
                    System.out.println(itemsOrdered.get(id).toString());
                } else {
                    System.out.println("Invalid ID.");
                }
                break;

            case 2:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                Media m = searchByTitle(title);

                if (m != null) System.out.println(m.toString());
                else System.out.println("No media found with that title.");
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    public void sortMenu() {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.print("Your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Collections.sort(itemsOrdered, Comparator.comparing(Media::getTitle));
                System.out.println("Sorted by title.");
                break;

            case 2:
                Collections.sort(itemsOrdered, Comparator.comparing(Media::getCost));
                System.out.println("Sorted by cost.");
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        printCart();
    }

    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("Cart is now empty. Order placed!");
    }
}
