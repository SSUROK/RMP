package ru.surok.myfirstapplication.Data.DataSources.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.surok.myfirstapplication.Data.Models.SongModel;

public interface GeniusAPI {

    @POST("posts")
    Call<SongModelAPI> addSong(@Body SongModelAPI song);

    @GET("posts")
    Call<List<SongModelAPI>> getAllSongs();

    @GET("posts/{id}")
    Call<SongModelAPI> getSongById(@Path("id") int postId);
}
