package ru.surok.myfirstapplication.UI;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import ru.surok.myfirstapplication.Domain.GetBackService;
import ru.surok.myfirstapplication.Domain.OnStartTasks;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private OnStartTasks ost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ost = new OnStartTasks(this);
        ost.requestPermissions();
        ost.createNotificationChannel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent serviceIntent = new Intent(this, GetBackService.class);
        startService(serviceIntent);
    }
}