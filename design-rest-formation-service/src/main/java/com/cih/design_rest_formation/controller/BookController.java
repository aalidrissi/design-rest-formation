package com.cih.design_rest_formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cih.design_rest_formation_api.api.BooksApi;
import com.cih.design_rest_formation_api.models.Book;

@RestController
public class BookController implements BooksApi{

	@Override
	public ResponseEntity<List<Book>> getAllBooksInLibrary() {
		
		List <Book> listBook = new ArrayList<Book>();
		listBook.add(new Book());
		return new ResponseEntity<>(listBook, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Void> idBookCreation(@Valid Book arg0) {
		System.out.println(arg0.getName());
		return null;
	}

	@Override
	public ResponseEntity<Book> booksIdbookGet(String arg0) {
		Book book = new Book();
		book.setName("john snow");
		book.setBookAuthor("kelly rowling");
		book.setPrice(150);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}


}
