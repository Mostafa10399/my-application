package com.example.quran.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quran.Adapters.QuranNamesAdapter;
import com.example.quran.MainClasses.QuranSora;
import com.example.quran.MainClasses.ToolBarQuran;
import com.example.quran.ModelRoom.FragmentState;
import com.example.quran.ModelRoom.MyData;
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
public class ReadingFragment extends Fragment {
static FragmentManager fragmentManager;
static ReadingFragment f;
 String name;
 int posssss;

    public void setName(String name) {
        this.name = name;
    }

    public void setPosssss(int posssss) {
        this.posssss = posssss;
    }

    public ReadingFragment() {
        // Required empty public constructor
    }
    public static  String []ArSuras={"الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
            ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
            ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
            ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
            ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
            ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
            ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
            ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
            ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
            "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس"};

    RecyclerView recyclerView;
    QuranNamesAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ImageView bookGold;

List<FragmentState>fragmentStates2;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_reading, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);
        adapter=new QuranNamesAdapter(ArSuras);
//        bookGold=view.findViewById(R.id.bookGold);
        layoutManager=new GridLayoutManager(getActivity(),3,LinearLayoutManager.HORIZONTAL,true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        adapter.setOnNameClicked(new QuranNamesAdapter.OnItemClickedListner() {
            @Override
            public void onItemClicked(int position)
            {
                SoraFragment fragment=new SoraFragment();
                fragment.setName(ArSuras[position]);
                fragment.setPos(position+1);
                fragment.setNamesFiles((position+1)+".txt");
                 fragmentManager=getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame,fragment).addToBackStack(null).commit();

            }
        });

//        bookGold.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SoraFragment fragment = new SoraFragment();
//
//                FragmentState fragmentState=fragmentStates2.get(1);
////if(){
//                    Log.e("px",fragmentState.getName());
//                    fragment.setName(fragmentState.getName());
//                    fragment.setPos(fragmentState.getPosition());
//                    fragment.setNamesFiles(fragmentState.getPosition()+".txt");
//                    FragmentManager fragmentManager;
//                    fragmentManager=getActivity().getSupportFragmentManager();
//                    fragmentManager.beginTransaction().replace(R.id.frame,fragment).addToBackStack(null).commit();
//
//                }
//                else
//                    Toast.makeText(getContext(), "empety", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
        return view;
    }

}
