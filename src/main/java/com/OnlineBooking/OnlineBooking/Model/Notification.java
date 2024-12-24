package com.OnlineBooking.OnlineBooking.Model;

public class Notification
{

    private String message;
    private String recipientEmail;


    public Notification(String message, String recipientEmail) {
        this.message = message;
        this.recipientEmail = recipientEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipientEmail;
    }

    public void setRecipient(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }
}
