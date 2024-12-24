package com.OnlineBooking.OnlineBooking.Model;

import java.util.ArrayList;

public class Event
{

    public static ArrayList<Event> events = new ArrayList<>();

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    private int eventID;
    private String eventName;
    private String eventDate;
    private String eventLocation;
    private String eventDescription;
    private int ticketsAvailable;
    private int ticketsBooked;
    private double price;


    public Event(String eventName, String eventDate, String eventLocation, String eventDescription, int ticketsAvailable, double price) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.ticketsAvailable = ticketsAvailable;
        this.ticketsBooked = 0;
        this.price = price;
        eventID= events.size()+1;
    }


    public String getEventName()
    {
        return eventName;
    }

    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }

    public String getEventDate()
    {
        return eventDate;
    }

    public void setEventDate(String eventDate)
    {
        this.eventDate = eventDate;
    }

    public String getEventLocation()
    {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation)
    {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription()
    {

        return eventDescription;
    }

    public void setEventDescription(String eventDescription)
    {

        this.eventDescription = eventDescription;
    }

    public int getTicketsAvailable()
    {

        return ticketsAvailable;
    }

    public void setTicketsAvailable(int ticketsAvailable)
    {

        this.ticketsAvailable = ticketsAvailable;
    }

    public int getTicketsBooked()
    {

        return ticketsBooked;
    }

    public void setTicketsBooked(int ticketsBooked)
    {

        this.ticketsBooked = ticketsBooked;
    }

    public double getPrice()
    {

        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }


    public void bookTickets(int numTickets)
    {
        if (numTickets <= ticketsAvailable)
        {
            ticketsBooked += numTickets;
            ticketsAvailable -= numTickets;
        }
        else
        {
            throw new IllegalArgumentException("Not enough tickets available");
        }
    }


    public static void addEvent(Event event)
    {
        events.add(event);
    }
}
