package com.OnlineBooking.OnlineBooking.Service;

import com.OnlineBooking.OnlineBooking.Model.Event;
import com.OnlineBooking.OnlineBooking.Model.Hotel;
import com.OnlineBooking.OnlineBooking.Model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class HotelBookingService
{
    @Autowired
    private Hotel hotel;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean AddHotel(Hotel newHotel)
    {
        Hotel existing=Hotel.FindByHotelName(newHotel.getHotelName());
        if(existing!=null)
        {
            System.out.println("the Hotel already exist");
            return false;
        }
        else{

            Hotel newh = new Hotel(newHotel.getHotelID(),newHotel.getHotelName(),newHotel.getHotelAddress(),newHotel.getRoomType(),newHotel.getTotalRooms(),newHotel.getAvailableRooms(),newHotel.getPrice());
            Hotel.hotels.add(newh);
            System.out.println("successfully added hotel");
            return true;}
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public String BookHotel(String HotelName,int num_rooms)
    {
        hotel=Hotel.FindByHotelName(HotelName);
        if(hotel==null)
        {
            System.out.println("Hotel not found");
            return "Hotel not found,can't book" ;
        }
        else
        {   if(hotel.getAvailableRooms()<num_rooms){
            System.out.println("available Rooms not enough");
            return "available Rooms not enough" ;
        }
        else{
            hotel.setAvailableRooms(hotel.getAvailableRooms()-num_rooms);
            System.out.println("confirm booking");
            return "confirm booking" ;}
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public String searchhotels(String hotelName)
    {
        if (hotelName == null || hotelName.trim().isEmpty()) {
            return "Event name cannot be empty";
        }

        Hotel foundHotel = Hotel.FindByHotelName(hotelName);
        if (foundHotel == null) {
            System.out.println("Event not found: " + hotelName);
            return "Event not found";
        }

        System.out.println("hotel Details:");
        System.out.println("Name: " + foundHotel.getHotelName());
        System.out.println("room: " + foundHotel.getRoomType());
        System.out.println("Location: " + foundHotel.getHotelAddress());
        System.out.println("Available Rooms: " + foundHotel.getAvailableRooms());
        System.out.println("Price: " + foundHotel.getPrice());
        System.out.println("------------------------");


        return String.format("{\"status\": \"success\", \"Hotel\": {\"name\": \"%s\", \"Room\": \"%s\", \"location\": \"%s\", \"Available Rooms\": \"%s\",  \"price\": %.2f}}",
                foundHotel.getHotelName(),
                foundHotel.getRoomType(),
                foundHotel.getHotelAddress(),
                foundHotel.getAvailableRooms(),
                foundHotel.getPrice() );
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Component
    public class HotelInitializer {

        @PostConstruct
        public void init() {
            if (Hotel.hotels.isEmpty())
            {
                hotel.addHotel(new Hotel(102,"Four Seasons Madrid","Madrid","double",1000,500,150));
                hotel.addHotel(new Hotel(103,"Hotel Bel-Air","Los Angeles","Single",500,500,300));
            }
        }
    }
}
