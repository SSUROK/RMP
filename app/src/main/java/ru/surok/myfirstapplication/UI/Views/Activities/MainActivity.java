package ru.surok.myfirstapplication.UI.Views.Activities;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.UI.VIewModels.MainActivityViewModel;
import ru.surok.myfirstapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel model;

    private final int PERMISSION_REQUEST_CODE = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        requestPermissions();
        model.createNotificationChannel();
        model.getAllPosts();
    }

    public void requestPermissions(){
        Callable<String> requestingPerms = ()-> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.POST_NOTIFICATIONS,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.SYSTEM_ALERT_WINDOW,
                        Manifest.permission.INTERNET
                }, PERMISSION_REQUEST_CODE);
                return "perms requested";
            } else return "Perms not requested";
        };
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.INTERNET
        }, PERMISSION_REQUEST_CODE);
        Callable<String> requestingOverlay = ()-> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    // send user to the device settings
                    Intent myIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    startActivity(myIntent);
                    return "Requested";
                }
            }
            return "Overlay weren't requested";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            List<Future<String>> futures = executorService.invokeAll(
                    new ArrayList<>(Arrays.asList(requestingOverlay, requestingPerms)));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        model.deleteDB();
    }
}