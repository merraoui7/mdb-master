package com.zeneo.tmdb.Models;

public class Discover {

    private String title;
    private String year;
    private int id;


    public Discover(String title, String year, int id) {
        this.title = title;
        this.year = year;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

}
