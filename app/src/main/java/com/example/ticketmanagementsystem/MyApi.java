package com.example.ticketmanagementsystem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface MyApi {
    @GET("api/Event/GetAll")
    Call<List<EventDto>> getAllEvents();

    @GET("api/Event/GetByEventId/{id}")
    Call<EventDto> getEventById(@Path("id") int eventId);

//    // You might need to modify the following endpoints based on the actual PATCH and DELETE methods in your .NET code.
//    // For example, if you are using [HttpPatch] and [HttpDelete], you can modify the annotations accordingly.
//    @PATCH("api/Event/Patch")
//    Call<EventPatchDto> patchEvent(EventPatchDto eventPatch);
//
//    @DELETE("api/Event/Delete/{id}")
//    Call<Void> deleteEvent(@Path("id") int eventId);
}
