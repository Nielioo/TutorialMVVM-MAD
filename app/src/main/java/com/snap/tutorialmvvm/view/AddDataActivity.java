package com.snap.tutorialmvvm.view;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.snap.tutorialmvvm.R;
import com.snap.tutorialmvvm.model.Mahasiswa;
import com.snap.tutorialmvvm.viewmodel.MainViewModel;

import java.util.ArrayList;

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
        setListener();

    }

    private Observer<ArrayList<Mahasiswa>> showResult = new Observer<ArrayList<Mahasiswa>>() {
        @Override
        public void onChanged(ArrayList<Mahasiswa> result) {
//            for(int i=0;i<result.size();i++){
//                Log.e("Mhs ke-"+(i+1), result.get(i).getName());
//            }
            finish();
        }
    };



    private void setListener() {
        add_data_submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = add_data_name_til.getEditText().getText().toString().trim();
                nim = add_data_nim_til.getEditText().getText().toString().trim();
                if(name.isEmpty()){
                    add_data_name_til.setError(getString(R.string.cannot_null));
                } else {
                    if (nim.isEmpty()){
                        add_data_nim_til.setError(getString(R.string.cannot_null));
                    } else {
                        viewModel.setResultAddMahasiswa(name,nim);
                        viewModel.getResultAddMahasiswa().observe(AddDataActivity.this, showResult);
                    }
                }
            }
        });
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