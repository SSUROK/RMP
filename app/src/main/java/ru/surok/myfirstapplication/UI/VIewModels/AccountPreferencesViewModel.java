package ru.surok.myfirstapplication.UI.VIewModels;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.Map;

import ru.surok.myfirstapplication.R;

public class AccountPreferencesViewModel extends AndroidViewModel {
    private final SharedPreferences sharedPreferences;

    public AccountPreferencesViewModel(@NonNull Application application) {
        super(application);
        sharedPreferences = getApplication().getSharedPreferences(
                getApplication().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    public void SavePref(int key, boolean bool){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(getApplication().getString(key), bool);
        editor.apply();
    }

    public SharedPreferences getSharedPreferences(){
        return sharedPreferences;
    }

    public boolean getPref(int key){
        return sharedPreferences.getBoolean(getApplication().getString(key), false);
    }
}
