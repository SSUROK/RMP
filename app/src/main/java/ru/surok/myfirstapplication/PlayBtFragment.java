package ru.surok.myfirstapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import ru.surok.myfirstapplication.databinding.ActivityMainContraintBinding;

public class PlayBtFragment extends Fragment {

    public PlayBtFragment() {
        super(R.layout.play_bt_fragment);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = view.findViewById(R.id.textView);
        tv.setText(R.string.hint_tv);
        ImageButton bt_play = view.findViewById(R.id.bt_play);
        bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Button pressed");
            }
        });

        getParentFragmentManager().setFragmentResultListener("data_for_playbt_text",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        tv.setText(result.getString("text"));
                    }
                });
    }
}
