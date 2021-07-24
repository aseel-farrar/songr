package com.example.songr.controller;

import com.example.songr.modle.Album;
import com.example.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository repository;

    @GetMapping("/allAlbums")
    public String getAllAlbums(Model model) {
        List<Album> albums;
        albums= repository.findAll();

        model.addAttribute("albums", albums);
        return "allAlbums";
    }

    @GetMapping("/addAlbumForm")
    public String addAlbumForm(Model model){
        return "addAlbum";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(String title, String artist, int songCount, long length, String imageUrl ){
        repository.save(new Album(title, artist, songCount,length,imageUrl));
        return new RedirectView("/allAlbums");
    }
}

