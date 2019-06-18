package com.example.quran.Base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.afollestad.materialdialogs.MaterialDialog;

public class BaseFragment extends Fragment {

    Context context;
    BaseActivity base;
MaterialDialog dialog;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        base=(BaseActivity) context;

    }
    public MaterialDialog showMessage(int titile , int content , int onpositive)
    {
        return base.showMessage(titile,content,onpositive);
    }

    public MaterialDialog showMessage(String titile , String content , String onpositive)
    {
        return base.showMessage(titile,content,onpositive);
    }

    public MaterialDialog ConfirmatonMessage(int title , int content , int onpositive, MaterialDialog.SingleButtonCallback onpositiveclick, int onnegative, MaterialDialog.SingleButtonCallback onnegativeclick)
    {
        return base.ConfirmatonMessage(title,content,onpositive,onpositiveclick,onnegative,onnegativeclick);

    }
    public  MaterialDialog showProgressBar()

    {
        dialog=new MaterialDialog.Builder(getActivity()).progress(true ,0).cancelable(false).show();
        return dialog;
    }
    public void hideProgress()

    {

        if(dialog!=null&&dialog.isShowing())
        {
            dialog.dismiss();
        }
    }



}
