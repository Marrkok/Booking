package com.OnlineBooking.OnlineBooking.Service;

public interface HotelBookingService
{
    public void searchHotel(String hotelName);
    public void bookHotel(String hotelName, String bookingDate);
}
