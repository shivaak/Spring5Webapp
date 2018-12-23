/**
 * 
 */
package com.learning.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.spring5webapp.model.Author;

/**
 * @author shivaak on 23-Dec-2018
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
