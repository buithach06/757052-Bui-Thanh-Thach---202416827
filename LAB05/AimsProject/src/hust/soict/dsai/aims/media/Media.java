package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
       
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
            new MediaComparatorByTitleCost();
            
        public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
            new MediaComparatorByCostTitle();
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || !(o instanceof Media)) return false;
        Media media = (Media) o;
        return Objects.equals(this.getTitle(), media.getTitle());
    }
    
    public void tryPlay() {
        if (this instanceof Playable) {
            ((Playable) this).play();
        } else {
            System.out.println("This media type cannot be played.");
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}