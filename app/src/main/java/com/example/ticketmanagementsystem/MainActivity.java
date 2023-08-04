package com.example.ticketmanagementsystem;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String[] dropdownItems1 = {"Festival de muzica", "Sport", "Bauturi"};
    private String[] dropdownItems2 = {"Stadion", "Castle", "Park"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Button applyButton = findViewById(R.id.applyButton);
        Button filterButton = findViewById(R.id.filterButton);
        LinearLayout filterLayout = findViewById(R.id.filterLayout);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dropdownItems1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dropdownItems2);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedOption1 = spinner1.getSelectedItem().toString();
                String selectedOption2 = spinner2.getSelectedItem().toString();

                // Do something with the selected options
                // For example, display a toast message
                String message = "Selected Option 1: " + selectedOption1 + "\nSelected Option 2: " + selectedOption2;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filterLayout.getVisibility() == View.VISIBLE) {
                    filterLayout.setVisibility(View.GONE);
                } else {
                    filterLayout.setVisibility(View.VISIBLE);
                }
            }
        });


        ImageButton shoppingCartIcon = findViewById(R.id.cartImageButton);
        shoppingCartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the shopping cart icon
                startActivity(new Intent(MainActivity.this, Orders.class));
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost:7214/swagger/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Now, create a service instance using the API interface.
        MyApi myApi = retrofit.create(MyApi.class);

        // You can now use the 'myApi' instance to make network requests.
        Call<List<EventDto>> call = myApi.getAllEvents();
        call.enqueue(new Callback<List<EventDto>>() {
            @Override
            public void onResponse(Call<List<EventDto>> call, Response<List<EventDto>> response) {
                if (response.isSuccessful()) {
                    List<EventDto> eventList = response.body();
                    // Process the list of events here
                    for (EventDto event : eventList) {
                        // Do something with each event in the list
                        Log.d("EventInfo", "Event Name: " + event.getEventName());

                    }
                } else {
                    // Handle error
                    Log.e("APIError", "Error: " + response.code() + " " + response.message());
                    // You can check the response code and response.errorBody() for more details on the error.
                }
            }

            @Override
            public void onFailure(Call<List<EventDto>> call, Throwable t) {
                // Handle failure
                // This method will be called if the request could not be made or the server returned an error response.
            }
        });




    }



}
