package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable { 

    
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title);
        this.setId(nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }
    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        this.setId(nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
        this.setId(nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.setId(nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }

    public String toString() {
        return "DVD - " + this.getTitle() + 
               " - " + this.getCategory() + 
               " - " + this.getDirector() + 
               " - " + this.getLength() + 
               ": " + this.getCost() + "$";
    }

    public boolean isMatch(String title) {
        if (this.getTitle() == null) return false;
        return this.getTitle().equalsIgnoreCase(title);
    }
    
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}