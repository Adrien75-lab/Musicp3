package com.example.musicP3.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class music {

    @Id
    @Column("MUSIC_ID")
    private String music_id;
    @Column("TITLE")
    private String title;


    @Column("DESCRIPTION")
    private String description;


    public music(String music_id, String title, String description) {
        this.music_id = music_id;
        this.title = title;
        this.description= description;
    }

    public music() {

    }

    public String getMusic_id() {
        return this.music_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setMusic_id(String music_id) {
    }
}
