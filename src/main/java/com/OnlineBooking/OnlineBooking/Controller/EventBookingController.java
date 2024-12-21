package com.OnlineBooking.OnlineBooking.Controller;

import com.OnlineBooking.OnlineBooking.Model.EventBooking;
import com.OnlineBooking.OnlineBooking.Model.User;
import com.OnlineBooking.OnlineBooking.Service.EventBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
//@RequestMapping("/API/EventBooking")
public class EventBookingController
{
    @Autowired
    private EventBookingService eventBookingService;

   // @PostMapping("/search/events")
   /* public ResponseEntity<String> searchEvents(@RequestBody EventBooking searchRequest)
    {
        try {
            String list=
        }

    }

    */

    @PostMapping("/book/Event")
    public ResponseEntity<String> bookEvents(@RequestBody Map<String,Object> events)
    {
        String EventName = (String) events.get("EventName");
        int NumTickets=(int)events.get("NumTickets");
        try
        {
          if (eventBookingService.bookEvent(EventName,NumTickets))
          {
             return  ResponseEntity.ok("Event Booked");
          }
          else
          {
              return  ResponseEntity.status(401).body("invalid booking");
          }

        }
        catch(Exception e)
        {
            String message="error user booking"+e.getMessage() ;
            return ResponseEntity.status(500).body(message);
        }
    }

    /*

    }
    @PostMapping("/register")
    public ResponseEntity<String> Register(@RequestBody User reginfo)
    {
        try {
            if(userService.register(reginfo))
            {
                return ResponseEntity.ok("User registered successfully");
            }
            else
            {
                return ResponseEntity.status(401).body("Invalid email or password");
            }
        }
        catch (Exception e){

            String message="error registering user"+e.getMessage() ;
            return ResponseEntity.status(500).body(message);
        }
    }
    @GetMapping("/getem")
    public ArrayList getusers(){
        return User.users;
    }
     */
    @GetMapping("/getEvents")
    public ArrayList getEvents(){
        return EventBooking.events;
    }
}

