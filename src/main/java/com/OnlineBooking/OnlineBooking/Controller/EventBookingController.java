package com.OnlineBooking.OnlineBooking.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.OnlineBooking.OnlineBooking.Model.Event;
import com.OnlineBooking.OnlineBooking.Service.EventBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EventBookingController {

    @Autowired
    private EventBookingService eventBookingService;

 ///////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/book/Event")
    public ResponseEntity<String> bookEvents(@RequestBody Map<String, Object> events)
    {
        String eventName = (String) events.get("EventName");
        int numTickets = (int) events.get("NumTickets");

        try {
            String bookingResponse = eventBookingService.bookEvent(eventName, numTickets);
            if (bookingResponse.startsWith("confirm")) {
                return ResponseEntity.ok("Event Booked");
            } else if (bookingResponse.startsWith("event not")) {
                return ResponseEntity.status(404).body("Invalid booking, " + bookingResponse);
            } else if (bookingResponse.startsWith("available tickets not enough")) {
                return ResponseEntity.status(400).body("Invalid booking, " + bookingResponse);
            } else if (bookingResponse.startsWith("User")) {
                return ResponseEntity.status(404).body(bookingResponse);
            } else {
                return ResponseEntity.status(500).body("Internal Server Error");
            }
        } catch (Exception e) {
            String message = "Error in user booking: " + e.getMessage();
            return ResponseEntity.status(500).body(message);
        }
    }

 /////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/events/booked")
    public ResponseEntity<String> getBookedEvents() {
        try {
            String bookedEvents = eventBookingService.getBookedEvents();
            return ResponseEntity.ok(bookedEvents);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving booked events: " + e.getMessage());
        }
    }

  ////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/addevent")
    public ResponseEntity<String> addEvent(@RequestBody Map<String, Object> newEvent)
    {
        String eventName = (String) newEvent.get("eventName");
        String eventDate = (String) newEvent.get("eventDate");
        String eventLocation = (String) newEvent.get("eventLocation");
        String eventDescription = (String) newEvent.get("eventDescription");
        int ticketsAvailable = (int) newEvent.get("ticketsAvailable");
        double price = (double) newEvent.get("price");

        try {
            Event newEventObj = new Event(eventName, eventDate, eventLocation, eventDescription, ticketsAvailable, price);
            Event.events.add(newEventObj);
            return ResponseEntity.ok("Event added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding event: " + e.getMessage());
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/search/events")
    public ResponseEntity<String> searchEvents(@RequestBody Map<String, String> eventRequest)
    {
        String eventName = eventRequest.get("eventName");
        try {
            List<Event> matchedEvents = new ArrayList<>();
            for (Event event : Event.events) {
                if (event.getEventName().toLowerCase().contains(eventName.toLowerCase())) {
                    matchedEvents.add(event);
                }
            }

            if (matchedEvents.isEmpty()) {
                return ResponseEntity.status(404).body("Event not found: " + eventName);
            } else {
                StringBuilder result = new StringBuilder("{\"status\": \"success\", \"event\": {");
                for (Event event : matchedEvents) {
                    result.append("\"name\": \"").append(event.getEventName())
                            .append("\", \"date\": \"").append(event.getEventDate())
                            .append("\", \"location\": \"").append(event.getEventLocation())
                            .append("\", \"description\": \"").append(event.getEventDescription())
                            .append("\", \"availableTickets\": ").append(event.getTicketsAvailable())
                            .append(", \"price\": ").append(event.getPrice())
                            .append("}}");
                }
                return ResponseEntity.ok(result.toString());
            }
        } catch (Exception e)
        {
            return ResponseEntity.status(500).body("Error during event search: " + e.getMessage());
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/events/getem")
    public ArrayList<Event> getEvents()
    {
        return Event.events;
    }
    @GetMapping("/eventbookings/getem")
    public ArrayList getHotelbookings(){return eventBookingService.getEventBookings();}

}
