package ru.surok.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import ru.surok.myfirstapplication.databinding.FragmentAudioBtsBinding;

public class AudioBtFragment extends Fragment {

    private FragmentAudioBtsBinding binding;

    public AudioBtFragment() {
        super(R.layout.fragment_audio_bts);
    }

    public void onClickForPlaying(View view){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAudioBtsBinding.inflate(inflater, container, false);
//        binding.btNextPlaying.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentContainerView fcv =  view.findViewById(R.id.playingNextContainerView);
//                fcv.setVisibility(View.VISIBLE);
//            }
//        });
        binding.btNextPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlayingNextActivity.class);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }
}
