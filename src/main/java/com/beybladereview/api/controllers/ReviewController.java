package com.beybladereview.api.controllers;

import com.beybladereview.api.dto.ReviewDto;
import com.beybladereview.api.service.IReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {
    private final IReviewService reviewService;

    public ReviewController(IReviewService reviewService) { this.reviewService = reviewService; }

    @PostMapping("/beyblade/review/create")
    public ResponseEntity<ReviewDto> createReview(@RequestParam int beybladeId, @RequestBody ReviewDto reviewDto) {
        return new ResponseEntity<>(reviewService.createReview(beybladeId, reviewDto), HttpStatus.CREATED);
    }

    @GetMapping("/beyblade/reviews")
    public List<ReviewDto> getReviewsByBeybladeId(@RequestParam int beybladeId) {
        return reviewService.getReviewsByBeybladeId(beybladeId);
    }

    @GetMapping("/beyblade/review")
    public ResponseEntity<ReviewDto> getReviewById(@RequestParam int beybladeId, @RequestParam int id) {
        ReviewDto reviewDto = reviewService.getReviewById(beybladeId, id);
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @PutMapping("/beyblade/review/update")
    public ResponseEntity<ReviewDto> updateReview(@RequestParam int beybladeId, @RequestParam int id, @RequestBody ReviewDto reviewDto) {
        ReviewDto updatedReview = reviewService.updateReview(beybladeId, id, reviewDto);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    @DeleteMapping("/beyblade/review/delete")
    public ResponseEntity<String> deleteReview(@RequestParam int beybladeId, @RequestParam int id) {
        return new ResponseEntity<>("Review deleted successfully!", HttpStatus.OK);
    }
}