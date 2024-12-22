package com.OnlineBooking.OnlineBooking.Model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EventBooking extends Booking
{
    public  static  ArrayList<EventBooking> events = new ArrayList<>();



    private int eventID;
    private String eventName;
    private String eventLocation;
    private String eventDate;
    private String eventDescription;
    private int TotalTickets;
    private int Price;
    private int AvailableTickets;
    public String BookingID;
    public String BookingDate ;
    public String UserID;

    public EventBooking(){};
    public EventBooking(int eventID, String eventName, String eventLocation, String eventDescription, String eventDate, int totalTickets,int Price) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.TotalTickets= totalTickets;
        this.AvailableTickets=TotalTickets;
        this.Price = Price;
    }

    public int getEventID()
    {
        System.out.print("Event ID: " + eventID);
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName()
    {
        System.out.print("Event Name: " + eventName);
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation()
    {
        System.out.print("Event Location: " + eventLocation);
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate()
    {
        System.out.print("Event Date: " + eventDate);
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription()
    {
        System.out.print("Event Description: " + eventDescription);
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getTotalTickets()
    {
        System.out.print("Total Tickets: " + TotalTickets);
        return TotalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        TotalTickets = totalTickets;
    }

    public int getAvailableTickets()
    {
        System.out.print("Available Tickets: " + AvailableTickets);
        return AvailableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        AvailableTickets = availableTickets;
    }

    public int getPrice()
    {
        System.out.print("Price: " + Price);
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void addEvent(EventBooking e)
    {
        events.add(e);
    }
    public void RemoveEvent(EventBooking e)
    {
        events.remove(e);
    }

    public static EventBooking FindByEventName(String eventName)
    {
        for(EventBooking e : events)
        {
            if(e.getEventName().equals(eventName))
            {
                return e;
            }
        }
        return null;
    }

}
