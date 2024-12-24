package com.OnlineBooking.OnlineBooking.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking
{   @JsonProperty("bookingID")
    public String BookingID;
    @JsonProperty("bookingDate")
    public String BookingDate ;
    @JsonProperty("userID")
    public int UserID;

    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String BookingID) {
        this.BookingID = BookingID;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String BookingDate) {
        this.BookingDate = BookingDate;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
}
