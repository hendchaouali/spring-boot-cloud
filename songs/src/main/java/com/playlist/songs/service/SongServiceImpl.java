package com.playlist.songs.service;

import com.playlist.songs.model.Details;
import com.playlist.songs.model.Song;
import com.playlist.songs.repository.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class SongServiceImpl implements ISongService {
    private static final Logger log = LoggerFactory.getLogger(SongServiceImpl.class);

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public Set<Song> getAllSongs() {
        return new HashSet<>(songRepository.findAll());
    }


    @Override
    @Transactional(readOnly = true)
    public Song getSongById(Long id) {

        return songRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Not found song with id = " + id));
    }

    @Override
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song updateSong(Song song) {

        Song searchedSong = songRepository.findById(song.getId())
                .orElseThrow(() -> new IllegalStateException("Not found song with id = " + song.getId()));

        searchedSong.setTitle(song.getTitle());

        return songRepository.save(song);
    }

    @Override
    public void deleteSongById(Long id) {
        songRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Not found song with id = " + id));

        songRepository.deleteById(id);
    }

}
