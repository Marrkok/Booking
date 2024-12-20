package com.OnlineBooking.OnlineBooking.Model;


public class HotelBooking implements Booking
{
    @Override
    public boolean confirmBooking() {
        return true;
    }

    @Override
    public boolean cancelBooking() {
        return false;
    }

    private int hotelId;
    private String hotelName;
    private String hotelAddress;
    private String roomType;
    private String description;
    private double price;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}

