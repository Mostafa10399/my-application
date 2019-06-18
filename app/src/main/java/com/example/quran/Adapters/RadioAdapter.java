package com.example.quran.Adapters;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quran.API.Model.Radio.RadiosItem;
import com.example.quran.R;

import java.io.IOException;
import java.util.List;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.ViewHolder> {
 public List<RadiosItem>items;
boolean x=true;
int selected=-1;
int z;

    public void setSelected(int selected) {
        this.selected = selected;
    }

    OnItemClickedLisnter onplayClickedLisnter;
  OnItemClickedLisnter onItemClickedLisnter;
    OnItemClickedLisnter onpauseClickedLisnter;

    MediaPlayer mediaPlayer;

    public void playRadio(String Url)
    {
        stopRadio();
        mediaPlayer= new MediaPlayer();
        try {
            mediaPlayer.setDataSource(Url);
        } catch (IOException e) {
     //       showMessage(R.string.error,R.string.Can,R.string.ok);
        }
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared( MediaPlayer mp) {

                mediaPlayer=mp;
                mediaPlayer.start();

            }
        });
    }
    public void stopRadio()
    {
        if(mediaPlayer!=null) {
            mediaPlayer.stop();
           if(mediaPlayer.isPlaying())
            mediaPlayer=null;
        }


    }

    public void ChangeDataa(List<RadiosItem>radiosItem)
    {
        this.items=radiosItem;
        notifyDataSetChanged();

    }



    public void setOnpauseClickedLisnter(OnItemClickedLisnter onpauseClickedLisnter) {
        this.onpauseClickedLisnter = onpauseClickedLisnter;
    }

    public void setOnplayClickedLisnter(OnItemClickedLisnter onplayClickedLisnter) {
        this.onplayClickedLisnter = onplayClickedLisnter;
    }


    public RadioAdapter(List<RadiosItem>items) {
        this.items=items;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.radio_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        final RadiosItem content=items.get(position);
        viewHolder.nameOfReader.setText(content.getName());
           if (position!=selected)
           {
               stopRadio();
               viewHolder.play.setImageResource(R.drawable.ic_play);
               stopRadio();
           }

            if (onplayClickedLisnter != null && x) {

                viewHolder.play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopRadio();
                        onplayClickedLisnter.OnItemClick(position, content);
                        viewHolder.play.setImageResource(R.drawable.ic_pause);
                        playRadio(content.getURL());
                        notifyDataSetChanged();
                        x = false;

                    }

                });
            }
            if (onpauseClickedLisnter != null && !x) {
                viewHolder.play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onplayClickedLisnter.OnItemClick(position, content);
                        viewHolder.play.setImageResource(R.drawable.ic_play);
                        stopRadio();
                        notifyDataSetChanged();

                        x = true;
                    }
                });
            }
        }




    public void ChangeData(List<RadiosItem>items)
    {
        this.items=items;
        notifyDataSetChanged();


    }

    public void setOnItemClickedLisnter(OnItemClickedLisnter onItemClickedLisnter) {
        this.onItemClickedLisnter = onItemClickedLisnter;
    }

    @Override
    public int getItemCount() {
        if (items==null)
            return 0;
        return items.size();
    }



    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameOfReader;
      public ImageView play,pause;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfReader=itemView.findViewById(R.id.nameOfReader);
            play=itemView.findViewById(R.id.play);

        }


    }

    public interface OnItemClickedLisnter
    {
         void OnItemClick(int pos,RadiosItem radiosItem);

    }


}
