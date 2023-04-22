package ru.surok.myfirstapplication.UI.UI_elements.Views.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.surok.myfirstapplication.UI.State_holders.VIewModels.PlayingTrackViewModel;
import ru.surok.myfirstapplication.UI.State_holders.Service.PlayMusicService;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentPlayBtBinding;

public class PlayBtFragment extends Fragment {

    private FragmentPlayBtBinding binding;
    private Intent serviceIntent;
    private PlayingTrackViewModel searchViewModel;

    public PlayBtFragment() {
        super(R.layout.fragment_play_bt);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchViewModel = new ViewModelProvider(this).get(PlayingTrackViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPlayBtBinding.inflate(inflater, container,
                false);

        binding.btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serviceIntent = new Intent(getActivity(), PlayMusicService.class);
                getActivity().startService(serviceIntent);
                searchViewModel.setTrack("Hello");
            }
        });

        return binding.getRoot();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        if (serviceIntent != null)
            getActivity().stopService(serviceIntent);
    }
}
