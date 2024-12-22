package com.OnlineBooking.OnlineBooking.Service;

import com.OnlineBooking.OnlineBooking.Model.Event;
import com.OnlineBooking.OnlineBooking.Model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EventBookingService
{
    @Autowired
    private Event Event;

    public boolean AddEvent(Event EVU)
    {
        Event existing=Event.FindByEventName(EVU.getEventName());
        if(existing!=null)
        {
            System.out.println("the Event Already Exists");
            return false;
        }
        else{

            Event newEvent= new Event(EVU.getEventID(),EVU.getEventName(),EVU.getEventLocation(),EVU.getEventDescription(),EVU.getEventDate(),EVU.getTotalTickets(),EVU.getTotalTickets());
            Event.events.add(newEvent);
            System.out.println("Successfully Added Event");
            return true;}
    }


    public boolean searchEvents(String eventName)
    {
      Event =Event.FindByEventName(eventName);
       if(Event.getEventName()==eventName)
       {
           System.out.println(Event.getEventDate()+" "+Event.getEventDescription()+" "+Event.getEventLocation());
           System.out.println(Event.getAvailableTickets()+" "+Event.getPrice());
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
        Event =Event.FindByEventName(eventName);
        if(Event==null)
        {
            System.out.println("event not found");
                return "event not found,can't book" ;
        }
        else
        {   if(Event.getAvailableTickets()<num_tickets){
            System.out.println("available tickets not enough");
            return "available tickets not enough" ;
        }
            else{
            Event.setAvailableTickets(Event.getAvailableTickets()-num_tickets);
            System.out.println("confirm booking");
            return "confirm booking" ;}
        }
    }
    @Component
    public class EventInitializer {

        @PostConstruct
        public void init() {
            if (Event.events.isEmpty())
            {
                Event.events.add(new Event(101,"Music Fest 2024","New York","A grand musical evening with top artists!","2024-12-31",500,1500));
                Event.events.add(new Event(102,"Marwan Pablo concert","Cairo,almaza park mall","A grand musical evening with marwan pablo ","2024-12-31",1000,1000));
            }
        }
    }
}
