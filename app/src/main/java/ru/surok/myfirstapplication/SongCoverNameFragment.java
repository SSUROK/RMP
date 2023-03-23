package ru.surok.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import ru.surok.myfirstapplication.databinding.ActivitySecondBinding;
import ru.surok.myfirstapplication.databinding.SongCoverNameFragmentBinding;

public class SongCoverNameFragment extends Fragment {

    private static int album_cover;
    private static String song_name;

    public SongCoverNameFragment() {
        super(R.layout.song_cover_name_fragment);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("data_for_second_act",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        album_cover = result.getInt("album_cover");
                        song_name = result.getString("song_name");
                    }
                });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = view.findViewById(R.id.song_name);
        ImageView iv = view.findViewById(R.id.album_Image);
        tv.setText(song_name);
        iv.setImageResource(album_cover);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
