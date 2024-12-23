package com.OnlineBooking.OnlineBooking.Service;

import com.OnlineBooking.OnlineBooking.Model.Event;
import com.OnlineBooking.OnlineBooking.Model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventBookingService
{


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
}
