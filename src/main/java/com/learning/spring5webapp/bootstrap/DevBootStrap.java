/**
 * 
 */
package com.learning.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.learning.spring5webapp.model.Author;
import com.learning.spring5webapp.model.Book;
import com.learning.spring5webapp.model.Publisher;
import com.learning.spring5webapp.repositories.AuthorRepository;
import com.learning.spring5webapp.repositories.BookRepository;
import com.learning.spring5webapp.repositories.PublisherRepository;

/**
 * @author shivaak on 23-Dec-2018
 *
 */

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	AuthorRepository authorRepo;
	BookRepository bookRepo;
	PublisherRepository publisherRepo;
	
	/**
	 * @param authorRepo
	 * @param bookRepo
	 */
	public DevBootStrap(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		populateData();
	}
	
	private void populateData() {
		//Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "A book about domain driven model");
        Publisher p1 = new Publisher("Publisher 1", "Salem, Tamilnadu");
        publisherRepo.save(p1);
        ddd.setPublisher(p1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "Book on Spring Framework");
        Publisher p2 = new Publisher("Publisher 2", "Bangalore, Karnataka");
        publisherRepo.save(p2);
        noEJB.setPublisher(p2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
       
        authorRepo.save(rod);
        bookRepo.save(noEJB);

	}
	
	

}
