package ru.surok.myfirstapplication.UI.Views.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.UI.VIewModels.AudioBtViewModel;
import ru.surok.myfirstapplication.databinding.FragmentAudioBtsBinding;

public class AudioBtFragment extends Fragment {

    private FragmentAudioBtsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAudioBtsBinding.inflate(inflater, container, false);
        AudioBtViewModel model = new ViewModelProvider(this).get(AudioBtViewModel.class);
        binding.btNextPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_playingSong_to_playingNextFragment);
            }
        });
        AudioBtViewModel trackModel = new ViewModelProvider(this)
                .get(AudioBtViewModel.class);
        binding.btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trackModel.nextTrack();
            }
        });
        binding.btPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trackModel.prevTrack();
            }
        });
        binding.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                model.likeTrack();
                createFile();
            }
        });
        binding.btNext.setOnClickListener(v->{
            model.nextTrack();
        });

        binding.btPrev.setOnClickListener(v->{
            model.prevTrack();
        });
        return binding.getRoot();
    }

    private void createFile() {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TITLE, "invoice.txt");

        // Optionally, specify a URI for the directory that should be opened in
        // the system file picker when your app creates the document.
//        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);

        startActivity(intent);
    }
}
