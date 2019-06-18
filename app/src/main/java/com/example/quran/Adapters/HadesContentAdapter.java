package com.example.quran.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quran.R;

import java.util.ArrayList;

public class HadesContentAdapter extends RecyclerView.Adapter<HadesContentAdapter.ViewHolder> {

    ArrayList<String> items;
    public HadesContentAdapter(ArrayList<String>items) {
        this.items=items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hades_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.hades.setText(items.get(i));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

       TextView hades;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hades=itemView.findViewById(R.id.HadesContentQuran);


        }
    }
}
