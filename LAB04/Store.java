import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" is already in the store.");
        } else {
            itemsInStore.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
        }
    }

   public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" is not in the store.");
        }
    }

    public void printStore() {
        System.out.println("STORE");
        System.out.println("Items in Store:");
        if (itemsInStore.isEmpty()) {
            System.out.println("Store is empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                // Gọi toString() đa hình của từng loại Media (Book/CD/DVD)
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
    }
}
