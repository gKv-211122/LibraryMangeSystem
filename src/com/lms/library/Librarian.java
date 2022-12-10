package com.lms.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Librarian extends Thread implements Serializable {
	
	private Scanner sc = new Scanner(System.in);
	static char ch;
	public void access()
	{
		BookDTO bookDTO = new BookDTO();
		BookDAO bookAccessObject = bookDTO.bookDAO();
		
		
		do {
			
		
		System.out.println("Press 1 to add a book...");
		System.out.println("Press 2 to Search book...");
		System.out.println("Press 3 to Search book using author...");
		System.out.println("Press 4 to Search book using title...");
		System.out.println("Press 5 to update book...");
		System.out.println("Press 6 to remove book...");
		System.out.println("Press 7 to EXIT FROM BOOK STORE...");
		
		System.out.println("Enter your choice....");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		int choice  = sc.nextInt();
		if(choice == 1)
		{
			//adding book
			
			
			System.out.println("Enter Book Name: ");
			String bookName = sc.next();
			
			System.out.println("Enter Author Name: ");
			String authorName = sc.next();
			
			System.out.println("Enter Book Generation Name: ");
			String bookGener = sc.next();
			
			System.out.println("Enter Book Edition: ");
			int bookEdition = sc.nextInt();
			
			System.out.println("Enter Book Price: ");
			int bookPrice = sc.nextInt();
			
			Book bk = new Book(bookName, authorName, bookGener, bookEdition, bookPrice);
			bookAccessObject.addBook(bk);
			
			
			ArrayList<Book> bookList = BookDTO.getBookList();
			
			for(Book b2: bookList) {
				System.out.println(b2.toString());
			}
			
			System.out.println("Book added successfully");
			
			
			
		}
		else if(choice == 2)
		{
			// searching a particular book
			
			
			System.out.println("Enter Book Name: ");
			String bookName = sc.next();
			
			System.out.println("Enter Author Name: ");
			String authorName = sc.next();
			
			System.out.println("Enter Book Generation Name: ");
			String bookGener = sc.next();
			
			System.out.println("Enter Book Edition: ");
			int bookEdition = sc.nextInt();
			
			System.out.println("Enter Book Price: ");
			int bookPrice = sc.nextInt();
			
			bookAccessObject.search(bookName, authorName, bookGener, bookEdition, bookPrice);
			
			
		}
		else if(choice == 3)
		{
			// search by author
			System.out.println("Enter Author Name: ");
			String authorName = sc.next();
			
			bookAccessObject.searchBookByAuthor(authorName);
			
		}
		else if(choice == 4)
		{
			// search by title
			
			System.out.println("Enter the book title for searching that perticular book");
			String bookName = sc.next();
			
			bookAccessObject.searchBookByTitle(bookName);
		}
		else if(choice == 5)
		{
			// update book
			System.out.println("Enter Book Name: ");
			String bookName = sc.next();
			
			System.out.println("Enter Author Name: ");
			String authorName = sc.next();
			
			System.out.println("Enter Book Generation Name: ");
			String bookGener = sc.next();
			
			System.out.println("Enter Book Edition: ");
			int bookEdition = sc.nextInt();
			
			System.out.println("Enter Book Price: ");
			int bookPrice = sc.nextInt();
			
			Book b3 = new Book(bookName, authorName, bookGener, bookEdition, bookPrice);
			bookAccessObject.updateBook(b3);
			
		}
		else if(choice == 6)
		{
			// remove book
			
		
			System.out.println("Enter the Book Title");
			String bookTitel = sc.nextLine();

			System.out.println("Enter Book Author Name");
			String bookAuthor = sc.nextLine();

			System.out.println("Enter Book Genre");
			String bookGenre = sc.nextLine();

			System.out.println("Enter the Book Edition");
			int bookEdition= sc.nextInt();

			System.out.println("Enter book price");
			int bookPrice = sc.nextInt();

			ArrayList<Book> bookList = BookDTO.getBookList();


					Book b = new Book(bookTitel, bookAuthor, bookGenre, bookEdition, bookPrice);

					System.out.println(bookAccessObject.removeBook(b));

			
		}
		else if(choice == 7) {
			
			System.out.println("You are successfully Exited From BooK Store, !!!!!");
			System.exit(0);
			
		}
		else
		{
			throw new InvalidChoiceException();
		}
		System.out.println("If you want to continue the process again then click \'y\'");
		System.out.println("If you want to Exit From The Book Srore, Enter \'n\'");
		ch = sc.next().charAt(0);
		
		
		
		
		
		if(ch == 'n') {
			
			System.out.println("You are successfully Exited From BooK Store, !!!!!");
			System.exit(0);
			
		}
		
		
		
		
		
		
		
		
	}while(ch == 'y');
	
		
	
}
	
	@Override
	public void run() {
		super.run();
		
		access();
	}
	
	
}
