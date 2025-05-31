package com.example.mofe.bookservice.controller;

import com.example.mofe.bookservice.model.Book;
import com.example.mofe.bookservice.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book bookDetails) {
        return service.updateBook(id, bookDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
