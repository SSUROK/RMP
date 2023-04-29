package ru.surok.myfirstapplication.Data.Repositories;

import android.os.Build;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.DataSources.SongsDataSource;
import ru.surok.myfirstapplication.Data.Models.SongModel;

public class TrackRepository {

    private final SongsDataSource songsDataSource;

    public TrackRepository() {
        songsDataSource = new SongsDataSource();
    }

    public void nextTrack(){
        songsDataSource.nextTrack();
    }

    public void prevTrack(){
        songsDataSource.prevTrack();
    }

    public MutableLiveData<LinkedList<SongModel>> getSongs() {
        return songsDataSource.getSongs();
    }

    public MutableLiveData<SongModel> getCurrent(){
        return songsDataSource.getCurrent();
    }

}
