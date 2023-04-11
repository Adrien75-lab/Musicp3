package com.example.musicP3.repository;

import com.example.musicP3.entity.music;
import org.springframework.data.repository.CrudRepository;


public interface MusicRepositoryInterface extends CrudRepository<music, String> {

}
