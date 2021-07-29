package com.example.songr.repositories;

import com.example.songr.modles.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
public Album findByAlbumId(Long id);
public Album findByTitle(String album);
}
