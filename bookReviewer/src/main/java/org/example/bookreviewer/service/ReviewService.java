package org.example.bookreviewer.service;

import lombok.RequiredArgsConstructor;
import org.example.bookreviewer.exception.ValidationException;
import org.example.bookreviewer.model.Book;
import org.example.bookreviewer.model.Review;
import org.example.bookreviewer.model.User;
import org.example.bookreviewer.repository.BookRepository;
import org.example.bookreviewer.repository.ReviewRepository;
import org.example.bookreviewer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    public Review createReview(Long bookId, Long userId, Review review) {

        Integer rating = review.getRating();
        if (rating == null || rating < 1 || rating > 5) {
            throw new ValidationException("Rating must be between 1 and 5");
        }


        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ValidationException("Book not found"));


        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ValidationException("User not found"));


        review.setBook(book);
        review.setUser(user);

        return reviewRepository.save(review);
    }
}
