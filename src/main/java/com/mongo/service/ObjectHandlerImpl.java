/**
 * 
 */
package com.mongo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.mongo.dao.DAO;
import com.mongo.dao.ogm.book.model.Book;
import com.mongo.utils.Memory;

/**
 * @author georgegaspar
 *
 */
public class ObjectHandlerImpl {
	
	private static volatile String author;
	private static volatile String name;
	
	public List<Book> getBook() throws IOException {
		
		List<Book> books = DAO.instance().getBooks();
		List<Book> book = DAO.instance().getBooks_();
		
		List<Book> booked = new ArrayList<Book>();

		for (int i = 0; i < book.size(); i++) {
		
			Book book_ = new Book(name, author);
			book_.setAuthor(books.get(i).getAuthor());
			book_.setBook(books.get(i).getBook());
			
			booked.add(book_);
		}

		Book book__ = new Book(name, author);
		Book book___ = new Book(name, author);
		
		DAO.entityManager.joinTransaction();

		book___.setAuthor(books.get(0).getAuthor());
		book___.setBook(books.get(0).getBook());

		book__.setAuthor("God One");
		book__.setBook("Holy Bible");
		DAO.entityManager.persist(book__);
		DAO.entityManager.persist(book___);
		
		DAO.entityManager.flush();
		book__ = DAO.entityManager.find( Book.class, book__.getId() );
		
		Memory.memory();

		return booked;
	}

}