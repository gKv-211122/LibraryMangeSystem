package com.lms.library;

import java.util.*;
import java.util.ArrayList;

public class BookDTO {
	private static ArrayList<Book> bookList = new ArrayList<Book>();
	
	public BookDAO bookDAO()
	{
		return new BookDAOImp();
	}
	
	public static ArrayList<Book> getBookList() {
		return bookList;
	}

	public static void setBookList(ArrayList<Book> bookList) {
		BookDTO.bookList = bookList;
		
	}


	public class BookDAOImp implements BookDAO
	{
		
		public void checkIsEmpty() {
			
				if(bookList.isEmpty()) {
				
					System.out.println("Enter correct name or your book is not added yet or removed");
			}
		}

		@Override
		public void addBook(Book book) {
			// TODO Auto-generated method stub
			
			bookList.add(book);
		}

		@Override
		public ArrayList<Book> searchBookByTitle(String bookTitle) {
			// TODO Auto-generated method stub
			
			checkIsEmpty();
			
			for(Book t : bookList) {
				if(t.getBookTitle().equals(bookTitle)) {
					System.out.println("Books Details are : - Author of book is : "+t.getBookAuthor() + " book Edition is " +t.getBookEdition());
					System.out.println(" book genre is : "+t.getBookGenre() + " book price is " +t.getBookPrice());
				}else {
					System.out.println("Enter correct Book Name or your book is not added yet");
				}
			}
			
			return null;
		}

		@Override
		public ArrayList<Book> searchBookByAuthor(String bookAuthor) {
			// TODO Auto-generated method stub
			
			checkIsEmpty();
			
			for(Book a : bookList) {
				if(a.getBookAuthor().equals(bookAuthor)) {
					System.out.println("Books Details are : - Book Name is : "+a.getBookTitle() + " book Edition is " +a.getBookEdition());
					System.out.println(" book genre is : "+a.getBookGenre() + " book price is " +a.getBookPrice());
					
				}else {
					System.out.println("Enter correct Author Name or your book is not added yet");
				}
			}
			
			return null;
		}

		@Override
		public Book search(String bookTitle, String bookAuthor, String bookGenre, int bookEdition, int bookPrice) {
			// TODO Auto-generated method stub   
			checkIsEmpty();
			for(Book s : bookList) {
				if(s.getBookTitle().equals(bookTitle) && s.getBookAuthor().equals(bookAuthor) && s.getBookGenre().equals(bookGenre) && s.getBookEdition()==bookEdition &&s.getBookPrice()==bookPrice ) {
					System.out.println("Books Details are : - Book Name is : "+s.getBookTitle() + " book Edition is " +s.getBookEdition() + "book Author is "+s.getBookAuthor());
					System.out.println(" book genre is : "+s.getBookGenre() + " book price is " +s.getBookPrice());
				}else {
					System.out.println(" your book is not added yet");
				}
			}
			
			return null;
		}

		@Override
		public boolean updateBook(Book book) {
			// TODO Auto-generated method stub
			System.out.println("Which of the field you want to update \n Click 1 to update Book Name \n, "
					+ " Click 2 to update Author Name \n" + " Click 3 to update Genre \n" + "Click 4 to update Edition \n "+"Click 5 to update Price \n" + "Ente 6 to Exit !!");
			checkIsEmpty();
			
			System.out.println("Enter no between 1 to 7 : ");
			Scanner sc = new Scanner(System.in);
			
			int update = sc.nextInt();
			switch(update) {
				
				case 1:
					Book b1 = new Book();
				
					System.out.println("Enter to update bookName :");
					String bt = sc.next();
				
					bookList.get(0).setBookTitle(bt);
					
					break;

			
				case 2: 
					Book b2 = new Book();
				
					System.out.println("Enter to update bookAuthor :");
					String ba = sc.next();
				
					bookList.get(0).setBookAuthor(ba);
					
					break;
			
				case 3:
					Book b3 = new Book();
				
					System.out.println("Enter to update bookGeneration :");
					String bg = sc.next();
				
					bookList.get(0).setBookGenre(bg);
					
					break;
			
				case 4:
					Book b4 = new Book();
				
					System.out.println("Enter to update bookEdition :");
					int be = sc.nextInt();
				
				    bookList.get(0).setBookEdition(be);
				    
				    break;
			
				case 5:
					Book b5 = new Book();
				
					System.out.println("Enter to update bookPrice :");
					int bp = sc.nextInt();
				
					bookList.get(0).setBookPrice(bp);
					
					break;
			
				case 6:
				
					System.out.println("You are successfully Exited From BooK Store, !!!!!");
					System.exit(0);
					
					break;
				
			
				default:
					System.out.println("Can't modify ! please enter no between 1 to 7");
				
			}

			
			
			
			return false;
		}

		@Override
		public boolean removeBook(Book book) {
			// TODO Auto-generated method stub
			
			checkIsEmpty();
			
			int index = searchBook(book);

			if (index == -1) {
				return false;
			}
			bookList.remove(index);
			return true;
		}

		@Override
		public int searchBook(Book book) {
			// TODO Auto-generated method stub
			int i =0;
//		
			for (Book boo: bookList) {
				if (boo.getBookTitle().equals(book.getBookTitle()) &&
						boo.getBookAuthor().equals(book.getBookAuthor()) &&
						boo.getBookGenre().equals(book.getBookGenre()) &&
						boo.getBookEdition() == book.getBookEdition() &&
						boo.getBookPrice() == book.getBookPrice()) {
						return i;

				}
				i++;
			}
			return -1;
		}
				

	}
}
