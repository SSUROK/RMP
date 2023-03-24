package ru.surok.myfirstapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import ru.surok.myfirstapplication.databinding.ActivityMainContraintBinding;
import ru.surok.myfirstapplication.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (savedInstanceState == null){
            Bundle args = getIntent().getExtras();
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.songCoverNameView, SongCoverNameFragment.class, args).commit();
        }

//        setContentView(R.layout.activity_second);
//        Bundle args = getIntent().getExtras();
//        getSupportFragmentManager().setFragmentResult("data_for_second_act", args);
    }
}