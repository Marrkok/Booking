package com.OnlineBooking.OnlineBooking.Model;

import java.time.*;
import java.util.ArrayList;

public class HotelBooking extends Booking
{


    private int hotelId;
    private String hotelName;
    private String hotelAddress;
    private String roomType;
    private String description;
    private double price;
    private int num_rooms;



    public HotelBooking(Hotel hotel, int ID, int numrooms){
        hotelName = hotel.getHotelName();
        hotelAddress = hotel.getHotelAddress();
        roomType = hotel.getRoomType();
        price = hotel.getPrice()*numrooms;
        hotelId = hotel.getHotelID();
        setUserID(ID);
        setBookingID("H"+(1000+ID));
        setBookingDate(LocalDate.now().toString());
        setNum_rooms(numrooms);
    }
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
    public int getNum_rooms() {
        return num_rooms;
    }

    public void setNum_rooms(int num_rooms) {
        this.num_rooms = num_rooms;
    }

}

