package com.rafapiazza.isobar.domain.model;

import com.rafapiazza.isobar.domain.dto.ArtistDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "artists")
public class Artist {
    @Id
    private String id;
    private String name;
    private String image;
    private String genre;
    private String biography;
    private Integer numPlays;
    private List<Album> albums;

    public Artist(ArtistDTO artistDTO) {
        this.name = artistDTO.name();
        this.image = artistDTO.image();
        this.genre = artistDTO.genre();
        this.biography = artistDTO.biography();
        this.numPlays = artistDTO.numPlays();
        this.albums = artistDTO.albums();
    }
}
