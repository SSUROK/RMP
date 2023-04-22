package ru.surok.myfirstapplication.UI.UI_elements.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import ru.surok.myfirstapplication.Domain.ListsFillerUseCase;
import ru.surok.myfirstapplication.UI.State_holders.Adapters.MyListViewAdapter;
import ru.surok.myfirstapplication.UI.State_holders.VIewModels.PlayingNextViewModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentPlayingNextBinding;

public class PlayingNextFragment extends Fragment {
    private final int duration = Toast.LENGTH_SHORT;
    private static final String TAG = "Music app top fragment";


    public PlayingNextFragment() {
        super(R.layout.fragment_playing_next);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPlayingNextBinding binding = FragmentPlayingNextBinding.inflate(inflater,
                container, false);
        ListsFillerUseCase lf = new ListsFillerUseCase();
        PlayingNextViewModel pnvm = new ViewModelProvider(this)
                .get(PlayingNextViewModel.class);
        MyListViewAdapter adapter =
                new MyListViewAdapter(getActivity(), R.layout.custom_list_view, pnvm.getNextSongs());
        binding.playingNextList.setAdapter(adapter);

        binding.playingNextList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}