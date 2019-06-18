package com.example.quran.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quran.Adapters.HadesAdapter;
import com.example.quran.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchingFragment extends Fragment {


    public SearchingFragment() {
        // Required empty public constructor
    }


    ArrayList<String>items;
    HadesAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    View view;
    static FragmentManager fragmentManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_searching, container, false);
        asd();
        recyclerView=view.findViewById(R.id.hadessss);
        adapter=new HadesAdapter(items);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClicked1(new HadesAdapter.OnItemClickedListner1() {
            @Override
            public void onClicked(int position) {
                HadesContentFragment fragment=new HadesContentFragment();
                fragment.setNameFile(items.get(position));
                fragment.setX(position+1);
                Log.e("p",position+"");
                fragmentManager=getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame,fragment).addToBackStack(null).commit();
            }
        });
        return view;

    }
    public void asd()
    {
        items=new ArrayList<>();
        for (int i=1;i<51;i++)
            items.add(new String("حديث رقم "+i));


    }





}
