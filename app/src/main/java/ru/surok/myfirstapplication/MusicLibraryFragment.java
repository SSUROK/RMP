package ru.surok.myfirstapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

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
        adapter = new MyRecyclerViewAdapter(getActivity(), R.layout.custom_list_view,generateList());
        binding.songLibraryList.setAdapter(adapter);

        return binding.getRoot();
    }

    private List<Item> generateList(){
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 200; i++){
            list.add(new Item(R.drawable.deathconsciousness, "Sample text"));
        }
        return list;
    }
}
