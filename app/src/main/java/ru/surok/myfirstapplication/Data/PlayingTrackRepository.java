package ru.surok.myfirstapplication.Data;

import ru.surok.myfirstapplication.R;

public class PlayingTrackRepository {

    private final String name;

    private final String band;

    private final String description;

    private final int img;

    private final int time;

    public PlayingTrackRepository(String name, String band, String description, int img, int time) {
        this.name = name;
        this.band = band;
        this.description = description;
        this.img = img;
        this.time = time;
    }

    public PlayingTrackRepository() {
        this.name = "BloodHail";
        this.band = "Have a nice life";
        this.img = R.drawable.deathconsciousness;
        this.time = 500;
        this.description = "a song";
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getBand() {
        return band;
    }

//    public void setBand(String band) {
//        this.band = band;
//    }

    public String getDescription() {
        return description;
    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    public int getImg() {
        return img;
    }

//    public void setImg(int img) {
//        this.img = img;
//    }

    public int getTime() {
        return time;
    }

//    public void setTime(int time) {
//        this.time = time;
//    }
}
