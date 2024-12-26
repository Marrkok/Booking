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
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;
    private User loggedUser;
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
    {  loggedUser=loggedUser.findByid(userService.getsession());
        if(loggedUser!=null) {
        for (Event event : Event.events)
        {
            if (event.getEventName().equalsIgnoreCase(eventName))
            {
                if (event.getTicketsAvailable() >= numTickets)
                {
                    notificationService.addNotificationToQueue(new Notification("Your booking for "+eventName +" has been confirmed!",loggedUser.getEmail()));
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
        return "event not found";}
        else return "User not logged in, please login first";
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
    public ArrayList<EventBooking> getEventBookingsBYID(int userID) {
        ArrayList<EventBooking> userBook=new ArrayList<>();
        for(EventBooking booking: eventBookings ) {
            if(booking.getUserID()==userID){
                userBook.add(booking);
            }

        }
        return userBook;
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
