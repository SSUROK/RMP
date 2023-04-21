package ru.surok.myfirstapplication.Domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.surok.myfirstapplication.Data.SongModel;
import ru.surok.myfirstapplication.Data.TrackRepository;

public class PlayingTrackViewModel extends ViewModel {

    private final TrackRepository trackRepository = TrackRepository.getInstance();

    private final MutableLiveData<SongModel> track =
            new MutableLiveData<>(new SongModel(trackRepository.getCurrent()));

    public LiveData<SongModel> getTrack(){
        return track;
    }

    public void nextTrack(){
        trackRepository.nextTrack();
        track.setValue(new SongModel(trackRepository.getCurrent()));
    }

    public void prevTrack(){
        trackRepository.prevTrack();
        track.setValue(new SongModel(trackRepository.getCurrent()));
    }

    public void setTrack(String name){
        track.setValue(
                new SongModel(
                        name,
                        track.getValue().getBand(),
                        track.getValue().getImg()
                ));
    }
}
