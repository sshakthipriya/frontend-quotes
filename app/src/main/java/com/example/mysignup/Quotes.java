package com.example.mysignup;

public class Quotes {
    private int id;
    private String quotes;
    private String author;

    private String title;

    private String story;

    public Quotes(int id, String quotes, String author, String title, String story) {
        this.id = id;
        this.quotes = quotes;
        this.author = author;
        this.title = title;
        this.story = story;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quote_text) {
        this.quotes = quote_text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
