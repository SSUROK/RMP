package ru.surok.myfirstapplication.Domain;

import android.Manifest;
import android.content.pm.PackageManager;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.surok.myfirstapplication.Data.PlayingTrackRepository;
import ru.surok.myfirstapplication.R;

public class PlayBtViewModel extends ViewModel {

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
