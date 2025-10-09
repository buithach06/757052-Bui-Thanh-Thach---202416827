public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    //Add a disc
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \""+ disc.getTitle() +"\" has been added.");

            if (qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
                System.out.println("The cart is almost full");
            } else if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full");
            }
        } else {
            System.out.println("Cannot add. The cart is full");
        }
    }
    //Remove a disc
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].equals(disc)) {
                found = true;
                // Shift elements left
                for (int j = i; j < qtyOrdered; j++) {
                    itemOrdered[j] = itemOrdered[j+1];
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
    // Calculate the total cost
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemOrdered[i].getCost();
        }
        return total;
    }
}
