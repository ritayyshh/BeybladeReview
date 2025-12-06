package com.beybladereview.api.service;

import com.beybladereview.api.dto.PageResponse;
import com.beybladereview.api.dto.ReviewDto;

public interface IReviewService {
    ReviewDto createReview(int beybladeId, ReviewDto reviewDto);
    public PageResponse<ReviewDto> getReviewsByBeybladeId(int id, int pageNo, int pageSize);
    ReviewDto getReviewById(int reviewId, int beybladeId);
    ReviewDto updateReview(int beybladeId, int reviewId, ReviewDto reviewDto);
    void deleteReview(int beybladeId, int reviewId);
}