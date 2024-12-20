package com.OnlineBooking.OnlineBooking.Model;

public interface Booking
{
    public String BookinID="";
    public String BookingDate = "";

    public boolean confirmBooking();
    public boolean cancelBooking();
}
