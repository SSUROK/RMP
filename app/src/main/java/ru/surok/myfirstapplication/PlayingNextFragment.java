package ru.surok.myfirstapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.surok.myfirstapplication.databinding.FragmentPlayingNextBinding;

public class PlayingNextFragment extends Fragment {
    private final int duration = Toast.LENGTH_SHORT;
    private static final String TAG = "Music app top fragment";
    private MyListViewAdapter adapter;

    public PlayingNextFragment() {
        super(R.layout.fragment_playing_next);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentPlayingNextBinding binding = FragmentPlayingNextBinding.inflate(inflater, container, false);
        adapter = new MyListViewAdapter(getActivity(), R.layout.custom_list_view, generateList());
        binding.playingNextList.setAdapter(adapter);

        binding.playingNextList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CharSequence text = "List clicked toast";
                Context context = getActivity().getApplicationContext();
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Log.i(TAG, "List item clicked instance");
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private List<Item> generateList(){
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 200; i++){
            list.add(new Item(R.drawable.deathconsciousness, "Sample text"));
        }
        return list;
    }
}