
import java.util.Collections;
import java.util.Scanner;

import media.Book;
import media.CompactDisc;
import media.DigitalVideoDisc;
import media.Media;
import media.Playable;
import media.Track;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSetup();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }


    public static void viewStore() {
        store.printStore();
        
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCartFromStore();
                    break;
                case 3:
                    playMediaFromStore();
                    break;
                case 4:
                    seeCurrentCart(); 
                    break;
                case 0:
                    System.out.println("Back to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }


    public static void seeMediaDetails() {
        System.out.print("Enter title of media: ");
        String title = scanner.nextLine();
        Media media = store.findMedia(title); 

        if (media != null) {
            System.out.println(media.toString());
            int subChoice;
            do {
                mediaDetailsMenu();
                subChoice = scanner.nextInt();
                scanner.nextLine();
                if (subChoice == 1) {
                    cart.addMedia(media);
                } else if (subChoice == 2) {
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played!");
                    }
                } else if (subChoice == 0) {
                    System.out.println("Back to Store menu...");
                }
            } while (subChoice != 0);
        } else {
            System.out.println("Media not found!");
        }
    }

    // Thêm vào Cart từ Store
    public static void addMediaToCartFromStore() {
        System.out.print("Enter title of media to add: ");
        String title = scanner.nextLine();
        Media media = store.findMedia(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Current items in cart: " + cart.getItemsOrdered().size());
        } else {
            System.out.println("Media not found in store.");
        }
    }

    // Play từ Store
    public static void playMediaFromStore() {
        System.out.print("Enter title of media to play: ");
        String title = scanner.nextLine();
        Media media = store.findMedia(title);
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media is not playable (It might be a Book).");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    // Update Store
    public static void updateStore() {
        System.out.println("1. Add a new Media");
        System.out.println("2. Remove a Media");
        System.out.print("Choose option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            System.out.println("Enter details for new DVD:");
            System.out.print("Title: "); String title = scanner.nextLine();
            System.out.print("Category: "); String category = scanner.nextLine();
            System.out.print("Cost: "); float cost = scanner.nextFloat();
            store.addMedia(new DigitalVideoDisc(0, title, category, cost, 0, "Unknown"));
        } else if (option == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media media = store.findMedia(title);
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Media not found!");
            }
        }
    }

    // See Current Cart
    public static void seeCurrentCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    Media media = cart.findMedia(title);
                    if(media != null) cart.removeMedia(media);
                    else System.out.println("Media not found in cart.");
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String playTitle = scanner.nextLine();
                    Media playMedia = cart.findMedia(playTitle);
                    if(playMedia != null && playMedia instanceof Playable) 
                        ((Playable)playMedia).play();
                    else 
                        System.out.println("Cannot play this media.");
                    break;
                case 5:
                    System.out.println("An order has been created!");
                    cart = new Cart(); // Reset giỏ hàng
                    System.out.println("Cart is now empty.");
                    break;
                case 0:
                    System.out.println("Back to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    public static void filterCart() {
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        int option = scanner.nextInt();
        scanner.nextLine();
        
        if (option == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            cart.searchByID(id);
        } else {
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        }
    }

    public static void sortCart() {
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Cost");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
            System.out.println("Sorted by Title.");
            cart.print();
        } else {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
            System.out.println("Sorted by Cost.");
            cart.print();
        }
    }

    public static void initSetup() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f, 100, "Guy Ritchie");
        
        Book book1 = new Book(4, "Harry Potter", "Fantasy", 50.0f);
        book1.addAuthor("J.K. Rowling");
        
        CompactDisc cd1 = new CompactDisc(5, "Adele 30", "Music", 30.5f, 120, "Producer X", "Adele");
        cd1.addTrack(new Track("Easy On Me", 4));
        cd1.addTrack(new Track("My Little Love", 5));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(cd1);
    }
}