package ru.surok.myfirstapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final int duration = Toast.LENGTH_SHORT;
    private static final String TAG = "Music app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contraint);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ImageView iv = (ImageView) findViewById(R.id.image);
        iv.setImageResource(R.drawable.deathconsciousness);
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(R.string.tv_hint);
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
        EditText et = (EditText)findViewById(R.id.textEdit_find);
        TextView tv = (TextView) findViewById(R.id.textView);
        ImageButton play_bt = findViewById(R.id.bt_play);
        Button playing_music_bt = findViewById(R.id.bt_playing_music);
        play_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = String.valueOf(et.getText());
                tv.setText(text);
                Log.i(TAG, "Новый текст");
            }
        });
    }

    public void onClickForPlaying(View view){
        Log.i(TAG, "А это кнопка для создания логов");
    }
}