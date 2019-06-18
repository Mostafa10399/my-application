package com.example.quran.Base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class BaseActivity extends AppCompatActivity
{
    MaterialDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public MaterialDialog showMessage(String titile ,String content ,String onpositive)
    {
        dialog=new MaterialDialog.Builder(this).title(titile).content(content).positiveText(onpositive).onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
            }
        }).show();
        return dialog;
    }

    public MaterialDialog showMessage(int titile ,int content ,int onpositive)
    {
        dialog=new MaterialDialog.Builder(this).title(titile).content(content).positiveText(onpositive).onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
            }
        }).show();
        return dialog;
    }
    public MaterialDialog ConfirmatonMessage(int title , int content , int onpositive, MaterialDialog.SingleButtonCallback onpositiveclick, int onnegative, MaterialDialog.SingleButtonCallback onnegativeclick)
    {
        dialog=new MaterialDialog.Builder(this).title(title).content(content).positiveText(onpositive).onPositive(onpositiveclick).negativeText(onnegative).onNegative(onnegativeclick).show();
        return dialog;
    }
    public  MaterialDialog showProgressBar()

    {
        dialog=new MaterialDialog.Builder(this).progress(true ,0).cancelable(false).show();
        return dialog;
    }
    public void hideProgress()

    {

        if(dialog!=null&&dialog.isShowing())
        {
            dialog.dismiss();
        }
    }

    public MaterialDialog ConfirmatonMessage2(int title , int content , int onpositive, MaterialDialog.SingleButtonCallback onpositiveclick)
    {
        dialog=new MaterialDialog.Builder(this).title(title).content(content).positiveText(onpositive).onPositive(onpositiveclick).show();
        return dialog;
    }




}
