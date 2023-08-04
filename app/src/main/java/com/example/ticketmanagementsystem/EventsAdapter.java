package com.example.ticketmanagementsystem;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    private List<Event> eventList;

    public EventsAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_view, parent, false);
        return new EventViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        Log.d("Adapter", "Binding event: " + event.getEventName() + " at position: " + position);
        holder.eventNameTextView.setText(event.getEventName());
        holder.eventDescriptionTextView.setText(event.getEventDescription());
        holder.eventDateTextView.setText(event.getEventDate());
        holder.eventLocationTextView.setText(event.getEventLocation());
        holder.eventPhoto.setImageResource(event.getEventImage());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventNameTextView;
        TextView eventDescriptionTextView;
        TextView eventDateTextView;
        TextView eventLocationTextView;
        ImageView eventPhoto;

        EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventNameTextView = itemView.findViewById(R.id.customTextView);
            eventDescriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            eventDateTextView = itemView.findViewById(R.id.dateTextView);
            eventLocationTextView = itemView.findViewById(R.id.locationTextView);
            eventPhoto = itemView.findViewById(R.id.eventPhoto);
        }
    }
}
