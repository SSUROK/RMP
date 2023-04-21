package ru.surok.myfirstapplication.Domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.surok.myfirstapplication.Data.SongModel;
import ru.surok.myfirstapplication.Data.TrackRepository;

public class PlayingTrackViewModel extends ViewModel {

    private final TrackRepository trackRepository = TrackRepository.getInstance();

    private final MutableLiveData<SongModel> track =
            new MutableLiveData<>(new SongModel(trackRepository.nextTrack()));

    public LiveData<SongModel> getTrack(){
        return track;
    }

    public void nextTrack(){
        track.setValue(new SongModel(trackRepository.nextTrack()));
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
