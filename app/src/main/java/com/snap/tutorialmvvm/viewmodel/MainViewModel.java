package com.snap.tutorialmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.snap.tutorialmvvm.model.Mahasiswa;
import com.snap.tutorialmvvm.repositories.MainRepository;

import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel {

    private MainRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = MainRepository.getInstance();
    }

    //    begin of viewModel AddMahasiswa

    private MutableLiveData<ArrayList<Mahasiswa>> resultAddMahasiswa = new MutableLiveData<>();

    public void setResultAddMahasiswa(String name, String nim) {
        resultAddMahasiswa = repository.addMahasiswa(name, nim);
    }

    public LiveData<ArrayList<Mahasiswa>> getResultAddMahasiswa() {
        return resultAddMahasiswa;
    }

    //    end of viewModel AddMahasiswa


    //    begin of viewModel GetMahasiswa

    private MutableLiveData<ArrayList<Mahasiswa>> resultGetMahasiswa = new MutableLiveData<>();

    public void setResultGetMahasiswa() {
        resultGetMahasiswa = repository.getMahasiswa();
    }

    public LiveData<ArrayList<Mahasiswa>> getResultGetMahasiswa() {
        return resultGetMahasiswa;
    }

    //    end of viewModel AddMahasiswa

}
