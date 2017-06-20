import java.io.Serializable;

public class Book implements Serializable {
	private int isbn;
	private String title, author;
	private double prise;

	public Book(int isbn, String title, String author, double prise) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.prise = prise;
	}

	public String toString() {
		return "\nTitle" + title + "\nAuthor" + author + "\nprise" + prise + "\nisbn " + isbn + "\n";

	}

}
