package com.snap.tutorialmvvm.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.snap.tutorialmvvm.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_recyclerView;
    private FloatingActionButton main_add_fab;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setListener();

    }

    private void setListener() {
        main_add_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getBaseContext(), AddDataActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initialize() {
        main_recyclerView = findViewById(R.id.main_recyclerView);
        main_add_fab = findViewById(R.id.main_add_fab);
    }
}