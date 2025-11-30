package com.beybladereview.api.repository;

import com.beybladereview.api.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByBeybladeId(int beybladeId);
}