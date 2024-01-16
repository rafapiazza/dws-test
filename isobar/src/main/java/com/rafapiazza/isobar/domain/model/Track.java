package com.rafapiazza.isobar.domain.model;

import com.rafapiazza.isobar.domain.dto.TrackDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "tracks")
public class Track {
    @Id
    private String id;
    private String name;
    private Integer duration;

    public Track(TrackDTO trackDTO) {
        this.name = trackDTO.name();
        this.duration = trackDTO.duration();
    }
}
