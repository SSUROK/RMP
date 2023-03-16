package ru.surok.myfirstapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final int duration = Toast.LENGTH_SHORT;
    private static final String TAG = "Toasted app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contraint);

        CharSequence text = "onCreate toast";
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "creating instance");
    }

    @Override
    protected void onStart() {
        super.onStart();

        CharSequence text = "onStart toast";
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Log.i(TAG, "starting instance");
    }

    @Override
    protected void onStop() {
        super.onStop();

        CharSequence text = "onStop toast";
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Log.i(TAG, "stoping instance");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        CharSequence text = "onDestroy toast";
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Log.i(TAG, "destroying instance");
    }

    @Override
    protected void onPause() {
        super.onPause();

        CharSequence text = "onPause toast";
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Log.i(TAG, "pausing instance");
    }

    @Override
    protected void onResume() {
        super.onResume();

        CharSequence text = "onResume toast";
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Log.i(TAG, "resuming instance");
    }
}