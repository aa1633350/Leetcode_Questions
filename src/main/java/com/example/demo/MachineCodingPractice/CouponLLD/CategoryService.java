package com.example.demo.MachineCodingPractice.CouponLLD;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryService {

    List<Category> categoryList = new ArrayList<>();
    Map<Category, Category> categoryMap = new HashMap<>();
    private Date currentDate = new Date();

    public void setCategoryMap(Map<Category, Category> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public CategoryService() {

    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Category category) {
        categoryList.add(category);
    }



    public Coupon getCouponOfCategory(Category category) {
        return findCoupon(category);
    }

    private Coupon findCoupon(Category category) {

        if(category != null && !category.getCoupons().isEmpty()) {
            return mostRecentCoupon(category);
        } else if(category != null && categoryMap.containsKey(category)) {
            return findCoupon(categoryMap.get(category));
        }
        return null;
    }

    private Coupon mostRecentCoupon(Category category) {
        List<Coupon> validCoupons = new ArrayList<>();
        for (Coupon coupon : category.getCoupons()) {
            if (coupon.getDateModified().before(currentDate)) {
                validCoupons.add(coupon);
            }
        }
        Coupon mostRecentCoupon = null;
        for (Coupon coupon : validCoupons) { // 2020-01-01, 2021-01-01
            if (mostRecentCoupon == null || coupon.getDateModified().after(mostRecentCoupon.getDateModified())) {
                mostRecentCoupon = coupon;
            }
        }
        return mostRecentCoupon;

    }
}
