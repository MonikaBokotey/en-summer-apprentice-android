package com.example.ticketmanagementsystem;

public class EventDto {
    public long EventId;


    public String EventName;

    public String EventDescription;

    public String EventType;

    public String Venue;

    public long getEventId() {
        return EventId;
    }

    public void setEventId(long eventId) {
        EventId = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String eventDescription) {
        EventDescription = eventDescription;
    }

    public String getEventType() {
        return EventType;
    }

    public void setEventType(String eventType) {
        EventType = eventType;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public EventDto() {
    }

    public EventDto(long eventId, String eventName, String eventDescription, String eventType, String venue) {
        EventId = eventId;
        EventName = eventName;
        EventDescription = eventDescription;
        EventType = eventType;
        Venue = venue;
    }
}
