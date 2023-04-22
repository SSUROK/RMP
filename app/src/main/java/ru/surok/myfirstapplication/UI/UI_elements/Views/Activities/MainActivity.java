package ru.surok.myfirstapplication.UI.UI_elements.Views.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.surok.myfirstapplication.UI.State_holders.VIewModels.MainActivityViewModel;
import ru.surok.myfirstapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        model = new MainActivityViewModel(this);
        model.requestPermissions();
        model.createNotificationChannel();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Intent serviceIntent = new Intent(this, GetBackService.class);
//        startService(serviceIntent);
    }
}