package com.example.quran.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quran.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnalsysFragment extends Fragment {


    public AnalsysFragment() {
        // Required empty public constructor
    }
int total=0;
    View view;
    Spinner spinner;
    TextView counter;
    ImageView sebha;
    Button button,tasbeha,totaltasbeha;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_analsys, container, false);

        spinner=view.findViewById(R.id.spinner);
        sebha=view.findViewById(R.id.tasbeh);
  tasbeha=view.findViewById(R.id.btnNumOfClicks2);
  totaltasbeha=view.findViewById(R.id.btnNumOfClicks1);
        button=view.findViewById(R.id.btn_reset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd(v);
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tasbeha.setText(0+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        sebha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int x=Integer.parseInt(tasbeha.getText().toString());
               x++;
               tasbeha.setText(x+"");
               total++;
               totaltasbeha.setText(total+"");

            }
        });










                return view;

    }
    public void asd(View v)
    {
       tasbeha.setText(0+"");
       total=0;
       totaltasbeha.setText(0+"");

    }


}
