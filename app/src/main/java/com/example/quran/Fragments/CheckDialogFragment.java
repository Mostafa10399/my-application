package com.example.quran.Fragments;


import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quran.API.APIManger;
import com.example.quran.API.Model.SoraRadio.RecitersItem;
import com.example.quran.API.Model.SoraRadio.SoraRadioResponse;
import com.example.quran.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
 public class CheckDialogFragment extends DialogFragment {

    List<RecitersItem> enter;
String posAya;

    public void setPosAya(String posAya) {
        this.posAya = posAya;
    }

    Boolean x=true;
    public CheckDialogFragment() {
        // Required empty public constructor
    }
    int positionSora;

    public void setPosition(int position) {
        this.positionSora = position;
    }
String []soura;

    Spinner spinner;
    MediaPlayer mediaPlayer;
TextView name;
   static ImageView  play;
View view;
    String PosSora;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("pos",positionSora+"");
//        Toast.makeText(getActivity(),positionSora , Toast.LENGTH_SHORT).show();
        view= inflater.inflate(R.layout.fragment_play_sora_dialog, container, false);
        spinner=view.findViewById(R.id.nameOfMokre2);
         PosSora=positionSora+"";
        play=view.findViewById(R.id.playSora);
        while (PosSora.length()<3)
            PosSora="0"+PosSora;

        Log.e("pos",PosSora);

APIManger.getApis().getSoraCalls().enqueue(new Callback<SoraRadioResponse>() {
    @Override
    public void onResponse(Call<SoraRadioResponse> call, Response<SoraRadioResponse> response) {

       if (response.isSuccessful())
        {
            List<String>NameOfKora2=new ArrayList<>();
             enter=new ArrayList<>();
            final List<RecitersItem> chanel = response.body().getReciters();

            for (RecitersItem recitersItem:chanel) {
                soura=recitersItem.getSuras().split(",");

                for(int i=0;i<soura.length;i++)
                {
                    if(Integer.parseInt(soura[i])==positionSora) {
                        NameOfKora2.add(recitersItem.getName());
                        enter.add(recitersItem);

                    }
                }

            }
            ArrayAdapter <String>adapterSpiner=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,NameOfKora2);
            adapterSpiner.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            spinner.setAdapter(adapterSpiner);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
//                    Toast.makeText(getActivity(),enter.get(position).getId() , Toast.LENGTH_SHORT).show();
                    while ((posAya.length()<3))
                        posAya="0"+posAya;
                    final String Url=enter.get(position).getServer()+"/"+PosSora+"/"+posAya+".mp3";
                    Toast.makeText(getActivity(),Url , Toast.LENGTH_SHORT).show();
                   play.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           if(x)
                           {play.setImageResource(R.drawable.ic_pause);
                               startPlay(Url);
                               x=false;
                           }
                           else
                           {
                               stopPlay();
                               play.setImageResource(R.drawable.ic_play);
                               x=true;

                           }
                       }
                   });



                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    @Override
    public void onFailure(Call<SoraRadioResponse> call, Throwable t) {

    }
});

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIManger.getApis().getSoraCalls().enqueue(new Callback<SoraRadioResponse>() {
                    @Override
                    public void onResponse(Call<SoraRadioResponse> call, Response<SoraRadioResponse> response) {
                        if(response.isSuccessful())
                        {
                            List<RecitersItem> Kora2= response.body().getReciters();
                        }
                    }

                    @Override
                    public void onFailure(Call<SoraRadioResponse> call, Throwable t) {
                        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });


        return view;
    }
    public void stopPlay()
    {
        if (mediaPlayer!=null)
            mediaPlayer.pause();
    }
    public void startPlay(String Url)
    {
        stopPlay();
        mediaPlayer=new MediaPlayer();
        try {
            mediaPlayer.setDataSource(Url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                mediaPlayer = mp;
                mediaPlayer.start();
            }
            });


    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        stopPlay();
    }
}
