package ru.surok.myfirstapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.surok.myfirstapplication.databinding.FragmentMainPageBinding;

public class MainPage extends Fragment {

    public MainPage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainPageBinding binding = FragmentMainPageBinding.inflate(inflater, container, false);
        binding.playingTrackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("song_name", "Bloodhail");
                bundle.putInt("album_cover", R.drawable.deathconsciousness);
                Navigation.findNavController(view).navigate(R.id.action_mainPage_to_playingSong, bundle);
            }
        });
        return binding.getRoot();
    }
}