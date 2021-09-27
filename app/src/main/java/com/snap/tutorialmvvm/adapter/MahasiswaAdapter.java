package com.snap.tutorialmvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snap.tutorialmvvm.R;
import com.snap.tutorialmvvm.model.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Mahasiswa> mahasiswaList;

    public MahasiswaAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(ArrayList<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mahasiswa, parent, false);
        return new MahasiswaAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        final Mahasiswa m = getMahasiswaList().get(position);
        holder.adp_name_lbl.setText(m.getName());
        holder.adp_nim_lbl.setText(m.getNim());
    }

    @Override
    public int getItemCount() {
        return getMahasiswaList().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        TextView adp_name_lbl, adp_nim_lbl;

        CardViewViewHolder(View item) {
            super(item);
            adp_name_lbl = item.findViewById(R.id.adp_name_lbl);
            adp_nim_lbl = item.findViewById(R.id.adp_nim_lbl);
        }
    }
}