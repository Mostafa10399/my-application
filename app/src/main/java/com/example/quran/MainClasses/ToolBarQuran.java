package com.example.quran.MainClasses;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.quran.Base.BaseActivity;
import com.example.quran.Fragments.AnalsysFragment;
import com.example.quran.Fragments.ListeningFragment;
import com.example.quran.Fragments.ReadingFragment;
import com.example.quran.Fragments.SearchingFragment;
import com.example.quran.Fragments.TranslatingFragment;
import com.example.quran.R;

public class ToolBarQuran extends BaseActivity {
    ImageView home,close;

    Fragment  fragment=null;
public  BottomNavigationView.OnNavigationItemSelectedListener onNavigation= new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId()== R.id.navigation_listening)
        {fragment= new ListeningFragment();
        }
        else if (menuItem.getItemId()==R.id.navigation_reading)
        {fragment= new ReadingFragment();
        }
        else if (menuItem.getItemId()==R.id.navigation_searching)
        {fragment= new SearchingFragment();
        }
//        else if (menuItem.getItemId()==R.id.navigation_translating)
//        {fragment= new TranslatingFragment();
//        }
        else if (menuItem.getItemId()==R.id.navigation_analsys)
        {fragment=new AnalsysFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();

        return true;
    }
};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_quran);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        close=findViewById(R.id.iconMenu);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ConfirmatonMessage(R.string.warning, R.string.aaz, R.string.no, new MaterialDialog.SingleButtonCallback() {
                   @Override
                   public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                       dialog.dismiss();
                   }
               }, R.string.Y, new MaterialDialog.SingleButtonCallback() {
                   @Override
                   public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                       moveTaskToBack(true);
                       android.os.Process.killProcess(android.os.Process.myPid());
                       finish();
                       System.exit(1);
                   }
               });

            }
        });
        home=findViewById(R.id.iconHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomNavigationView navigation =  findViewById(R.id.navigation);
                navigation.setOnNavigationItemSelectedListener(onNavigation);
                navigation.setSelectedItemId(R.id.navigation_reading);
            }
        });
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigation);
        navigation.setSelectedItemId(R.id.navigation_reading);
    }

    }

