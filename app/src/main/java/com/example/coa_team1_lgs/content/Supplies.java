package com.example.coa_team1_lgs.content;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.coa_team1_lgs.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Supplies extends AppCompatActivity {
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplies);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerview);
        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("supplies");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInventory();
            }
        });

    }

    private void addInventory() {

        AlertDialog.Builder myDialog = new AlertDialog.Builder(Supplies.this);
        LayoutInflater inflater = LayoutInflater.from(Supplies.this);
        View myView = inflater.inflate(R.layout.addsupplies, null);
        myDialog.setView(myView);

        final AlertDialog dialog = myDialog.create();
        dialog.show();
        dialog.setCancelable(false);
    }


}