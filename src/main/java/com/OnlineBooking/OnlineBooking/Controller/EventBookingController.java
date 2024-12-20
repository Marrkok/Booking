package com.OnlineBooking.OnlineBooking.Controller;

import com.OnlineBooking.OnlineBooking.Service.EventBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/API/EventBooking")
public class EventBookingController
{
    @Autowired
    private EventBookingService eventBookingService;

    @PostMapping("/search-events")
    public boolean searchEvents(String EventName,String EventDate)
    {
        return eventBookingService.searchEvents(EventName,EventDate);
    }

    @PostMapping("/bookEvent")
    public boolean bookEvents(String EventName,String EventDate,int NumTickets)
    {
        return eventBookingService.bookEvent(EventName,EventDate,NumTickets);
    }

}
