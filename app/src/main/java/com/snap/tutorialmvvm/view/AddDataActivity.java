package com.snap.tutorialmvvm.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.snap.tutorialmvvm.R;
import com.snap.tutorialmvvm.viewmodel.MainViewModel;

public class AddDataActivity extends AppCompatActivity {

    private Toolbar add_data_toolbar;
    private TextInputLayout add_data_name_til, add_data_nim_til;
    private Button add_data_submit_button;
    
    private String name = "", nim = "";
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        initialize();

    }

    private void initialize() {
        add_data_toolbar = findViewById(R.id.add_data_toolbar);
        add_data_name_til = findViewById(R.id.add_data_name_til);
        add_data_nim_til = findViewById(R.id.add_data_nim_til);
        add_data_submit_button = findViewById(R.id.add_data_submit_button);

        setSupportActionBar(add_data_toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}