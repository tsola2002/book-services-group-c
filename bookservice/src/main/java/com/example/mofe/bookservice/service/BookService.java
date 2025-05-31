package com.example.mofe.bookservice.service;

import com.example.mofe.bookservice.model.Book;
import com.example.mofe.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Optional<Book> findById(Integer id) {
        return repository.findById(id);
    }

    public Book updateBook(Integer id, Book bookDetails) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        book.setName(bookDetails.getName());
        book.setWeight(bookDetails.getWeight());

        return repository.save(book);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
