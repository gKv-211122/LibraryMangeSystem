package com.lms.library;

import java.util.ArrayList;

public interface BookDAO {
	
	
	void addBook(Book book);
	
	ArrayList<Book> searchBookByTitle(String bookTitle);
	ArrayList<Book> searchBookByAuthor(String bookAuthor);
	
	Book search(String bookTitle,String bookAuthor,String bookGenre,int bookEdition,int bookPrice);
	boolean updateBook(Book book);
	boolean removeBook(Book book);
	int searchBook(Book book);
	
}
