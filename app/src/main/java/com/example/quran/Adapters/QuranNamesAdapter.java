package com.example.quran.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quran.R;

public class QuranNamesAdapter extends RecyclerView.Adapter<QuranNamesAdapter.ViewHolder> {


    OnItemClickedListner onNameClicked;

    public void setOnNameClicked(OnItemClickedListner onNameClicked) {
        this.onNameClicked = onNameClicked;
    }

    String []names;
    public QuranNamesAdapter(String []names) {
       this.names=names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position)
    {
        viewHolder.textView.setText(names[position]);
        if (onNameClicked!=null)
        {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNameClicked.onItemClicked(position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        TextView textView;
        public ViewHolder(@NonNull View view) {
            super(view);
            textView=view.findViewById(R.id.nameOfsora);
        }
    }

    public interface OnItemClickedListner
    {

        public void onItemClicked(int position);
    }


}
