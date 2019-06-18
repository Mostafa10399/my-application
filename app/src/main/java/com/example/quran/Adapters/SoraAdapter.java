package com.example.quran.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quran.R;

import java.util.ArrayList;
import java.util.List;

public class SoraAdapter extends RecyclerView.Adapter<SoraAdapter.ViewHolder> {
    OnItemClickedListner4 onItemClickedListner4;

    public void setOnItemClickedListner4(OnItemClickedListner4 onItemClickedListner4) {
        this.onItemClickedListner4 = onItemClickedListner4;
    }

    ArrayList<String> items;
    public SoraAdapter(ArrayList<String>items) {
        this.items=items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.soura_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {
        viewHolder.sora.setText(items.get(i));
        if (onItemClickedListner4!=null)
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    onItemClickedListner4.onItemClicked(i);
                }
            });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

       TextView sora;
       View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sora=itemView.findViewById(R.id.SoraContentQuran);


        }
    }
    public interface OnItemClickedListner4
    {

        public void onItemClicked(int position);
    }

}
