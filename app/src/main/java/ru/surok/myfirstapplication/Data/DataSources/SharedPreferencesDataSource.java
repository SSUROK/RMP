package ru.surok.myfirstapplication.Data.DataSources;

import android.content.Context;
import android.content.SharedPreferences;

import ru.surok.myfirstapplication.R;

public class SharedPreferencesDataSource {

    private final Context context;
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesDataSource(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    public void SavePref(int key, boolean bool){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getString(key), bool);
        editor.apply();
    }

    public boolean getPref(int key){
        return sharedPreferences.getBoolean(context.getString(key), false);
    }
}
