package com.example.demo.MachineCodingPractice.CouponLLD;

import java.util.ArrayList;
import java.util.List;

public class Category {

    String categoryName;
    List<Coupon> coupons = new ArrayList<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }



    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



    public Category(String categoryName, List<Coupon> coupons) {
        this.categoryName = categoryName;
        this.coupons = coupons;
    }

    public void addCoupon(Coupon coupon) {
        this.coupons.add(coupon);
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }


}
