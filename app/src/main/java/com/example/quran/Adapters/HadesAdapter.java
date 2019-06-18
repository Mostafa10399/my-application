package com.example.quran.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quran.R;

import java.util.ArrayList;

public class HadesAdapter extends RecyclerView.Adapter <HadesAdapter.ViewHolder> {
    ArrayList<String>items;
    OnItemClickedListner1 onItemClicked1;


    public void setOnItemClicked1(OnItemClickedListner1 onItemClicked1) {
        this.onItemClicked1 = onItemClicked1;
    }

    public HadesAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hades_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
viewHolder.hadesnumber.setText(items.get(position));
if(onItemClicked1!=null)
{
    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onItemClicked1.onClicked(position);

        }
    });


}
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView hadesnumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hadesnumber=itemView.findViewById(R.id.hadesNumber);
        }
    }
    public interface OnItemClickedListner1 {
        public void onClicked(int position);
    }
}
