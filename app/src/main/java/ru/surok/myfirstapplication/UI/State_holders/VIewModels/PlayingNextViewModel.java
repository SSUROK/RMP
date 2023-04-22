package ru.surok.myfirstapplication.UI.State_holders.VIewModels;

import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;

public class PlayingNextViewModel extends ViewModel {
    private final TrackRepository trackRepository = TrackRepository.getInstance();

    public List<ListItem> getNextSongs(){
        return trackRepository.getNextSongs();
    }
}
