public class Media {
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
    @Override
    public String toString() {
        return "DVD - " + title + 
               " - " + (category != null ? category : "N/A") + 
               ": " + cost + " $";
    }
    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
    public void printInfo() {
        System.out.println("ID: " + id + " - Title: " + title + " - Cost: " + cost + "$");
    }
}
