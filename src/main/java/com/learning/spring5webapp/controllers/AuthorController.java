/**
 * 
 */
package com.learning.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.spring5webapp.repositories.AuthorRepository;

/**
 * @author shivaak on 24-Dec-2018
 *
 */
@Controller
public class AuthorController {

	private AuthorRepository authorRepo;
	
	public AuthorController(AuthorRepository authorRepo) {
		super();
		this.authorRepo = authorRepo;
	}



	@RequestMapping(value="/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors";
	}
}
