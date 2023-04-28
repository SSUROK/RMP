package ru.surok.myfirstapplication.UI.VIewModels;

import androidx.lifecycle.ViewModel;

import ru.surok.myfirstapplication.Data.Repositories.TrackRepository;

public class AudioBtViewModel extends ViewModel {
    private final TrackRepository trackRepository = TrackRepository.getInstance();

    public void nextTrack(){
        trackRepository.nextTrack();
    }

    public void prevTrack(){
        trackRepository.prevTrack();
    }
}
