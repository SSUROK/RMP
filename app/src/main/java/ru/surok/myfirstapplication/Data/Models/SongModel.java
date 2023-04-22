package ru.surok.myfirstapplication.Data.Models;

import ru.surok.myfirstapplication.Data.DTO.SongDTO;

public class SongModel {

    private final String name;
    private final String band;
    private final int img;

    public SongModel(String name, String band, int img) {
        this.name = name;
        this.band = band;
        this.img = img;
    }

    public SongModel(SongDTO songDTO) {
        this.name = songDTO.getName();
        this.band = songDTO.getBand();
        this.img = songDTO.getImg();
    }

    public String getName() {
        return name;
    }

    public String getBand() {
        return band;
    }

    public int getImg() {
        return img;
    }
}
