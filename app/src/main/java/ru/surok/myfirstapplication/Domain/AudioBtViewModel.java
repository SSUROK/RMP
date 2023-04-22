package ru.surok.myfirstapplication.Domain;

import android.Manifest;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.DocumentsContract;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ru.surok.myfirstapplication.Data.SongDTO;
import ru.surok.myfirstapplication.Data.TrackRepository;
import ru.surok.myfirstapplication.R;

public class AudioBtViewModel extends AndroidViewModel {

    private TrackRepository trackRepository = TrackRepository.getInstance();

    public AudioBtViewModel(@NonNull Application application) {
        super(application);
    }

    public void likeTrack(){
        File app_specific_storage = getApplication().getApplicationContext().getFilesDir();
        SongDTO song = trackRepository.getCurrent();
        if(app_specific_storage.canWrite()){
            File licked_song = new File(app_specific_storage, "licked_song.txt");
            try (FileWriter fileWriter = new FileWriter(licked_song)){
                fileWriter.write(song.getName());
                fileWriter.write(song.getBand());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            showLickedNotification(song.getImg(), song.getName());
        }else System.out.println("cant write");
    }


    private void showLickedNotification(int img, String name){
        Bitmap icon = BitmapFactory.decodeResource(getApplication().getResources(), img);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplication(),
                getApplication().getString(R.string.CHANNEL_ID))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(icon)
                .setContentTitle("You licked it")
                .setContentText(name)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat
                .from(getApplication());
        if (ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.POST_NOTIFICATIONS)
                == PackageManager.PERMISSION_GRANTED) {
            notificationManager.notify(1, builder.build());
        }
    }


}
