package com.example.SharedPrefencesFolder;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.Edutec.R;


public class SPOnceInstalled  {
    Context context;
    SharedPreferences sharedPreferences;
    public SPOnceInstalled(Context context) {
        this.context=context;
        getSPrefencesForInstalled();
    }

    public void getSPrefencesForInstalled() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_FILE",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
    }

    public void writeInstalled(){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("ALREADY_INSTALLED","YES");
        editor.apply();
    }


    public boolean checkingInstalled(){
        boolean status=false;
        if (sharedPreferences.getString(context.getString(R.string.alreadyINstalled),"null").equals("null")){
            status=false;
        }else {
            status=true;
        }
        return status;

    }

    public void eraseInstalled(){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

}
