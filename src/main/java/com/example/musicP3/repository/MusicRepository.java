package com.example.musicP3.repository;

import com.example.musicP3.entity.music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<music> list(){
        return jdbcTemplate.query("SELECT MUSIC_ID, TITLE, DESCRIPTION FROM MUSIC",
                (rs, rowNum) -> new music(
                        String.valueOf(rs.getLong("MUSIC_ID")),
                        rs.getString("TITLE"),
                        rs.getString("DESCRIPTION")
                ));
    }
    //add
    public void add(music music) {

        jdbcTemplate.update("INSERT INTO MUSIC (TITLE, DESCRIPTION) VALUES (?, ?)",
        new Object[]{
                music.getTitle(),
                music.getDescription()
        });

    }

    public music findById(long number) {
        String query = "SELECT MUSIC_ID, TITLE, DESCRIPTION FROM MUSIC WHERE MUSIC_ID = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{number}, (rs, rowNum) -> new music(
                String.valueOf(rs.getLong("MUSIC_ID")),
                rs.getString("TITLE"),
                rs.getString("DESCRIPTION")
        ));
    }
    public void update(music music) {
        String query = "UPDATE MUSIC SET TITLE = ?, DESCRIPTION = ? WHERE MUSIC_ID = ?";
        jdbcTemplate.update(query, new Object[]{
                music.getTitle(),
                music.getDescription(),
                music.getMusic_id()
        });
    }
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM MUSIC WHERE MUSIC_ID = ?", id);
    }


}

