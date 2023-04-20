package ru.surok.myfirstapplication.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.surok.myfirstapplication.Domain.PlayingTrackViewModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentBottomPlayerBinding;

public class BottomPlayerFragment extends Fragment {

    private PlayingTrackViewModel model;

    public BottomPlayerFragment() {
        super(R.layout.fragment_bottom_player);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(getActivity()).get(PlayingTrackViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentBottomPlayerBinding binding = FragmentBottomPlayerBinding.inflate(inflater, container,
                false);
        model.getTrack().observe(getViewLifecycleOwner(), track ->{
            binding.songCover.setImageResource(track.getImg());
            binding.songName.setText(track.getName());
            binding.songBand.setText(track.getBand());
        });
        binding.btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(model.getTrack().getValue().getName());
            }
        });
        return binding.getRoot();
    }
}
