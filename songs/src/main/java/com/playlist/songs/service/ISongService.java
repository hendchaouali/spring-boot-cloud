package com.playlist.songs.service;


import com.playlist.songs.model.Details;
import com.playlist.songs.model.Song;

import java.util.Set;

public interface ISongService {

    Set<Song> getAllSongs();

    Song getSongById(Long id);

    Song createSong(Song song);

    Song updateSong(Song song);

    void deleteSongById(Long id);
}
