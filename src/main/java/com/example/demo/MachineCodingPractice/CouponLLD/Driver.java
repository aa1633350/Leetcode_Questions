package com.example.demo.MachineCodingPractice.CouponLLD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Category comforter = new Category("Comforter Sets");
        Category bedding = new Category("Bedding");
        Category bedAndBath = new Category("Bed And Bath");
        Category soapDispensers = new Category("Soap");
        Category toy = new Category("Toy");
        Category babyAndKids = new Category("Baby & Kids");


        CategoryService categoryService = new CategoryService();
        categoryService.setCategoryList(comforter);
        categoryService.setCategoryList(bedding);
        categoryService.setCategoryList(soapDispensers);
        categoryService.setCategoryList(toy);
        categoryService.setCategoryList(bedAndBath);
        categoryService.setCategoryList(babyAndKids);

        Coupon comforterCoupon1 = new Coupon("Comforters Sale", sdf.parse("2020-01-01"));
        Coupon comforterCoupon2 = new Coupon("Cozy Comforter Coupon", sdf.parse("2021-01-01"));
        comforter.addCoupon(comforterCoupon1);
        comforter.addCoupon(comforterCoupon2);

        Coupon bedCoupon1 = new Coupon("Best Bedding Bargains", sdf.parse("2019-02-01"));
        Coupon bedCoupon2 = new Coupon("Savings on Bedding", sdf.parse("2019-01-01"));
        bedding.addCoupon(bedCoupon1);
        bedding.addCoupon(bedCoupon2);

        Coupon bedAndBathCoupon1 = new Coupon("Low price for Bed & Bath", sdf.parse("2018-01-01"));
        Coupon bedAndBathCoupon2 = new Coupon("Bed & Bath extravaganza", sdf.parse("2019-01-01"));
        Coupon bedAndBathCoupon3 = new Coupon("Big Savings for Bed & Bath", sdf.parse("2030-01-01")); // Future date
        bedAndBath.addCoupon(bedAndBathCoupon1);
        bedAndBath.addCoupon(bedAndBathCoupon2);
        bedAndBath.addCoupon(bedAndBathCoupon3);

        Map<Category, Category> categoryMap = new HashMap<>();
        // child -> parent
        categoryMap.put(comforter, bedding);
        categoryMap.put(bedding, bedAndBath);
        categoryMap.put(bedAndBath, null);
        categoryMap.put(soapDispensers, bedAndBath);
        categoryMap.put(toy, babyAndKids);
        categoryMap.put(babyAndKids, null);
        categoryService.setCategoryMap(categoryMap);
        // Test cases
        getCoupon(categoryService, comforter); // Should return "Comforters Sale"
        getCoupon(categoryService, bedding); // Should return "Savings on Bedding"
        getCoupon(categoryService, soapDispensers); // Should return "Bed & Bath extravaganza"
        getCoupon(categoryService, toy); // Should return null

        // Code to convert list to a map using streams.
//        List<Category> cateList = Arrays.asList(
//                new Category("some category"),
//                new Category("other category"),
//                new Category("some other category")
//        );
//
//        Map<String, Category> categoryMapStream = cateList.stream().collect(Collectors.toMap(Category::getCategoryName, prod-> prod));

    }

    private static void getCoupon(CategoryService categoryService, Category category) {
        Coupon foundCoupon = categoryService.getCouponOfCategory(category);
        String couponName = (foundCoupon != null) ? foundCoupon.getCouponName() : "null";
        System.out.println(category.getCategoryName() + " -> " + couponName);
    }

}
