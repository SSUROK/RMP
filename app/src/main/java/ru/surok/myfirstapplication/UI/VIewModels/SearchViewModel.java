package ru.surok.myfirstapplication.UI.VIewModels;

import androidx.lifecycle.ViewModel;

import ru.surok.myfirstapplication.Data.Repositories.PostAPIRepository;

public class SearchViewModel extends ViewModel {

    private final PostAPIRepository postAPIRepository;

    public SearchViewModel() {
        postAPIRepository = new PostAPIRepository();
    }

    public void getSongById(int id){
        postAPIRepository.getSongById(id);
    }

    //    private final MutableLiveData<PlayingTrackRepository> track =
//            new MutableLiveData<>(new PlayingTrackRepository());
//
//    public void setTrack(String name){
//        track.setValue(
//                new PlayingTrackRepository(
//                    name,
//                    track.getValue().getBand(),
//                    track.getValue().getDescription(),
//                    track.getValue().getImg(),
//                    track.getValue().getTime()
//        ));
//    }

}
