package ru.surok.myfirstapplication.Data;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public final class TrackRepository {

    private final SongsDataSource songsDataSource;
    private static TrackRepository INSTANCE;
    private ListIterator<SongDTO> iter;
    private SongDTO current;

    public TrackRepository() {
        songsDataSource = new SongsDataSource();
        iter = songsDataSource.getSongs().listIterator();
        current = iter.next();
    }

    public static TrackRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new TrackRepository();
        }
        return INSTANCE;
    }

    public SongDTO getCurrent() {
        return current;
    }

    public void nextTrack(){
        if (!iter.hasNext()) {
            iter = songsDataSource.getSongs().listIterator();
        }
        current = iter.next();
    }

    public void prevTrack(){
        if (iter.hasPrevious()) {
            current = iter.previous();
        }
    }

    public List<ListItem> getNextSongs(){
        List<ListItem> listItems = new ArrayList<>();
        int index = songsDataSource.getSongs().indexOf(current);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            iter.forEachRemaining(s->{
                listItems.add(new ListItem(s.getImg(), s.getName()));
            });
        }
        iter = songsDataSource.getSongs().listIterator(index + 1);
        return listItems;
    }
}
