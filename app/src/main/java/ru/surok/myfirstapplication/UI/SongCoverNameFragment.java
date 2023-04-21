package ru.surok.myfirstapplication.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import ru.surok.myfirstapplication.Domain.PlayingTrackViewModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentSongCoverNameBinding;

public class SongCoverNameFragment extends Fragment {

    private static int album_cover;
    private static String song_name;
    private FragmentSongCoverNameBinding binding;
    private PlayingTrackViewModel model;

    public SongCoverNameFragment() {
        super(R.layout.fragment_song_cover_name);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(getActivity())
                .get(PlayingTrackViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSongCoverNameBinding.inflate(inflater, container, false);
        model.getTrack().observe(getViewLifecycleOwner(), track ->{
            binding.songName.setText(track.getName());
            binding.albumImage.setImageResource(track.getImg());
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
