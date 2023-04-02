package ru.surok.myfirstapplication;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import ru.surok.myfirstapplication.databinding.ActivityMainContraintBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> startFotRes;

    private final int PERMISSION_REQUEST_CODE = 1111;
    private ActivityMainContraintBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainContraintBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createNotificationChannel();
        requestPermissions();
    }

    public void onClickCurrentTrack(View view){
        Intent intent = new Intent(this, PlayingSongActivity.class);
        intent.putExtra("album_cover", R.drawable.deathconsciousness);
        intent.putExtra("song_name", "Bloodhail");
        startActivity(intent);
    }

    public void requestPermissions(){
        ActivityCompat.requestPermissions(this, new String[] {
                Manifest.permission.POST_NOTIFICATIONS
        }, PERMISSION_REQUEST_CODE);
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.CHANNEL_NAME);
            String description = getString(R.string.CHANNEL_DESCRIPTION);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(getString(R.string.CHANNEL_ID), name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == PERMISSION_REQUEST_CODE && grantResults.length == 1){
//            if ()
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
}