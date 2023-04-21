package ru.surok.myfirstapplication.Data;

public class SongDTO {

    private String name;

    private String band;

    private String description;

    private int img;

    private int time;

    public SongDTO(String name, String band, String description, int img, int time) {
        this.name = name;
        this.band = band;
        this.description = description;
        this.img = img;
        this.time = time;
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
