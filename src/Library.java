import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Serializable {

	List<Book> collection;

	public Library() {
		List<Book> collection = new ArrayList<Book>();
	}

	public void addBooks(Book book) {
		collection.add(book);

	}

	public String toString() {
		String total = "\n";
		/*
		 * for(int i=0;i<collection.size();i++){ Book b=collection.get(i);
		 * total=total+b.toString(); }
		 */

		Iterator<Book> i = collection.iterator();
		while (i.hasNext()) {
			Book b = i.next();
			total = total + b.toString();
		}
		return total;

	}

}
