package ru.surok.myfirstapplication.UI.VIewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import ru.surok.myfirstapplication.Data.Repositories.PostAPIRepository;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;

public class MainActivityViewModel extends AndroidViewModel {

    private final TrackRepository trackRepository;
    private final PostAPIRepository postAPIRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        trackRepository = TrackRepository.getInstance(application);
        postAPIRepository = new PostAPIRepository();
//        trackRepository.addSong(new SongModel("mock song", "mock band", 0));
    }

    public void createNotificationChannel() {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Runnable createNotifChannel = () -> {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                CharSequence name = getApplication().getString(R.string.CHANNEL_NAME);
//                String description = getApplication().getString(R.string.CHANNEL_DESCRIPTION);
//                int importance = NotificationManager.IMPORTANCE_DEFAULT;
//                NotificationChannel channel = new NotificationChannel(getApplication().getString(R.string.CHANNEL_ID), name, importance);
//                channel.setDescription(description);
//                NotificationManager notificationManager = getApplication().getSystemService(NotificationManager.class);
//                notificationManager.createNotificationChannel(channel);
//            }
//        };
//        executorService.execute(createNotifChannel);
//        executorService.shutdown();
    }

    public void deleteDB(){
        trackRepository.deleteDB(getApplication());
    }

    public void getAllPosts(){
        postAPIRepository.getAllPosts();
    }
}
