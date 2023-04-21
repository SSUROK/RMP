package ru.surok.myfirstapplication.Data;

import android.os.Build;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ru.surok.myfirstapplication.R;

public class SongsDataSource {

    private final List<SongDTO> songs = new LinkedList<>();
    private Iterator<SongDTO> iter;

    public SongsDataSource() {
        for(int j = 65; j <= 70; j++) {
            for (int i = 65; i <= 90; i++) {
                SongDTO song = new SongDTO("Song " + (char) i, "Band " + (char) j,
                        String.format("song %s from band %s", (char) i, (char) j), R.drawable.ic_launcher_background, 300);
                songs.add(song);
            }
        }
        iter = songs.listIterator();
    }

    public SongDTO nextTrack(){
        if (!iter.hasNext()) {
            iter = songs.listIterator();
        }
        return iter.next();
    }

    public List<SongDTO> getNextSongs(){
        List<SongDTO> s = new LinkedList<>();
//        int index = songs.indexOf(iter.next());
//        while (iter.hasNext()){
//            s.add(iter.next());
//        }
//        iter = songs.listIterator(index);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            iter.forEachRemaining(s::add);
        }
        return s;
    }
}
