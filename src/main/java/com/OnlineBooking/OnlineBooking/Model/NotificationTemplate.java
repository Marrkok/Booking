package com.OnlineBooking.OnlineBooking.Model;

public class NotificationTemplate {

    private String name;
    private String subject;
    private String message;
    private String language;
    private String channel;


    public NotificationTemplate(String name, String subject, String message, String language, String channel) {
        this.name = name;
        this.subject = subject;
        this.message = message;
        this.language = language;
        this.channel = channel;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)

    {
        this.message = message;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getChannel()
    {
        return channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }
}
