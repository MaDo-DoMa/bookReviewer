package org.example.bookreviewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.example.bookreviewer.model.Review;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByBookId(long bookId);
    Optional<Review> findByBookIdAndUserId(long bookId, long userId);

    List<Review> getReviewsByBookId(Long bookId);
}
