package ru.surok.myfirstapplication.Data.Repositories;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.surok.myfirstapplication.Data.DataSources.Retrofit.GeniusAPI;
import ru.surok.myfirstapplication.Data.DataSources.Retrofit.RetrofitFactory;
import ru.surok.myfirstapplication.Data.DataSources.Retrofit.SongModelAPI;

public class PostAPIRepository {

    public final String URL_API = "https://jsonplaceholder.typicode.com/";
    private final Retrofit retrofit;
    private final GeniusAPI api;

    public PostAPIRepository() {
        retrofit = RetrofitFactory.getRetrofit(URL_API);
        api = retrofit.create(GeniusAPI.class);
    }

    public void getAllPosts(){
        Call<List<SongModelAPI>> call = api.getAllSongs();
        call.enqueue(new Callback<List<SongModelAPI>>() {
            @Override
            public void onResponse(Call<List<SongModelAPI>> call, Response<List<SongModelAPI>> response) {
                if (response.isSuccessful()) {
                    List posts = response.body();
                    Log.d("Success",
                            posts.get(3).toString());
                }else{
                    Log.d("Ей", "task failed successfully");
                }
            }

            @Override
            public void onFailure(Call<List<SongModelAPI>> call, Throwable t) {
                Log.d("Ей", "Ошибка!!");
            }
        });
    }

    public void getSongById(int id){
        Call<SongModelAPI> call = api.getSongById(id);
        call.enqueue(new Callback<SongModelAPI>() {
            @Override
            public void onResponse(Call<SongModelAPI> call, Response<SongModelAPI> response) {
                if (response.isSuccessful()) {
                    SongModelAPI song = response.body();
                    Log.d("Success",
                            song.getBody());
                }else{
                    Log.d("Ей", "task failed successfully");
                }
            }

            @Override
            public void onFailure(Call<SongModelAPI> call, Throwable t) {
                Log.d("Ей", "Ошибка!!");
            }
        });
    }

    public void addSong(SongModelAPI song){
        Call<SongModelAPI> call = api.addSong(song);
        call.enqueue(new Callback<SongModelAPI>() {
            @Override
            public void onResponse(Call<SongModelAPI> call, Response<SongModelAPI> response) {
                if (response.isSuccessful()) {
                    SongModelAPI song = response.body();
                    Log.d("Success",
                            String.valueOf(response.code()));
                }else{
                    Log.d("Ей", "task failed successfully");
                }
            }

            @Override
            public void onFailure(Call<SongModelAPI> call, Throwable t) {
                Log.d("Ей", "Ошибка!!");
            }
        });
    }

}
