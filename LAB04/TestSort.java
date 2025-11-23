import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
public class TestSort {

	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		// Tạo Book
		Book book = new Book(1, "Aladdin", "Animation", 18.99f);
		book.addAuthor("Author A");
		book.addAuthor("Author B");

		// Tạo CD
		CompactDisc cd = new CompactDisc(2, "Star Wars", "Science Fiction", 88.7f, 128, "George Lucas", "John Williams");
		cd.addTrack(new Track("The Imperial March", 4));
		cd.addTrack(new Track("Main Title", 5));

		// Tạo DVD
		DigitalVideoDisc dvd = new DigitalVideoDisc(3, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");

		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);

        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);

        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
	}
}