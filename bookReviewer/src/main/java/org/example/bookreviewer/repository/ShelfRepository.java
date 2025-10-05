package org.example.bookreviewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.bookreviewer.model.Shelf;
public interface ShelfRepository extends JpaRepository<Shelf,Long> {
}
