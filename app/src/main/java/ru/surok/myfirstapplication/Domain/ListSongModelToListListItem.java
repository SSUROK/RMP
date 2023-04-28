package ru.surok.myfirstapplication.Domain;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ru.surok.myfirstapplication.Data.DataSources.ListItem;
import ru.surok.myfirstapplication.Data.Models.SongModel;

public class ListSongModelToListListItem {
    public static List<ListItem> change(ListIterator<SongModel>items){
        List<ListItem> li = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            items.forEachRemaining(e->li.add(new ListItem(e.getImg(), e.getName())));
        }
//        List<ListItem> li = new ArrayList<>();
//        while(items.hasNext()){
//            SongModel temp = items.next();
//            li.add(new ListItem(temp.getImg(), temp.getName()));
//        }
        return li;
    }
}
