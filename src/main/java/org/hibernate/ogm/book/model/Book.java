package org.hibernate.ogm.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
//@Table(name="test")
public class Book{  

@Id
@GeneratedValue(strategy=GenerationType.TABLE)
private long id;

@Column(name="book")
private String book;

@Column(name="author")
private String author;

Book() {
}

public Book(String name, String author) {
	//this.setId(id);
	this.setBook(name);
	this.setAuthor(author);
}

/**
 * @return the id
 */
public long getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(long id) {
	this.id = id;
}

/**
 * @return the book
 */
public String getBook() {
	return book;
}

/**
 * @param book the book to set
 */
public void setBook(String book) {
	this.book = book;
}

/**
 * @return the author
 */
public String getAuthor() {
	return author;
}

/**
 * @param author the author to set
 */
public void setAuthor(String author) {
	this.author = author;
}
}