package ru.surok.myfirstapplication.UI.UI_elements.Views.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.Navigation;

import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentAudioBtsBinding;

public class AudioBtFragment extends Fragment {

    private FragmentAudioBtsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAudioBtsBinding.inflate(inflater, container, false);
        binding.btNextPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_playingSong_to_playingNextFragment);
            }
        });
        return binding.getRoot();
    }
}
