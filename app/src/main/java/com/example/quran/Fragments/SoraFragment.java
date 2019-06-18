package com.example.quran.Fragments;


import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quran.Adapters.SoraAdapter;
import com.example.quran.ModelRoom.FragmentState;
import com.example.quran.ModelRoom.MyData;
import com.example.quran.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

import static com.example.quran.Fragments.ReadingFragment.fragmentManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SoraFragment extends Fragment {
//static SoraFragment soraFragment;
//FragmentState fragmentState;
//
//
//    List<FragmentState>fragmentStates1;

    int pos;
static boolean x=true;

    public static boolean isX() {
        return x;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    int numberOfSora=1;
    ArrayList<String>soraContent;
    public SoraFragment() {
        // Required empty public constructor
    }
 String names;


String namesFiles;

    public void setNamesFiles(String namesFiles) {
        this.namesFiles = namesFiles;
    }

    public  void setName(String name) {
     this.names = name;
    }
View view;
   static boolean xs=true;
    TextView namesss;

    RecyclerView recyclerViewSora;
    SoraAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ImageView mic,book,save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("pos",pos+"");


        view= inflater.inflate(R.layout.fragment_sora, container, false);
        namesss=view.findViewById(R.id.namessss);
        book=view.findViewById(R.id.quranico);
recyclerViewSora=view.findViewById(R.id.recyclerViewSora);
        namesss.setText(names);
        readFile(namesFiles);
        adapter=new SoraAdapter(soraContent);
        layoutManager= new LinearLayoutManager(getActivity());
//     int x=((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
//        Log.e("pos",x+"");
        recyclerViewSora.setAdapter(adapter);
        recyclerViewSora.setLayoutManager(layoutManager);
        mic=view.findViewById(R.id.listenico);
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnListen(v);
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBack(v);
            }
        });
        save=view.findViewById(R.id.saveico);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSave(v);
            }
        });
adapter.setOnItemClickedListner4(new SoraAdapter.OnItemClickedListner4() {

    @Override
    public void onItemClicked(int position) {
        CheckDialogFragment playSoraDialogFragment=new CheckDialogFragment();
        playSoraDialogFragment.setPosition(pos);
        playSoraDialogFragment.setPosAya((position+1)+"");
        playSoraDialogFragment.show(getChildFragmentManager(),"PlaySoraDialog");
    }
});
        return view;
    }
    ArrayList<String> readFile(String fileName)
    {
        BufferedReader reader;
        AssetManager assetManager=getContext().getAssets();
        soraContent=new ArrayList<>();


        try{
            final InputStream file = assetManager.open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){
                soraContent.add(line+"("+numberOfSora+")");
                numberOfSora++;
                line = reader.readLine();
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return soraContent;
    }

    public void OnSave(View V) {
        ReadingFragment sss=new ReadingFragment();
FragmentManager fragmentManager;
        fragmentManager=getActivity().getSupportFragmentManager();
//        SharedPreferences sharedPreferences=


//       FragmentState fragmentState=new FragmentState(pos,names);
//        MyData.getInstance(getContext()).toDaos().InsertFragment(fragmentState);
//         if(fragmentState) {
//
//             sss.setName(names);
//             sss.setPosssss(pos);
////             MyData.getInstance(getContext()).toDaos().InsertFragment(fragmentState)
//             fragmentManager.beginTransaction().replace(R.id.frame,sss).commit();
//             x=false;
//         }
//        else {
//             sss.setName(names);
//             sss.setPosssss(pos);
             fragmentManager.beginTransaction().replace(R.id.frame,sss).commit();
//         }
// MyData.getInstance(getContext()).endTransaction();
    }
    public void OnListen(View V)
    {
PlaySoraDialogFragment playSoraDialogFragment=new PlaySoraDialogFragment();
playSoraDialogFragment.setPosition(pos);
//playSoraDialogFragment.setCancelable(false);

        playSoraDialogFragment.show(getChildFragmentManager(),"PlaySoraDialog");
    }
    public void OnBack(View V)
    {
        Fragment fragment=new ReadingFragment();
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame,fragment).commit();

//        FragmentManager fragmentManager1=getActivity().getSupportFragmentManager();
//        fragmentManager1.po
    }




}
