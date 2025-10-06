package org.example.bookreviewer.controller;

import org.example.bookreviewer.model.Book;
import org.example.bookreviewer.service.BookService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book savedBook = bookService.save(book);

        //  return 201
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
}
