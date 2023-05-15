
public class BooksSetDiscount {

	private int differentCopies;
	private int discount;
	
	
	
	public BooksSetDiscount(int differentCopies, int discount) {
		super();
		this.differentCopies = differentCopies;
		this.discount = discount;
	}
	public int getDifferentCopies() {
		return differentCopies;
	}
	public void setDifferentCopies(int differentCopies) {
		this.differentCopies = differentCopies;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
