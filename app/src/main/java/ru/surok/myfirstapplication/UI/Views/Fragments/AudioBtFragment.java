package ru.surok.myfirstapplication.UI.Views.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.UI.VIewModels.AudioBtViewModel;
import ru.surok.myfirstapplication.databinding.FragmentAudioBtsBinding;

public class AudioBtFragment extends Fragment {

    private FragmentAudioBtsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAudioBtsBinding.inflate(inflater, container, false);
        AudioBtViewModel model = new ViewModelProvider(this).get(AudioBtViewModel.class);
        binding.btNextPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_playingSong_to_playingNextFragment);
            }
        });
        binding.btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.nextTrack();
            }
        });
        binding.btPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.prevTrack();
            }
        });
        binding.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                model.likeTrack();
//                createFile();
            }
        });

        binding.btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SongModel song = model.getSong().getValue();
//                if (song != null){
//                    Uri songUri = Uri.parse(String.format("spotify:search:name=%s,band=%s", song.getName(), song.getBand()));
//                    Intent sendIntent = new Intent(Intent.ACTION_VIEW, songUri);
//                    Intent shareIntent = Intent.createChooser(sendIntent, null);
//                    startActivity(shareIntent);
//                }
                if (song != null) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, String.format(
                            "Check out this cool song %s by %s", song.getName(), song.getBand()));
                    sendIntent.setType("text/plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                }
            }
        });
        return binding.getRoot();
    }


}
