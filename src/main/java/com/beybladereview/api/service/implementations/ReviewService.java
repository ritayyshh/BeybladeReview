package com.beybladereview.api.service.implementations;

import com.beybladereview.api.dto.PageResponse;
import com.beybladereview.api.dto.ReviewDto;
import com.beybladereview.api.exceptions.BeybladeNotFoundException;
import com.beybladereview.api.exceptions.ReviewNotFoundException;
import com.beybladereview.api.models.Beyblade;
import com.beybladereview.api.models.Review;
import com.beybladereview.api.repository.IBeybladeRepository;
import com.beybladereview.api.repository.IReviewRepository;
import com.beybladereview.api.service.IReviewService;
import com.beybladereview.api.utils.PaginationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements IReviewService {
    private final IReviewRepository reviewRepository;
    private final IBeybladeRepository beybladeRepository;

    public ReviewService(IReviewRepository reviewRepository, IBeybladeRepository beybladeRepository) {
        this.reviewRepository = reviewRepository;
        this.beybladeRepository = beybladeRepository;
    }

    @Override
    public ReviewDto createReview(int beybladeId, ReviewDto reviewDto) {
        Review review = mapToEntity(reviewDto);

        Beyblade beyblade = beybladeRepository.findById(beybladeId).orElseThrow(() -> new BeybladeNotFoundException("Beyblade with associated review not found!"));

        review.setBeyblade(beyblade);

        Review newReview = reviewRepository.save(review);

        return mapToDto(newReview);
    }

    @Override
    public PageResponse<ReviewDto> getReviewsByBeybladeId(int beybladeId, int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Review> page = reviewRepository.findByBeybladeId(beybladeId, pageable);

        return PaginationUtils.toPageResponse(page, this::mapToDto);
    }

    @Override
    public ReviewDto getReviewById(int reviewId, int beybladeId) {
        Beyblade beyblade = beybladeRepository.findById(beybladeId).orElseThrow(() -> new BeybladeNotFoundException("Beyblade with associated review not found!"));

        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review with associated Beyblade not found!"));

        if(review.getBeyblade().getId() != beyblade.getId()) {
            throw new ReviewNotFoundException("This review doesn't belong to a Beyblade!");
        }

        return mapToDto(review);
    }

    @Override
    public ReviewDto updateReview(int beybladeId, int reviewId, ReviewDto reviewDto) {
        Beyblade beyblade = beybladeRepository.findById(beybladeId).orElseThrow(() -> new BeybladeNotFoundException("Beyblade with associated review not found!"));

        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review with associated Beyblade not found!"));

        if(review.getBeyblade().getId() != beyblade.getId()) {
            throw new ReviewNotFoundException("This review doesn't belong to a Beyblade!");
        }

        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setRating(reviewDto.getRating());

        Review updatedReview = reviewRepository.save(review);

        return mapToDto(updatedReview);
    }

    @Override
    public void deleteReview(int beybladeId, int reviewId) {
        Beyblade beyblade = beybladeRepository.findById(beybladeId).orElseThrow(() -> new BeybladeNotFoundException("Beyblade with associated review not found!"));

        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review with associated Beyblade not found!"));

        if(review.getBeyblade().getId() != beyblade.getId()) {
            throw new ReviewNotFoundException("This review doesn't belong to a Beyblade!");
        }

        reviewRepository.delete(review);
    }

    private ReviewDto mapToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setTitle(review.getTitle());
        reviewDto.setContent(review.getContent());
        reviewDto.setRating(review.getRating());
        reviewDto.setReviewer(review.getReviewer());
        return reviewDto;
    }

    private Review mapToEntity(ReviewDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setRating(reviewDto.getRating());
        review.setReviewer(reviewDto.getReviewer());
        return review;
    }
}
