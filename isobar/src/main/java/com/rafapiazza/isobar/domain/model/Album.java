package com.rafapiazza.isobar.domain.model;

import com.rafapiazza.isobar.domain.dto.AlbumDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "albums")
public class Album {
    @Id
    private String id;
    private String name;
    private String image;
    private Date releasedDate;
    private String band;
    private List<Track> tracks;

    public Album(AlbumDTO albumDTO) {
        this.name = albumDTO.name();
        this.image = albumDTO.image();
        this.releasedDate = albumDTO.releasedDate();
        this.band = albumDTO.band();
        this.tracks = albumDTO.tracks();
    }
}
