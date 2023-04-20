package ru.surok.myfirstapplication.Domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.surok.myfirstapplication.Data.PlayingTrackRepository;

public class PlayingTrackViewModel extends ViewModel {

    private final MutableLiveData<PlayingTrackRepository> track =
            new MutableLiveData<>(new PlayingTrackRepository());

    public LiveData<PlayingTrackRepository> getTrack(){
        return track;
    }

    public void nextTrack(){

    }

    public void setTrack(String name){
        track.setValue(
                new PlayingTrackRepository(
                        name,
                        track.getValue().getBand(),
                        track.getValue().getDescription(),
                        track.getValue().getImg(),
                        track.getValue().getTime()
                ));
    }
}
