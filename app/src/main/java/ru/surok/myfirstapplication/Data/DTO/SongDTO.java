package ru.surok.myfirstapplication.Data.DTO;

public class SongDTO {

    private final String name;

    private final String band;

    private final String description;

    private final int img;

    private final int time;

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
