package com.example.demo.MachineCodingPractice.CouponLLD;

import java.util.Date;

public class Coupon {

    private String couponName;
    private Date dateModified;

    public Coupon(String couponName, Date dateModified) {
        this.couponName = couponName;
        this.dateModified = dateModified;
    }

    public String getCouponName() {
        return couponName;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }
}
