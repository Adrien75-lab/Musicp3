package com.example.musicP3.service;

import com.example.musicP3.entity.music;
import com.example.musicP3.repository.MusicRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MusicService {
    @Autowired
    private MusicRepositoryInterface musicRepositoryInterface;

    public Iterable<music> getMusicList(){ return musicRepositoryInterface.findAll();}
    // add



}
