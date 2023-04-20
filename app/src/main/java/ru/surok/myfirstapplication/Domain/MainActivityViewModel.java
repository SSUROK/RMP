package ru.surok.myfirstapplication.Domain;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModel;

import ru.surok.myfirstapplication.R;

public class MainActivityViewModel extends ViewModel {

    private final int PERMISSION_REQUEST_CODE = 1111;

    private final Context context;
    private final Activity activity;

    public MainActivityViewModel(Activity activity){
        this.context = activity.getApplicationContext();
        this.activity = activity;
    }

    public void requestPermissions(){
        ActivityCompat.requestPermissions(activity, new String[] {
                Manifest.permission.POST_NOTIFICATIONS
        }, PERMISSION_REQUEST_CODE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(context)) {
                // send user to the device settings
                Intent myIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                context.startActivity(myIntent);
            }
        }
    }

    public void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = context.getString(R.string.CHANNEL_NAME);
            String description = context.getString(R.string.CHANNEL_DESCRIPTION);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(context.getString(R.string.CHANNEL_ID), name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
