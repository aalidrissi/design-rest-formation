package com.cih.design_rest_formation_dryrun.service.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cih.design_rest_formation_api.models.Book;
import com.cih.design_rest_formation_dryrun.service.entity.BookEntity;
import com.cih.design_rest_formation_dryrun.service.repo.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Long createBook(BookEntity bookEntity) {
        BookEntity savedBook = bookRepository.save(bookEntity);
        return savedBook.getId();
    }
    
    public List<Book> getAllBooks(){
    	List <BookEntity> books= bookRepository.findAll();
    	return books.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Book getBookByid(Long id) {
    	Optional<BookEntity> bookEntity= bookRepository.findById(id);
    	return bookEntity.isPresent() ? convertToDTO(bookEntity.get()) : null;
    }
    
    private Book convertToDTO(BookEntity bookEntity) {
        // Convert the entity to a DTO
        Book book = new Book();
        book.setBookAuthor(bookEntity.getBookAuthor());
        book.setName(bookEntity.getName());
        book.setPrice(bookEntity.getPrice());
        return book;
        
    }
}
