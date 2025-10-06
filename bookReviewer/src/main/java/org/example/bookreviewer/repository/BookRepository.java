package org.example.bookreviewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.bookreviewer.model.Book;



public interface BookRepository extends JpaRepository<Book, Long> {
}
