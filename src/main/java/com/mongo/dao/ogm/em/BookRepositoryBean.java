package com.mongo.dao.ogm.em;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
 
import org.bson.types.ObjectId;
import org.hibernate.ogm.OgmSession;

import com.mongo.dao.ogm.book.model.Book;
 
 
@Stateless
@LocalBean
public class BookRepositoryBean implements BookRepositoryBeanLocal {
	
	@Inject
	EntityManager entityManager;
 
	@Override
	public Book insert(Book Book) {
		entityManager.persist(Book);
		
		return Book;
	}
 
	@Override
	public Book findByAuthor(String author) {
		OgmSession ogmSession = entityManager.unwrap(OgmSession.class);
		
		Book Book = (Book) ogmSession
				.createQuery("FROM Book WHERE author = :author")
				.setParameter("author", author).uniqueResult();
		
		return Book;
	}
 
}