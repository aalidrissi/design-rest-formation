package com.cih.design_rest_formation_dryrun.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cih.design_rest_formation_api.api.BooksApi;
import com.cih.design_rest_formation_api.models.Book;
import com.cih.design_rest_formation_api.models.InlineResponse201;
import com.cih.design_rest_formation_dryrun.service.entity.BookEntity;
import com.cih.design_rest_formation_dryrun.service.service.BookService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BookController implements BooksApi{
	
	@Autowired
	private final BookService bookServiceImpl;
	
	@Override
	public ResponseEntity<Book> booksIdbookGet(String arg0) {
		Book book = bookServiceImpl.getBookByid(Long.valueOf(arg0));	
		return book != null ? new ResponseEntity<>(book, HttpStatus.OK) : 
			new ResponseEntity<>(book, HttpStatus.NOT_FOUND) ;
	}

	@Override
	public ResponseEntity<List<Book>> getAllBooksInLibrary() {
		return new ResponseEntity<>(bookServiceImpl.getAllBooks(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<InlineResponse201> createBook(@Valid Book arg0) {
		BookEntity b = new BookEntity();
		b.setName(arg0.getName());
		b.setBookAuthor(arg0.getBookAuthor());
		Long id = bookServiceImpl.createBook(b);
		InlineResponse201 inline = new InlineResponse201();
		inline.setId(id.intValue());
		return ResponseEntity.status(201).body(inline);
	}

	


}
