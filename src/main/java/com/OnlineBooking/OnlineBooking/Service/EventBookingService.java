package com.OnlineBooking.OnlineBooking.Service;

import com.OnlineBooking.OnlineBooking.Model.EventBooking;
import com.OnlineBooking.OnlineBooking.Model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EventBookingService
{
    @Autowired
    private EventBooking eventBooking;

    public boolean AddEvent(EventBooking EVU)
    {
        EventBooking existing=EventBooking.FindByEventName(EVU.getEventName());
        if(existing!=null)
        {
            System.out.println("the Event Already Exists");
            return false;
        }
        else{

            EventBooking newEvent= new EventBooking(EVU.getEventID(),EVU.getEventName(),EVU.getEventLocation(),EVU.getEventDescription(),EVU.getEventDate(),EVU.getTotalTickets(),EVU.getTotalTickets());
            EventBooking.events.add(newEvent);
            System.out.println("Successfully Added Event");
            return true;}
    }


    public boolean searchEvents(String eventName)
    {
      eventBooking =EventBooking.FindByEventName(eventName);
       if(eventBooking.getEventName()==eventName)
       {
           System.out.println(eventBooking.getEventDate()+" "+eventBooking.getEventDescription()+" "+eventBooking.getEventLocation());
           System.out.println(eventBooking.getAvailableTickets()+" "+eventBooking.getPrice());
           return true ;
       }
       else
       {
           System.out.println("event not found");
           return false ;
       }
    }

    public String bookEvent(String eventName,int num_tickets)
    {
        eventBooking =EventBooking.FindByEventName(eventName);
        if(eventBooking==null)
        {
            System.out.println("event not found");
                return "event not found,can't book" ;
        }
        else
        {   if(eventBooking.getAvailableTickets()<num_tickets){
            System.out.println("available tickets not enough");
            return "available tickets not enough" ;
        }
            else
            eventBooking.setAvailableTickets(eventBooking.getAvailableTickets()-num_tickets);
            System.out.println("confirm booking");
            return "confirm booking" ;
        }
    }
    @Component
    public class EventBookingInitializer {

        @PostConstruct
        public void init() {
            if (EventBooking.events.isEmpty())
            {
                EventBooking.events.add(new EventBooking(101,"Music Fest 2024","New York","A grand musical evening with top artists!","2024-12-31",500,1500));
                EventBooking.events.add(new EventBooking(102,"Marwan Pablo concert","Cairo,almaza park mall","A grand musical evening with marwan pablo ","2024-12-31",1000,1000));
            }
        }
    }
}
