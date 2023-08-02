package com.example.ticketmanagementsystem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Orders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_view);
    }

    public Orders(){

    }
    private String name;

    public Orders(String name) {
        this.name = name;
    }

    public Orders(int contentLayoutId, String name) {
        super(contentLayoutId);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
