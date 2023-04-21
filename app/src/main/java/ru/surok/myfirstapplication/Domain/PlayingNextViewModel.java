package ru.surok.myfirstapplication.Domain;

import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.surok.myfirstapplication.Data.ListItem;
import ru.surok.myfirstapplication.Data.TrackRepository;

public class PlayingNextViewModel extends ViewModel {
    private final TrackRepository trackRepository = TrackRepository.getInstance();

    public List<ListItem> getNextSongs(){
        return trackRepository.getNextSongs();
    }
}
