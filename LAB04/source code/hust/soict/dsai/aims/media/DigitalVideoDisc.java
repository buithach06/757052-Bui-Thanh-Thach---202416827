package media;
public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director){
        super(id, title, category, cost, length, director);
    }
    @Override
    public void play() {
        System.out.println("Playing dvd: " + this.getTitle());
        System.out.println("Dvd length: " + this.getLength());
    }
    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getCost() + "$";
    }
}
