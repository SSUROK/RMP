package ru.surok.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PlayingSongActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_song);
        if (savedInstanceState == null){
            PlayingNextFragment f = new PlayingNextFragment();
            Bundle args = getIntent().getExtras();
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.songCoverNameView, SongCoverNameFragment.class, args)
                    .commit();
        }

//        setContentView(R.layout.activity_second);
//        Bundle args = getIntent().getExtras();
//        getSupportFragmentManager().setFragmentResult("data_for_second_act", args);
    }
}