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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SongrController {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/hello")
    public String helloWorld(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        return "helloWorld";
    }

    @GetMapping("/albums")
    public String showAlbums(Model model) {

        ArrayList<Album> albums = new ArrayList<>();

        albums.add(new Album("Folklore", "Taylor Swift", 16, 3809, "https://static.billboard.com/files/2020/12/Taylor-swift-folklore-cover-billboard-1240-1607121703-compressed.jpg"));
        albums.add(new Album("Be", "BTS", 8, 1710, "https://ibighit.com/bts/images/bts/discography/be/rwXJxHlQ87gEiJJynB1pmScl.jpg"));
        albums.add(new Album("Good Souls Better Angels", "Lucinda Williams", 12, 3589, "https://static.billboard.com/files/2020/12/lucinda-williams-good-souls-better-angels-cover-billboard-1240-1607121672-compressed.jpg"));
        albums.add(new Album("The Album", "Blackpink", 8, 1466, "https://static.billboard.com/files/2020/12/blackpink-the-album-billboard-1240-1607365628-compressed.jpg"));

        model.addAttribute("albums", albums);


        return "albums";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable String text, Model model) {
        model.addAttribute("text", text.toUpperCase());
        return "capitalize";
    }
}
