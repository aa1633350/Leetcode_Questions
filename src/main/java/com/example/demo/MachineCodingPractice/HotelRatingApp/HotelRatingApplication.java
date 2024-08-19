package com.example.demo.MachineCodingPractice.HotelRatingApp;

public class HotelRatingApplication {

    public static void main(String[] args) throws RatingLessThanZeroException{

       HotelManager hotelManager = new HotelManager();
       User user1 = hotelManager.regsiterUser("Aditya");
       Hotel lemonTree = hotelManager.addHotel("Lemon Tree", true);
       hotelManager.addRatingToHotel("Lemon Tree",user1,4,"Good exp");
       hotelManager.getHotelRatings(lemonTree.getHotelName(),RatingEnumFilter.HIGH_RANGE,OrderingCriteria.DESCENDING);
       User user2 = hotelManager.regsiterUser("Saurabh");
       Hotel radisson = hotelManager.addHotel("Radisson", true);
       hotelManager.addRatingToHotel(radisson.getHotelName(), user2,5,"");
       hotelManager.describeHotel(radisson.getHotelName());
    }
}
