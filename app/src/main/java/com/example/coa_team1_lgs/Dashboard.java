package com.example.coa_team1_lgs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.coa_team1_lgs.content.Barangay;
import com.example.coa_team1_lgs.content.FileTracking;
import com.example.coa_team1_lgs.content.Municipality;
import com.example.coa_team1_lgs.content.Supplies;

public class Dashboard extends AppCompatActivity {
    private CardView supplies, tracking, municipalities, barangays, fur, task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        supplies = findViewById(R.id.suppliesCardview);
        tracking = findViewById(R.id.trackingCardview);
        municipalities = findViewById(R.id.municipalitiesCardview);
        barangays = findViewById(R.id.barangayCardview);
        fur = findViewById(R.id.furCardview);
        task = findViewById(R.id.taskCardview);

        fur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Under Development", Toast.LENGTH_SHORT).show();
            }
        });
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Under Development", Toast.LENGTH_SHORT).show();
            }
        });

        supplies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Supplies.class);
                startActivity(intent);
            }
        });
        tracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, FileTracking.class);
                startActivity(intent);
            }
        });
        municipalities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Municipality.class);
                startActivity(intent);
            }
        });
        barangays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Barangay.class);
                startActivity(intent);
            }
        });

    }
}