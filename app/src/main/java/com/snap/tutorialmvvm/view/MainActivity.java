package com.snap.tutorialmvvm.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.snap.tutorialmvvm.R;
import com.snap.tutorialmvvm.adapter.MahasiswaAdapter;
import com.snap.tutorialmvvm.model.Mahasiswa;
import com.snap.tutorialmvvm.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_recyclerView;
    private FloatingActionButton main_add_fab;
    private MainViewModel viewModel;

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

        viewModel = new ViewModelProvider(MainActivity.this).get(MainViewModel.class);
        viewModel.setResultGetMahasiswa();
        viewModel.getResultGetMahasiswa().observe(MainActivity.this,showResult);
    }

    private Observer<ArrayList<Mahasiswa>> showResult = new Observer<ArrayList<Mahasiswa>>() {
        @Override
        public void onChanged(ArrayList<Mahasiswa> result) {
            main_recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            MahasiswaAdapter adapter = new MahasiswaAdapter(MainActivity.this);
            adapter.setMahasiswaList(result);
            main_recyclerView.setAdapter(adapter);
        }
    };
}