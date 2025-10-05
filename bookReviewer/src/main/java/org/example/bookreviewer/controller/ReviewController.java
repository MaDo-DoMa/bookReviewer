package org.example.bookreviewer.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookreviewer.model.Review;
import org.example.bookreviewer.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/book/{bookId}")
    public List<Review> getByBook(@PathVariable Long bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }

    @PostMapping("/book/{bookId}/user/{userId}")
    public Review create(@PathVariable Long bookId,
                         @PathVariable Long userId,
                         @RequestBody Review review) {
        return reviewService.createReview(bookId, userId, review);
    }
}
