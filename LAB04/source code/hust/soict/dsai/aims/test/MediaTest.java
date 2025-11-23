

import java.util.ArrayList;
import java.util.List;

import media.Book;
import media.CompactDisc;
import media.DigitalVideoDisc;
import media.Media;

public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc(1, "Star Wars", "Sci-Fi", 87.9f, 120, "George Lucas", "John Williams");
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "Star Wars", "Sci-Fi", 50.0f, 120, "George Lucas");
        Book book = new Book(3, "Star Wars", "Sci-Fi", 30.0f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
        
        System.out.println("\nTest Equals");
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(4, "Star Wars", "Difference Category", 100.0f, 90, "Another Director");
        
        System.out.println("DVD 1 equals DVD 2? " + dvd.equals(dvd2)); 
        
        // Kiểm tra trong danh sách
        if (mediae.contains(dvd2)) {
             System.out.println("Duplicate found! Cannot add DVD 2.");
        } else {
             mediae.add(dvd2);
             System.out.println("DVD 2 added.");
        }
    }
}