package com.example.quran.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.quran.API.APIManger;
import com.example.quran.API.Model.Radio.RadiosItem;
import com.example.quran.API.Model.Radio.ResponseRadios;
import com.example.quran.Adapters.RadioAdapter;
import com.example.quran.Base.BaseFragment;
import com.example.quran.R;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListeningFragment extends BaseFragment {

    public ListeningFragment() {
        // Required empty public constructor
    }
    boolean x=true;
ImageView playyyyy;
    View view;
RadioAdapter adapter;
RecyclerView.LayoutManager layoutManager;
RecyclerView recyclerView;

    MediaPlayer mediaPlayer;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_listening, container, false);
       showProgressBar();





       playyyyy=view.findViewById(R.id.play);
       recyclerView=view.findViewById(R.id.RadiosRecycler);
       layoutManager=new LinearLayoutManager(getActivity());
       adapter = new RadioAdapter(null);
       recyclerView.setAdapter(adapter);
       recyclerView.setLayoutManager(layoutManager);
//       if(x) {
           adapter.setOnplayClickedLisnter(new RadioAdapter.OnItemClickedLisnter() {
               @Override
               public void OnItemClick(int pos, RadiosItem radiosItem) {
//                   playRadio(radiosItem.getURL());
               adapter.setSelected(pos);

               }
           });
//           x=false;
//       }
//       else if(!x) {
           adapter.setOnpauseClickedLisnter(new RadioAdapter.OnItemClickedLisnter() {
               @Override
               public void OnItemClick(int pos, RadiosItem radiosItem) {
//                   stopRadio();
               }
           });
//           x=true;
//       }
        APIManger.getApis().getAllCalls().enqueue(new Callback<ResponseRadios>() {

            @Override
            public void onResponse(Call<ResponseRadios> call, Response<ResponseRadios> response) {


                if(response.isSuccessful())
                {
                    hideProgress();
                    List<RadiosItem>channels=response.body().getRadios();
                  adapter.ChangeData(response.body().getRadios());
                }
            }

            @Override
            public void onFailure(Call<ResponseRadios> call, Throwable t) {
                hideProgress();
                showMessage("error",t.getLocalizedMessage(),"OK");

            }
        });

   return view;
    }

    public void playRadio(String Url)
    {
       stopRadio();
        mediaPlayer= new MediaPlayer();
        try {
            mediaPlayer.setDataSource(Url);
        } catch (IOException e) {
          showMessage(R.string.error,R.string.Can,R.string.ok);
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
           mediaPlayer=null;
       }


    }


}
