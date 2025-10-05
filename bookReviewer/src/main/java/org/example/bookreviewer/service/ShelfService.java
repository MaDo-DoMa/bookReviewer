package org.example.bookreviewer.service;

import lombok.RequiredArgsConstructor;
import org.example.bookreviewer.model.Shelf;
import org.example.bookreviewer.repository.ShelfRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShelfService {
    private final ShelfRepository shelfRepository;

    public List<Shelf> findAll() {
        return shelfRepository.findAll();
    }

    public Shelf getById(Long id) {
        return shelfRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shelf not found"));
    }

    public Shelf save(Shelf shelf) {
        return shelfRepository.save(shelf);
    }

    public void delete(Long id) {
        shelfRepository.deleteById(id);
    }
}
