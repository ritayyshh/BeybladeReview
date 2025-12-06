package com.beybladereview.api.repository;

import com.beybladereview.api.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReviewRepository extends JpaRepository<Review, Integer> {
    Page<Review> findByBeybladeId(int beybladeId, Pageable pageable);
}