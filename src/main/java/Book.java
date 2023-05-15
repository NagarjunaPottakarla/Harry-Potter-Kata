
public class Book {

	private String title;
	private int price;

	public Book(String title) {
		this.title = title;
		this.price = 8;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Book))
			return false;

		Book other = (Book) o;
		return this.title == other.getTitle();
	}
	public int hashCode() {
		return title.hashCode();
	}
}
