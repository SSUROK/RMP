package ru.surok.myfirstapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import ru.surok.myfirstapplication.databinding.ActivityMainContraintBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> startFotRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contraint);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        ImageView iv = (ImageView) findViewById(R.id.image);
//        iv.setImageResource(R.drawable.deathconsciousness);
//        TextView tv = (TextView) findViewById(R.id.textView);
//        tv.setText(R.string.tv_hint);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}