package ru.surok.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlayingMusicFragment extends Fragment {

    public PlayingMusicFragment() {
        super(R.layout.playing_music_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button ib = view.findViewById(R.id.bt_playing_music);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("album_cover", R.drawable.deathconsciousness);
                bundle.putString("song_name", "Bloodhail");
                getParentFragmentManager().setFragmentResult("data_for_second_act", bundle);
                startActivity(intent);
            }
        });
    }
}
