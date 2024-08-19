package com.example.demo.MachineCodingPractice.HotelRatingApp;

public enum OrderingCriteria {
    ASCENDING("Ascending"),
    DESCENDING("Descending"),
    RECENT("Recent"),
    DEFAULT("Default"); // Default ordering is higher rating (if ratings are the same - by recent)

    private final String order;
    OrderingCriteria(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }
}
