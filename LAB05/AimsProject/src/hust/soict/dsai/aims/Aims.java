package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {

    static Scanner scanner = new Scanner(System.in);
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    storeMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cartMenu();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        store.printStore();

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                mediaDetailsMenu();
                break;
            case 2:
                addMediaToCart();
                break;
            case 3:
                playMedia();
                break;
            case 4:
                cartMenu();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid!");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media m = store.searchByTitle(title);

        if (m == null) {
            System.out.println("Media not found!");
            return;
        }

        System.out.println(m.toString());

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                cart.addMedia(m);
                break;
            case 2:
                m.tryPlay();
                break;
            case 0:
                return;
        }
    }

    public static void updateStoreMenu() {
        System.out.println("Update store:");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        System.out.print("Your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                break;
            case 2:
                System.out.print("Enter title to remove: ");
                String title = scanner.nextLine();
                store.removeMediaByTitle(title);
                break;
            case 0:
                return;
        }
    }

    public static void cartMenu() {
        cart.printCart();

        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                cart.filterMenu();
                break;
            case 2:
                cart.sortMenu();
                break;
            case 3:
                removeMediaFromCart();
                break;
            case 4:
                playMediaInCart();
                break;
            case 5:
                System.out.println("Order created! Clearing cart...");
                cart.emptyCart();
                break;
            case 0:
                return;
        }
    }

    private static void addMediaToCart() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media m = store.searchByTitle(title);
        if (m != null) cart.addMedia(m);
        else System.out.println("Media not found!");
    }

    private static void playMedia() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media m = store.searchByTitle(title);
        if (m != null) m.tryPlay();
        else System.out.println("Media not found!");
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        cart.removeMediaByTitle(title);
    }

    private static void playMediaInCart() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media m = cart.searchByTitle(title);
        if (m != null) m.tryPlay();
        else System.out.println("Media not found!");
    }
}
