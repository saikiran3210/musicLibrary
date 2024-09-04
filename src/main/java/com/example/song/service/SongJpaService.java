package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

//import com.example.player.model.PlayerRowMapper;
import com.example.song.model.Song;
import com.example.song.repository.SongRepository;
import com.example.song.repository.SongJpaRepository;//extra

@Service
public class SongJpaService implements SongRepository {

    @Autowired
    private SongJpaRepository songJpaRepository;// extra create instance

    @Override
    public ArrayList<Song> getSongs() {

        List<Song> pl = songJpaRepository.findAll();
        ArrayList<Song> pls = new ArrayList<>(pl);
        return pls;

    }

    @Override
    public Song getSongById(int songId) {

        try {
            Song song = songJpaRepository.findById(songId).get();
            return song;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song song) {
        songJpaRepository.save(song);
        return song;
    }

    @Override
    public Song updateSong(int songId, Song song) {
        try {
            Song newplayer = songJpaRepository.findById(songId).get();
            if (song.getSongName() != null) {
                newplayer.setSongName(song.getSongName());
            }
            if (song.getLyricist() != null) {
                newplayer.setLyricist(song.getLyricist());
            }
            if (song.getSinger() != null) {
                newplayer.setSinger(song.getSinger());
            }
            if (song.getMusicDirector() != null) {
                newplayer.setMusicDirector(song.getMusicDirector());
            }
            songJpaRepository.save(newplayer);
            return newplayer;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteSong(int songId) {
        try {
            songJpaRepository.deleteById(songId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}