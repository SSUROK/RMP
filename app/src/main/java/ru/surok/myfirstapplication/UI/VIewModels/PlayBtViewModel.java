package ru.surok.myfirstapplication.UI.VIewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.util.List;

import ru.surok.myfirstapplication.Data.DataSources.Retrofit.SongModelAPI;
import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.PostAPIRepository;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;
import ru.surok.myfirstapplication.R;

public class PlayBtViewModel extends AndroidViewModel {

    private final TrackRepository trackRepository;
    private final PostAPIRepository postAPIRepository;
    private final WorkManager workManager;
    private LiveData<SongModel> songFromDB = new MutableLiveData<>();
    public PlayBtViewModel(@NonNull Application application) {
        super(application);
        postAPIRepository = new PostAPIRepository();
        trackRepository = TrackRepository.getInstance(application);
        songFromDB = trackRepository.getSongFromDB("Song A", "Band A");
        workManager = WorkManager.getInstance(getApplication());

    }

    public LiveData<SongModel> getSong(){
        return songFromDB;
    }

    private Data createInputDataFromUri(){
        Data.Builder builder = new Data.Builder();
        builder.putInt(String.valueOf(R.string.KEY_MUSIC_URI), R.raw.song);
        return builder.build();
    }

    public void play(){
//        OneTimeWorkRequest bassRequest =
//                new OneTimeWorkRequest.Builder(BassBoostWorker.class)
//                        .setInputData(createInputDataFromUri())
//                        .build();
//        workManager.enqueue(bassRequest);

        postAPIRepository.addSong(new SongModelAPI(123, 123, "TITLE", "IJBWHVKVJEVNB3KVEVKELVKMNK"));
    }

    //    private void showPlayingSongNotification(){
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(),
//                getString(R.string.CHANNEL_ID))
//                .setSmallIcon(R.drawable.ic_launcher_foreground)
//                .setContentTitle(getString(R.string.next_track))
//                .setContentText(binding.playBtTextview.getText())
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//        NotificationManagerCompat notificationManager = NotificationManagerCompat
//                .from(getActivity());
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.POST_NOTIFICATIONS)
//                == PackageManager.PERMISSION_GRANTED) {
//            notificationManager.notify(1, builder.build());
//        }
//    }

}
