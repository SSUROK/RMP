package ru.surok.myfirstapplication.UI.VIewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.ListIterator;

import ru.surok.myfirstapplication.Data.Models.SongModel;
import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;

public class BottomPlayerViewModel extends ViewModel {

    private final TrackRepository trackRepository;

    private final MutableLiveData<SongModel> song;


    public BottomPlayerViewModel() {
        trackRepository = TrackRepository.getInstance();
        song = trackRepository.getCurrent();
    }

    public MutableLiveData<SongModel> getSong() {
        return song;
    }

    public void nextTrack(){
        trackRepository.nextTrack();
    }
}
