package com.OnlineBooking.OnlineBooking.Controller;

import com.OnlineBooking.OnlineBooking.Model.Event;
import com.OnlineBooking.OnlineBooking.Model.Hotel;
import com.OnlineBooking.OnlineBooking.Service.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class HotelBookingController
{
    @Autowired
    private HotelBookingService hotelBookingService;
////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/addHotel")
    public ResponseEntity<String> Register(@RequestBody Hotel newHotel)
    {
        try {
            if(hotelBookingService.AddHotel(newHotel))
            {
                return ResponseEntity.ok("hotel Added successfully");
            }
            else
            {
                return ResponseEntity.status(401).body("hotel already exists");
            }
        }
        catch (Exception e){

            String message="error adding new hotel "+e.getMessage() ;
            return ResponseEntity.status(500).body(message);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/book/Hotel")
    public ResponseEntity<String> bookHotels(@RequestBody Map<String,Object> hotels)
    {
        String HotelName = (String) hotels.get("HotelName");
        int num_rooms=(int)hotels.get("NumRooms");
        try
        {
            if (hotelBookingService.BookHotel(HotelName,num_rooms).startsWith("confirm"))
            {
                return  ResponseEntity.ok("hotel rooms Booked");
            }
            else if (hotelBookingService.BookHotel(HotelName,num_rooms).startsWith("hotel not"))
            {
                return  ResponseEntity.status(404).body("invalid booking, "+hotelBookingService.BookHotel(HotelName,num_rooms));
            }
            else if (hotelBookingService.BookHotel(HotelName,num_rooms).startsWith("available rooms not enough")){
                return  ResponseEntity.status(400).body("invalid booking, "+hotelBookingService.BookHotel(HotelName,num_rooms));
            }
            else return  ResponseEntity.status(500).body("Internal Server Error");

        }
        catch(Exception e)
        {
            String message="error user booking"+e.getMessage() ;
            return ResponseEntity.status(500).body(message);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/search/hotels")
    public ResponseEntity<String> searchHotels(@RequestBody String hotelName) {

        try {
            hotelBookingService.searchhotels(hotelName);
            return ResponseEntity.ok("hotel found");

        } catch (Exception e) {
            String message = "hotel Not Found" + e.getMessage();
            return ResponseEntity.status(500).body(message);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/hotels/getem")
    public ArrayList getHotels(){return Hotel.hotels;
    }
    @GetMapping("/hotelbookings/getem")
    public ArrayList getHotelbookings(){return hotelBookingService.getHotelBookings();}
}
