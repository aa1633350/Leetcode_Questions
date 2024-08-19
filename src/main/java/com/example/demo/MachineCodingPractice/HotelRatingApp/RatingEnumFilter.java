package com.example.demo.MachineCodingPractice.HotelRatingApp;

public enum RatingEnumFilter {
    LOWER_RANGE(1, 2),   // 1-2
    MEDIUM_RANGE(3, 4),  // 3-4
    HIGH_RANGE(5, 5);     // 5

    private final int minRating;
    private final int maxRating;

    RatingEnumFilter(int minRating, int maxRating) {
        this.minRating = minRating;
        this.maxRating = maxRating;
    }

    public int getMinRating() {
        return minRating;
    }

    public int getMaxRating() {
        return maxRating;
    }
}
