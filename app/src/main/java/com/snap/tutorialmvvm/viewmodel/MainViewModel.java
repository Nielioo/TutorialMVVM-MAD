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
    private MutableLiveData<ArrayList<Mahasiswa>> resultAddMahasiswa = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = MainRepository.getInstance();
    }

    public void setResultAddMahasiswa(String name, String nim){
        resultAddMahasiswa = repository.addMahasiswa(name, nim);
    }

    public LiveData<ArrayList<Mahasiswa>> getResultAddMahasiswa(){
        return resultAddMahasiswa;
    }
}
