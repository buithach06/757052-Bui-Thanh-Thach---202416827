package hust.soict.dsai.aims.media;
public abstract class Media {
    private String title;
	private String category;
	private float cost;
	private int id;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public Media(String title) {
		super();
		this.title = title;
	}
	
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public Media(String title, float cost) {
		super();
		this.title = title;
		this.cost = cost;
	}
    public Media(int id, String title, float cost) {
        super();
        this.id = id;
        this.title = title;
        this.cost = cost;
	}

    public Media(int id, String title, String category, float cost){
		super();
		this.id = id;
		this.title =title;
		this.category = category;
		this.cost = cost;
	}
	
    @Override
    public String toString() {
        return "ID: " + id + " - Title: " + title + " - Cost: " + cost + "$";
    }
	@Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Media)) {
            return false;
        }
        Media otherMedia = (Media) o;
        if (this.title != null) {
            return this.title.equals(otherMedia.title);
        }
        return otherMedia.title == null;
    }
}
