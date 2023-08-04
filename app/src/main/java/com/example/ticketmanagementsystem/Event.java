package com.example.ticketmanagementsystem;

public class Event {
    private String eventName;
    private String eventDescription;
    private String eventDate;
    private String eventLocation;

    private int eventImage;

    public Event(String eventName, String eventDescription, String eventDate, String eventLocation, int eventImage) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventImage = eventImage;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public int getEventImage() {
        return eventImage;
    }
}
