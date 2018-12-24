/**
 * 
 */
package com.learning.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.spring5webapp.repositories.BookRepository;

/**
 * @author shivaak on 23-Dec-2018
 *
 */

@Controller
public class BookController {

	BookRepository bookRepo;
	
	public BookController(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}


	@RequestMapping(name="/books", method=RequestMethod.GET)
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "books";
	}
}
