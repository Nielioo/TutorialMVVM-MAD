package com.snap.tutorialmvvm.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {

    private String name, nim;

    public Mahasiswa (){}

    public Mahasiswa(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }

    protected Mahasiswa(Parcel in) {
        name = in.readString();
        nim = in.readString();
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(nim);
    }
}
