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

        albumRepository.saveAll(albums);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("1st Song", 111L, 1, "Folklore"));
        songs.add(new Song("2nd Song", 777L, 2, "Folklore"));
        songs.add(new Song("3rd Song", 999L, 3, "Folklore"));

        songs.get(0).setAlbum(albums.get(0));
        songs.get(1).setAlbum(albums.get(0));
        songs.get(2).setAlbum(albums.get(0));

        songs.add(new Song("1st Song", 222L, 1, "The Album"));
        songs.add(new Song("2nd Song", 333L, 2, "The Album"));
        songs.add(new Song("3rd Song", 444L, 3, "The Album"));

        songs.get(3).setAlbum(albums.get(1));
        songs.get(4).setAlbum(albums.get(1));
        songs.get(5).setAlbum(albums.get(1));

        songs.add(new Song("1st Song", 555L, 1, "Good Souls Better Angels"));
        songs.add(new Song("2nd Song", 666L, 2, "Good Souls Better Angels"));
        songs.add(new Song("3rd Song", 777L, 3, "Good Souls Better Angels"));

        songs.get(6).setAlbum(albums.get(2));
        songs.get(7).setAlbum(albums.get(2));
        songs.get(8).setAlbum(albums.get(2));
        songRepository.saveAll(songs);

        return "albums";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable String text, Model model) {
        model.addAttribute("text", text.toUpperCase());
        return "capitalize";
    }
}
