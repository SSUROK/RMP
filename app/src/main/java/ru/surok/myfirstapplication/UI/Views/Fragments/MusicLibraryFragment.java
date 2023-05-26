package ru.surok.myfirstapplication.UI.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.TransitionInflater;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Domain.ListSongModelToListListItem;
import ru.surok.myfirstapplication.Domain.ListsFillerUseCase;
import ru.surok.myfirstapplication.UI.Adapters.MusicLibraryAdapter;
import ru.surok.myfirstapplication.UI.Adapters.MyRecyclerViewAdapter;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.UI.VIewModels.SongLibraryViewModel;
import ru.surok.myfirstapplication.databinding.FragmentMusicLibraryBinding;

public class MusicLibraryFragment extends Fragment implements MusicLibraryAdapter.clickInterface {

    public MusicLibraryFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater =
                TransitionInflater.from(requireContext());
        setEnterTransition(inflater.inflateTransition(R.transition.slide_bottom));
        setExitTransition(inflater.inflateTransition(R.transition.slide_bottom));
//        setReenterTransition(inflater.inflateTransition(R.transition.slide_left));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMusicLibraryBinding binding = FragmentMusicLibraryBinding.inflate(inflater, container, false);
        SongLibraryViewModel model = new ViewModelProvider(this).get(SongLibraryViewModel.class);
        MusicLibraryAdapter adapter = new MusicLibraryAdapter(getContext(), R.layout.custom_list_view);
        adapter.setClickInterface(this);
        model.getSongs().observe(getViewLifecycleOwner(), songs ->{
            ((MusicLibraryAdapter) binding.musicLibraryList.getAdapter())
                    .updateData(ListSongModelToListListItem.changeToList(songs));
        });
        binding.musicLibraryList.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onClick(SongModel sm) {
        System.out.println(sm.getName());
    }
}
