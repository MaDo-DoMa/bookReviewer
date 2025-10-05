package org.example.bookreviewer.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookreviewer.model.Shelf;
import org.example.bookreviewer.service.ShelfService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shelves")
@RequiredArgsConstructor
public class ShelfController {
    private final ShelfService shelfService;

    @GetMapping
    public List<Shelf> getAll() {
        return shelfService.findAll();
    }

    @GetMapping("/{id}")
    public Shelf getOne(@PathVariable Long id) {
        return shelfService.getById(id);
    }

    @PostMapping
    public Shelf create(@RequestBody Shelf shelf) {
        return shelfService.save(shelf);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        shelfService.delete(id);
    }
}
