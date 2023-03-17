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
    private final int duration = Toast.LENGTH_SHORT;
    private static final String TAG = "Music app";
    private ActivityResultLauncher<Intent> startFotRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainContraintBinding binding = ActivityMainContraintBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView.setText(R.string.hint_tv);
        binding.image.setImageResource(R.drawable.deathconsciousness);

        binding.btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = String.valueOf(binding.textEditFind.getText());
                binding.textView.setText(text);
                Log.i(TAG, "Новый текст");
            }
        });

        startFotRes = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Intent intent1 = result.getData();
                            TextView tv = (TextView) findViewById(R.id.textView);
                            tv.setText(intent1.getStringExtra("songSkipped"));
                        }
                    }
                }
        );
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

    public void onClickForPlaying(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("albumCover", R.drawable.deathconsciousness);
        EditText et = findViewById(R.id.textEdit_find);
        intent.putExtra("songName", et.getText());
        startFotRes.launch(intent);
    }
}