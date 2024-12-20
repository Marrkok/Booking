package com.OnlineBooking.OnlineBooking.Model;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Component
public class EventBooking implements Booking
{
    ArrayList<EventBooking> events = new ArrayList<>();


    private int eventID;
    private String eventName;
    private String eventLocation;
    private String eventDate;
    private String eventDescription;
    private int TotalTickets;
    private int AvailableTickets;

    public EventBooking(){};
    public EventBooking(int eventID, String eventName, String eventLocation, String eventDescription, String eventDate, int totalTickets) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        TotalTickets = totalTickets;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getTotalTickets() {
        return TotalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        TotalTickets = totalTickets;
    }

    public int getAvailableTickets() {
        return AvailableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        AvailableTickets = availableTickets;
    }

    public boolean addevent(EventBooking e)
    {
        events.add(e);
        return true;
    }
    public  boolean getevent(EventBooking e)
    {
        return events.contains(e);
    }




    @Override
    public boolean confirmBooking() {
        return true;
    }

    @Override
    public boolean cancelBooking() {
        return true;
    }
    public boolean NumAvaliableTtickets(EventBooking e,String EvnetName)
    {
        if(e.getEventName().equals(EvnetName))
        {
            e.setAvailableTickets(AvailableTickets--);
        }

        return true;
    }

}
