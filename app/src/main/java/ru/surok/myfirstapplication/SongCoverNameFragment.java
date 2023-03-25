package ru.surok.myfirstapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.surok.myfirstapplication.databinding.FragmentSongCoverNameBinding;

public class SongCoverNameFragment extends Fragment {

    private static int album_cover;
    private static String song_name;
    private FragmentSongCoverNameBinding binding;

    public SongCoverNameFragment() {
        super(R.layout.fragment_song_cover_name);
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
        binding = FragmentSongCoverNameBinding.inflate(inflater, container, false);
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
