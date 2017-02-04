package com.mongo.dao.ogm.em;

import org.hibernate.ogm.book.model.Book;

public interface BookRepositoryBeanLocal {
	public Book insert(Book book);
	public Book findByAuthor(String author);
}