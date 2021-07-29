package com.example.songr.controllers;

import com.example.songr.modles.Album;
import com.example.songr.modles.Song;
import com.example.songr.repositories.AlbumRepository;
import com.example.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/allSongs")
    public String getAllAlbums(Model model) {
        List<Song> songs;
        songs = songRepository.findAll();
        model.addAttribute("songs", songs);
        return "allSongs";
    }

    @GetMapping("/addSongForm")
    public String addSongForm(Model model) {
        return "addSong";
    }

    @PostMapping("/addSong")
    public RedirectView addSongToAlbum(String albumTitle,
                                       String songTitle,
                                       int length,
                                       int trackNumber) {

        Song newSong = new Song(songTitle, (long) length, trackNumber, albumTitle);
        Album album = albumRepository.findByTitle(albumTitle);
        newSong.setAlbum(album);
        songRepository.save(newSong);
        return new RedirectView("/allSongs");
    }
}
