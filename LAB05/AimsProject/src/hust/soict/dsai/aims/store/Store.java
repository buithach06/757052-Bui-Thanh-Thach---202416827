package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsInStore.add(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("Failed to add the media \"" + media.getTitle() + "\" to the store.");
        }
    }

    public void removeMediaByTitle(String title) {
        Media found = searchByTitle(title);

        if (found != null) {
            itemsInStore.remove(found);
            System.out.println("The media \"" + found.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("No media with title \"" + title + "\" was found in the store.");
        }
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public void printStore() {
        System.out.println("\n*** Items currently available in store ***");
        int count = 1;
        for (Media media : itemsInStore) {
            System.out.println(count + ". " + media.toString());
            count++;
        }
        System.out.println("*******************************************");
    }
}
