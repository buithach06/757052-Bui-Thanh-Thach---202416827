import java.util.ArrayList;
import java.util.List;

class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    public Book (int id, String title, Float cost) {
        super(id, title, cost);
    }
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }
    @Override
    public void printInfo() {
        System.out.print("BOOK: ");
        super.printInfo();
        System.out.println("Authors: " + authors);
    }
}
