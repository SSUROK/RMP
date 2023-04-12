package ru.surok.myfirstapplication.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.UI.AudioBtFragment;
import ru.surok.myfirstapplication.UI.SongCoverNameFragment;
import ru.surok.myfirstapplication.databinding.FragmentPlayingSongBinding;

public class PlayingSongFragment extends Fragment {

    private String songName;
    private int albumCover;

    public PlayingSongFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            songName = getArguments().getString("song_name");
            albumCover = getArguments().getInt("song_cover");
            getChildFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.songCoverNameView, SongCoverNameFragment.class, getArguments())
                    .add(R.id.trackPlaySkipBtView, AudioBtFragment.class, null)
                    .commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPlayingSongBinding binding = FragmentPlayingSongBinding.inflate(inflater, container, false);
        return inflater.inflate(R.layout.fragment_playing_song, container, false);
    }
}