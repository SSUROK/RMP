package ru.surok.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlayingSongActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_song);
        if (savedInstanceState == null){
            Bundle args = getIntent().getExtras();
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.songCoverNameView, SongCoverNameFragment.class, args)
                    .commit();
        }

//        setContentView(R.layout.activity_second);
//        Bundle args = getIntent().getExtras();
//        getSupportFragmentManager().setFragmentResult("data_for_second_act", args);
    }

    public void onClickCurrentTrack(View view){
        Intent intent = new Intent(this, PlayingSongActivity.class);
        intent.putExtra("album_cover", R.drawable.deathconsciousness);
        intent.putExtra("song_name", "Bloodhail");
        startActivity(intent);
    }
}