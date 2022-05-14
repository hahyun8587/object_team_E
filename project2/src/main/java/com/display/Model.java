package com.display;

public class Model {
    String title;
    String rank;
    String date;

    public Model(String title, String rank, String date) {
        this.rank = rank;
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getRank() {
        return rank;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDate(String date) {
        this.date = date;
    }
}