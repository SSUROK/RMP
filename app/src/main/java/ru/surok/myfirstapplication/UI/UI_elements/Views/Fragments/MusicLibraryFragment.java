package ru.surok.myfirstapplication.UI.UI_elements.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.surok.myfirstapplication.Domain.ListsFillerUseCase;
import ru.surok.myfirstapplication.UI.State_holders.Adapters.MyRecyclerViewAdapter;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentMusicLibraryBinding;

public class MusicLibraryFragment extends Fragment {

    private MyRecyclerViewAdapter adapter;

    public MusicLibraryFragment() {
        super(R.layout.fragment_music_library);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMusicLibraryBinding binding = FragmentMusicLibraryBinding.inflate(inflater, container, false);
        ListsFillerUseCase lf = new ListsFillerUseCase();
        adapter = new MyRecyclerViewAdapter(getActivity(), R.layout.custom_list_view, lf.generateList());
        binding.songLibraryList.setAdapter(adapter);

        return binding.getRoot();
    }
}
