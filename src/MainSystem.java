import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;



public class MainSystem {
	static Scanner sc = new Scanner(System.in);
	static Boolean running = true;
	static Library lib = new Library();
	
	static String fileName = null;

	public static void main(String[] args) {
		while (running) {
			System.out.println("\nPress 0 for loading library" +
		"\nPress 1 for save and quit"
					+ "\nPress 2 for list all books in the library" +
		"\nPress 3 to add book to library");

		    int answer = sc.nextInt();
		    
		  
		    
			switch (answer) {
			case 0:
				System.out.println("Enter name of the file you want to load");
				fileName = sc.next();
				
				loadScript(fileName);

				break;
				
			case 1:
				saveAndQuit();
				
				break;
			case 2:
				System.out.println(lib.toString());
				break;
			case 3:
				addBook();
				break;
			}

		}
	}

	

	private static void addBook() {
		// TODO Auto-generated method stub
		
		int isbn;
		String title, author;
		double prise;
		
		System.out.println("Enter title of the Book");
		title=sc.next();
		System.out.println("Enter author of the Book");
		author=sc.next();
		System.out.println("Enter isbn of the Book");
		isbn=sc.nextInt();
		System.out.println("Enter prise of the Book");
		prise=sc.nextDouble();
		
		Book b=new Book(isbn,title,author,prise);
		lib.addBooks(b);
		
	}

	private static void saveAndQuit() {
		System.out.println("Enter file name");
		
		fileName=sc.next()+".ser";
		//running=false;
		
		FileOutputStream fos=null;
		ObjectOutputStream out=null;
		
		try {
			fos=new FileOutputStream(fileName);
			out=new ObjectOutputStream(fos);
			
			out.writeObject(lib);
			
			fos.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private static void loadScript(String name) {
		

		FileInputStream fis = null;
		ObjectInputStream in = null;

		File file = new File(name + ".ser");

		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				lib = (Library) in.readObject();

				fis.close();
				in.close();

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("File does not exist!");
		}
	}
	
}
