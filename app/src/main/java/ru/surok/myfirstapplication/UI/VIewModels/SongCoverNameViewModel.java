package ru.surok.myfirstapplication.UI.VIewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;

public class SongCoverNameViewModel extends ViewModel {

    private final TrackRepository trackRepository;
    private final MutableLiveData<SongModel> current;

    public SongCoverNameViewModel() {
        trackRepository = new TrackRepository();
        current = trackRepository.getCurrent();
    }

    public MutableLiveData<SongModel> getCurrent() {
        return current;
    }
}
