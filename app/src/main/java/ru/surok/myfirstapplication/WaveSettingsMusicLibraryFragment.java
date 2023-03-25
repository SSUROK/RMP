package ru.surok.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.surok.myfirstapplication.databinding.FragmentWaveSettingsMusicLibraryBinding;

public class WaveSettingsMusicLibraryFragment extends Fragment {

    private FragmentWaveSettingsMusicLibraryBinding binding;

    public WaveSettingsMusicLibraryFragment() {
        super(R.layout.fragment_wave_settings_music_library);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentWaveSettingsMusicLibraryBinding.inflate(inflater, container, false);
        binding.btMusicLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent = new Intent(getActivity(), SongLibraryActivity.class);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
