/*
 * You can use the following import statements
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.song.model;

import javax.persistence.*;//extra
import java.util.*;

@Entity // map the class to database
@Table(name = "playlist") // table name...
public class Song {
    @Id // primary key
    @Column(name = "songid") // map this to column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int songId;
    @Column(name = "songname")
    private String songName;
    @Column(name = "lyricist")
    private String lyricist;
    @Column(name = "singer")
    private String singer;
    @Column(name = "musicdirector")
    private String musicDirector;

    public Song() {
    }// creare the newinstances

    public Song(int songId, String songName, String lyricist, String singer, String musicDirector) {
        this.songId = songId;
        this.songName = songName;
        this.lyricist = lyricist;
        this.singer = singer;
        this.musicDirector = musicDirector;

    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getSinger() {
        return singer;

    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicDirector() {
        return musicDirector;

    }

    public void setMusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }
}