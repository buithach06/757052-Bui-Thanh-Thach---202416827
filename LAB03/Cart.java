public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    
    // Add a disc to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");

            if (qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
                System.out.println("The cart is almost full");
            } else if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full");
            }
        } else {
            System.out.println("Cannot add. The cart is full");
        }
    }
    
    // Remove a disc from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].equals(disc)) {
                found = true;
                // Shift elements left
                for (int j = i; j < qtyOrdered; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                itemOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed");
                break;
            }
        }
        if (!found) {
            System.out.println("Disc not found in the cart.");
        }
    }
    
    // Calculate the total cost of all discs in the cart
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemOrdered[i].getCost();
        }
        return total;
    }
    
    // Prints the items in the cart
    public void print() {
        System.out.println();
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(i + 1 + ". " + itemOrdered[i].getTitle() + " - " + itemOrdered[i].getCost() + " $");
        }
        System.out.println("Total cost: " + totalCost() + " $");

    }

    // Searches for a specific disc in the cart
    public boolean searchDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            // You'll need to override the equals() method in your DigitalVideoDisc class for this to work correctly.
            if (itemOrdered[i].equals(disc)) {
                return true;
            }
        }
        return false;
    }
    
    // Finds a disc by its title
    public DigitalVideoDisc findByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getTitle().equalsIgnoreCase(title)) {
                return itemOrdered[i];
            }
        }
        return null; // Return null if not found
    }
}