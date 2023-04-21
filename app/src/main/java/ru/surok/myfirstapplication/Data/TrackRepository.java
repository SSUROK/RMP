package ru.surok.myfirstapplication.Data;

import java.util.ArrayList;
import java.util.List;

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

    public SongDTO nextTrack(){
        return songsDataSource.nextTrack();
    }

    public List<ListItem> getNextSongs(){
        List<SongDTO> songs = songsDataSource.getNextSongs();
        List<ListItem> listItems = new ArrayList<>();
        for (SongDTO s : songs){
            listItems.add(new ListItem(s.getImg(), s.getName()));
        }
        return listItems;
    }
}
