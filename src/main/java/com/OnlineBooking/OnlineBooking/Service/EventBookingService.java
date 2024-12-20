package com.OnlineBooking.OnlineBooking.Service;

import com.OnlineBooking.OnlineBooking.Model.EventBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventBookingService
{


    @Autowired
    private EventBooking eventBooking;

    public boolean searchEvents(String eventName, String eventDate)
    {
      if(eventName==eventBooking.getEventName() && eventDate==eventBooking.getEventDate())
      {
          System.out.println(eventBooking.getEventDescription());
          return true;
      }
      else
      {
          System.out.println("not found");
          return false;
      }

    }

    public boolean bookEvent(String eventName,String eventDate,int num_tickets)
    {
       if (eventBooking.getEventName().equals(eventBooking.getEventName()))
       {
           eventBooking.confirmBooking();
           System.out.println("successfully booked event");
           return true;
       }
       else
       {
           System.out.println("cannot book event");
           return false;
       }
    }
}
