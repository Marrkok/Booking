package com.OnlineBooking.OnlineBooking.Model;
import java.time.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.java.accessibility.util.EventID;

public class EventBooking extends Booking {


    private int eventID;
    private String EventName;
    private String Eventdate;



    private int TicektesBooked;
    private String Eventdescription;
    @JsonProperty("TotalPrice")
    private double price;
    public EventBooking(Event event,int ID,int ticektesbooked){
        this.EventName = event.getEventName();
        this.Eventdate = event.getEventDate();
        this.eventID=event.getEventID();
        this.price = event.getPrice()*ticektesbooked;
        this.Eventdescription = event.getEventDescription();
        setUserID(ID);
        setBookingID("E"+(1000+ID));
        setBookingDate(LocalDate.now().toString());
        setTicektesBooked(ticektesbooked);
    }
    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventId) {
        this.eventID = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String hotelName) {
        this.EventName = hotelName;
    }

    public String getEventdate() {
        return Eventdate;
    }

    public String getEventdescription() {
        return Eventdescription;
    }

    public void setDescription(String description) {
        this.Eventdescription = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    public int getTicektesBooked() {
        return TicektesBooked;
    }

    public void setTicektesBooked(int ticektesbooked) {
        TicektesBooked = ticektesbooked;
    }
}
