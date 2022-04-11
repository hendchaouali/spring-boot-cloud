package com.playlist.songs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.playlist.songs.enums.SongCategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class Details extends AbstractAuditModel{

    private Long id;

    @NotBlank(message = "description ne doit pas être nulle ou vide")
    @Size(min = 3, max = 50, message = "description doit être compris entre 3 et 50 caractères")
    private String description;

    @NotBlank(message = "duration ne doit pas être nulle ou vide")
    private String duration;

    @NotBlank(message = "artistname ne doit pas être null ou vide")
    private String artistName;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "categorie<JAZZ, POP, CLASSICAL> ne doit pas être nulle")
    private SongCategory category;

    @NotNull(message = "date ne doit pas être nulle")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
}
