package com.example.quran.Fragments;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quran.Adapters.HadesContentAdapter;
import com.example.quran.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HadesContentFragment extends Fragment {
String NameFile;
int x;

    public void setX(int x) {
        this.x = x;
    }

    public void setNameFile(String nameFile) {
        NameFile = nameFile;
    }

    public HadesContentFragment() {
        // Required empty public constructor

    }
    ArrayList<String>hadesContent;
    RecyclerView.LayoutManager layoutManager;
    HadesContentAdapter adapter;
TextView title;
    RecyclerView recyclerView;
View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_hades_content, container, false);


        recyclerView=view.findViewById(R.id.recyclerViewHades);

        readFile("h"+x+".txt");

        adapter=new HadesContentAdapter(hadesContent);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    ArrayList<String> readFile(String fileName)
    {
        BufferedReader reader;
        AssetManager assetManager=getContext().getAssets();
        hadesContent=new ArrayList<>();


        try{
            final InputStream file = assetManager.open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){
                hadesContent.add(line);
                line = reader.readLine();
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return hadesContent;
    }

}
