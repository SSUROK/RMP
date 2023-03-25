package ru.surok.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import ru.surok.myfirstapplication.databinding.ActivityMainContraintBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> startFotRes;
    private ActivityMainContraintBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainContraintBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void onClickCurrentTrack(View view){
        Intent intent = new Intent(this, PlayingSongActivity.class);
        intent.putExtra("album_cover", R.drawable.deathconsciousness);
        intent.putExtra("song_name", "Bloodhail");
        startActivity(intent);
    }
}