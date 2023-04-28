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
import ru.surok.myfirstapplication.Data.DTO.SongDTO;
import ru.surok.myfirstapplication.Data.DataSources.SongsDataSource;
import ru.surok.myfirstapplication.Data.Models.SongModel;

public final class TrackRepository {

    private final SongsDataSource songsDataSource;
    private static TrackRepository INSTANCE;

    public TrackRepository() {
        songsDataSource = new SongsDataSource();
    }

    public static TrackRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new TrackRepository();
        }
        return INSTANCE;
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
