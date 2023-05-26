package ru.surok.myfirstapplication.UI.VIewModels;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.audiofx.Equalizer;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.IOException;

import ru.surok.myfirstapplication.R;

public class BassBoostWorker extends Worker {
    public BassBoostWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        int resourceUri = getInputData().getInt(String.valueOf(R.string.KEY_MUSIC_URI), 0);
        try {
        MediaPlayer mediaPlayer = MediaPlayer.create(this.getApplicationContext(), resourceUri);
        Equalizer equalizer = new Equalizer(0, mediaPlayer.getAudioSessionId());

// Configure the equalizer.
        equalizer.setBandLevel((short) 0, (short) 3);
        equalizer.setBandLevel((short) 1, (short) 3);
        equalizer.setBandLevel((short) 2, (short) 3);
        equalizer.setEnabled(true);

        mediaPlayer.start();
        return Result.success();
        } catch (Throwable e) {
            Log.e("BassBoostWorker", String.valueOf(e));
            return Result.failure();
        }
    }
}
