package com.OnlineBooking.OnlineBooking.Service;

import com.OnlineBooking.OnlineBooking.Model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.time.*;
@Service
public class EventBookingService
{
   private Event event;
   private ArrayList<EventBooking> eventBookings=new ArrayList<>();
   private UserService userService;

    public String searchEvents(String eventName)
    {
        for (Event event : Event.events)
        {
            if (event.getEventName().equalsIgnoreCase(eventName))
            {
                return "Event found: " + eventName;
            }
        }
        return "Event not found";
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
    public String bookEvent(String eventName, int numTickets)
    {
        for (Event event : Event.events)
        {
            if (event.getEventName().equalsIgnoreCase(eventName))
            {
                if (event.getTicketsAvailable() >= numTickets)
                {
                    event.bookTickets(numTickets);
                    addBooking(event,UserService.getsession(),numTickets);
                    return "confirm booking";
                }
                else
                {
                    return "available tickets not enough";
                }
            }
        }
        return "event not found";
    }
 /////////////////////////////////////////////////////////////////////////////////////////////////
    public String getBookedEvents() {
        StringBuilder bookedEvents = new StringBuilder();
        for (Event event : Event.events) {
            bookedEvents.append("Event: ").append(event.getEventName())
                    .append(", Tickets Booked: ").append(event.getTicketsBooked())
                    .append(", Tickets Available: ").append(event.getTicketsAvailable())
                    .append("\n");
        }
        return bookedEvents.toString();
    }
    public void addBooking(Event eventb, Integer ID,int numtickets){
        EventBooking eb = new EventBooking(eventb,ID,numtickets);
        eventBookings.add(eb);
    }

    public ArrayList<EventBooking> getEventBookings() {
        return eventBookings;
    }
    @Component
    public class EventInitializer {

        @PostConstruct
        public void init() {
            if (Event.events.isEmpty())
            {
                event.addEvent(new Event("Summer Music Festival", "2024-06-15", "Central Park, New York", "Join us for a day of amazing live performances by top artists.", 500, 49.99));
                event.addEvent(new Event("Tech Innovators Conference", "2024-09-10", "Silicon Valley, California", "A conference bringing together the brightest minds in tech.", 200, 299.99));
            }
        }
    }
}
