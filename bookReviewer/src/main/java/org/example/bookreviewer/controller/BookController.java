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

    @PostMapping
    public Book addBlock(@RequestBody Book book){
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
