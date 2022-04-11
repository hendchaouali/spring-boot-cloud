package com.playlist.songs.resource;

import com.playlist.songs.model.Details;
import com.playlist.songs.model.Song;
import com.playlist.songs.service.DetailsServiceImpl;
import com.playlist.songs.service.ISongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/songs")
public class SongResource {

    private final ISongService songService;

    private final DetailsServiceImpl detailsService;

    public SongResource(ISongService songService, DetailsServiceImpl detailsService) {
        this.songService = songService;
        this.detailsService = detailsService;
    }


    @GetMapping
    public ResponseEntity<Set<Song>> getAllSongs() {
        Set<Song> songs = songService.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        Song song = songService.getSongById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("details/template/{id}")
    public Details getDetailUsingRestTemplate(@PathVariable Long id) {
        log.info("***** Using Rest Template with id " + id + " ***** ");
        return detailsService.getDetailUsingRestTemplate(id);
    }

    @GetMapping("details/feign/{id}")
    public Details getDetailsUsingFeignClient(@PathVariable Long id) {
        log.info("***** Using Feign Client with id " + id + " ***** ");
        return detailsService.getDetailsUsingFeignClient(id);
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@Valid @RequestBody Song song) {
        Song addedSong = songService.createSong(song);
        return new ResponseEntity<>(addedSong, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateSong(@Valid @RequestBody Song song) {
        Song updatedSong = songService.updateSong(song);
        return new ResponseEntity<>(updatedSong, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSongById(@PathVariable Long id) {
        songService.deleteSongById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
