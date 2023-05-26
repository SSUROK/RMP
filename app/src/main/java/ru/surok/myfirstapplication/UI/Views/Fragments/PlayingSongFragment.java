package ru.surok.myfirstapplication.UI.Views.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.transition.TransitionInflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentPlayingSongBinding;


public class PlayingSongFragment extends Fragment {

    private String songName;
    private int albumCover;

    public PlayingSongFragment() {
        super(R.layout.fragment_playing_song);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater =
                TransitionInflater.from(requireContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slide_right));
        setExitTransition(inflater.inflateTransition(R.transition.slide_left));
//        setExitTransition(inflater.inflateTransition(R.transition.slide_top));
//        getChildFragmentManager().beginTransaction().setReorderingAllowed(true)
//                .add(R.id.songCoverNameView, SongCoverNameFragment.class, null)
//                .add(R.id.trackPlaySkipBtView, AudioBtFragment.class, null)
//                .commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPlayingSongBinding binding = FragmentPlayingSongBinding.inflate(inflater, container,
                false);
        return binding.getRoot();
    }
}