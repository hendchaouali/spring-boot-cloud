package com.playlist.details.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.playlist.details.enums.SongCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "details")
public class Details extends AbstractAuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SONG_SEQ")
    @SequenceGenerator(name = "SONG_SEQ", sequenceName = "song_seq", allocationSize = 1)
    private Long id;

    @Column(name = "description")
    @NotBlank(message = "description ne doit pas être nulle ou vide")
    @Size(min = 3, max = 50, message = "description doit être compris entre 3 et 50 caractères")
    private String description;

    @Column(name = "duration")
    @NotBlank(message = "duration ne doit pas être nulle ou vide")
    private String duration;

    @Column(name = "artist_name")
    @NotBlank(message = "artistname ne doit pas être null ou vide")
    private String artistName;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "categorie<JAZZ, POP, CLASSICAL> ne doit pas être nulle")
    private SongCategory category;

    @Column(name = "date")
    @NotNull(message = "date ne doit pas être nulle")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
}
