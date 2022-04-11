package com.playlist.songs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "songs")
public class Song extends AbstractAuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SONG_SEQ")
    @SequenceGenerator(name = "SONG_SEQ", sequenceName = "song_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    @NotBlank(message = "titre ne doit pas être null ou vide")
    @Size(min = 3, max = 50, message = "titre doit être compris entre 3 et 50 caractères")
    private String title;
}
