package ru.surok.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

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
        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle args = getIntent().getExtras();
        binding.albumImage.setImageResource((int) args.get("albumCover"));
        binding.songName.setText(args.get("songName").toString());

        binding.btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("songSkipped", "this song was boring");
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}