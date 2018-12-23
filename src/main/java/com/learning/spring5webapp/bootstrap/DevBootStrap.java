/**
 * 
 */
package com.learning.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.learning.spring5webapp.model.Author;
import com.learning.spring5webapp.model.Book;
import com.learning.spring5webapp.repositories.AuthorRepository;
import com.learning.spring5webapp.repositories.BookRepository;

/**
 * @author shivaak on 23-Dec-2018
 *
 */

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	AuthorRepository authorRepo;
	BookRepository bookRepo;
	
	/**
	 * @param authorRepo
	 * @param bookRepo
	 */
	public DevBootStrap(AuthorRepository authorRepo, BookRepository bookRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
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
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "Book on Spring Framework");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
       
        authorRepo.save(rod);
        bookRepo.save(noEJB);

	}
	
	

}
