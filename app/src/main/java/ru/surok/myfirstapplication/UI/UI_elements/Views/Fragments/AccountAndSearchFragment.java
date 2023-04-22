package ru.surok.myfirstapplication.UI.UI_elements.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.surok.myfirstapplication.UI.State_holders.VIewModels.PlayingTrackViewModel;
import ru.surok.myfirstapplication.R;
import ru.surok.myfirstapplication.databinding.FragmentAccountSearchBinding;

public class AccountAndSearchFragment extends Fragment {
    private FragmentAccountSearchBinding binding;
    private PlayingTrackViewModel searchViewModel;

    public AccountAndSearchFragment() {
        super(R.layout.fragment_account_search);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchViewModel = new ViewModelProvider(getActivity()).get(PlayingTrackViewModel.class);
        System.out.println(searchViewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAccountSearchBinding.inflate(inflater, container, false);
        binding.textEditFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchViewModel.setTrack(binding.textEditFind.getText().toString());
            }
        });
        return binding.getRoot();
    }
}
