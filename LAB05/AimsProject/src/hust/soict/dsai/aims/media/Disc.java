package hust.soict.dsai.aims.media;

public class Disc extends Media {

    private int length;
    private String director;

    public Disc() {
        super();
    }

    public Disc(String title) {
        super();
        this.setTitle(title);
    }
    
    public Disc(String title, String category, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public Disc(String director, int length) {
        super();
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String category, String director, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.director = director;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}