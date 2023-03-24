package ru.surok.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import ru.surok.myfirstapplication.databinding.ActivitySecondBinding;
import ru.surok.myfirstapplication.databinding.SongCoverNameFragmentBinding;

public class SongCoverNameFragment extends Fragment {

    private static int album_cover;
    private static String song_name;
    private SongCoverNameFragmentBinding binding;

    public SongCoverNameFragment() {
        super(R.layout.song_cover_name_fragment);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments(); if (bundle != null) {
            album_cover = bundle.getInt("album_cover");
            song_name = bundle.getString("song_name");
        }
//        getParentFragmentManager().setFragmentResultListener("data_for_second_act",
//                this, new FragmentResultListener() {
//                    @Override
//                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
//                        album_cover = result.getInt("album_cover");
//                        song_name = result.getString("song_name");
//                    }
//                });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SongCoverNameFragmentBinding.inflate(inflater, container, false);
        binding.songName.setText(song_name);
        binding.albumImage.setImageResource(album_cover);
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
