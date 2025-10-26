public class Store {
    public static final int MAX_CAPACITY = 100; 
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_CAPACITY];
    private int qtyInStore = 0;
    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_CAPACITY) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("Da them DVD \"" + disc.getTitle() + "\" vao cua hang.");
        } else {
            System.out.println("Cua hang da day. Khong the them \"" + disc.getTitle() + "\".");
        }
    }
    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                
                System.out.println("Da xoa DVD \"" + disc.getTitle() + "\" khoi cua hang.");
                break; 
            }
        }
        if (!found) {
            System.out.println("Loi: Khong tim thay DVD \"" + disc.getTitle() + "\" trong cua hang.");
        }
    }

    public void printStore() {
        System.out.println();
        if (qtyInStore == 0) {
            System.out.println("Cua hang hien dang trong.");
        } else {
            for (int i = 0; i < qtyInStore; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i].toString());
            }
        }
        System.out.println();
    }
}