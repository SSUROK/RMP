package ru.surok.myfirstapplication.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import ru.surok.myfirstapplication.Domain.AudioBtViewModel;
import ru.surok.myfirstapplication.Domain.PlayingNextViewModel;
import ru.surok.myfirstapplication.Domain.PlayingTrackViewModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentAudioBtsBinding;

public class AudioBtFragment extends Fragment {

    private FragmentAudioBtsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAudioBtsBinding.inflate(inflater, container, false);
        binding.btNextPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_playingSong_to_playingNextFragment);
            }
        });
        PlayingTrackViewModel trackModel = new ViewModelProvider(getActivity())
                .get(PlayingTrackViewModel.class);
        binding.btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trackModel.nextTrack();
            }
        });
        binding.btPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trackModel.prevTrack();
            }
        });
        AudioBtViewModel model = new ViewModelProvider(this).get(AudioBtViewModel.class);
        binding.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.likeTrack();
            }
        });
        return binding.getRoot();
    }
}
