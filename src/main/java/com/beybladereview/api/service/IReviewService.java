package com.beybladereview.api.service;

import com.beybladereview.api.dto.ReviewDto;
import java.util.List;

public interface IReviewService {
    ReviewDto createReview(int beybladeId, ReviewDto reviewDto);
    List<ReviewDto> getReviewsByBeybladeId(int id);
    ReviewDto getReviewById(int reviewId, int beybladeId);
    ReviewDto updateReview(int beybladeId, int reviewId, ReviewDto reviewDto);
    void deleteReview(int beybladeId, int reviewId);
}