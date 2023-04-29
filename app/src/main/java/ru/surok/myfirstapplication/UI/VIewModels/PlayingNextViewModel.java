package ru.surok.myfirstapplication.UI.VIewModels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;

public class PlayingNextViewModel extends ViewModel {
    private final TrackRepository trackRepository = new TrackRepository();

    private final MutableLiveData<LinkedList<SongModel>> songs;
    private final MutableLiveData<SongModel> current;

    public PlayingNextViewModel() {
        songs = trackRepository.getSongs();
        current = trackRepository.getCurrent();
    }

    public MutableLiveData<SongModel> getCurrent() {
        return current;
    }

    public MutableLiveData<LinkedList<SongModel>> getSongs() {
        return songs;
    }
}
