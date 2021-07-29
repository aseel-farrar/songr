package com.example.songr.controllers;

import com.example.songr.modles.Album;
import com.example.songr.modles.Song;
import com.example.songr.repositories.AlbumRepository;
import com.example.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository repository;

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/allAlbums")
    public String getAllAlbums(Model model) {
        List<Album> albums;
        albums = repository.findAll();

        model.addAttribute("albums", albums);
        return "allAlbums";
    }

    @GetMapping("/addAlbumForm")
    public String addAlbumForm(Model model) {
        return "addAlbum";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(String title,
                                 String artist,
                                 int songCount,
                                 long length,
                                 String imageUrl) {
        repository.save(new Album(title, artist, songCount, length, imageUrl));
        return new RedirectView("/allAlbums");
    }

    @PostMapping("/details")
    public String getAlbumDetails(String albumTitle, Model model) {
        Album album = repository.findByTitle(albumTitle);
        ArrayList<Song> albumSongs = (ArrayList<Song>) songRepository.findByAlbumTitle(albumTitle);
//        System.out.println(albumSongs.get(0).getAlbumTitle());


        model.addAttribute("album", album);
        model.addAttribute("albumSongs",albumSongs);
        return "showAlbum";
    }
}

