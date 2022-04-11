package com.playlist.songs.repository;

import com.playlist.songs.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public interface SongRepository extends JpaRepository<Song, Long> {
}
