package com.example.songr.repositories;

import com.example.songr.modles.Album;
import com.example.songr.modles.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
//    public List<Song> findByTitleAndAlbum(String title, Album album);
    public List<Song> findByAlbumTitle(String albumTitle);

}
