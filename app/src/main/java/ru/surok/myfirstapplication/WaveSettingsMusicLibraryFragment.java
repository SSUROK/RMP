package ru.surok.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WaveSettingsMusicLibraryFragment extends Fragment {

    public WaveSettingsMusicLibraryFragment() {
        super(R.layout.wave_settings_music_library_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button ib = view.findViewById(R.id.bt_playing_music);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("album_cover", R.drawable.deathconsciousness);
                intent.putExtra("song_name", "Bloodhail");
                startActivity(intent);
            }
        });

    }
}
