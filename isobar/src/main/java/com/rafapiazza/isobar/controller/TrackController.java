package com.rafapiazza.isobar.controller;

import com.rafapiazza.isobar.domain.dto.TrackDTO;
import com.rafapiazza.isobar.domain.model.Track;
import com.rafapiazza.isobar.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/track")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @GetMapping(value = {"/all"}, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Track>> getAll() {
        return ResponseEntity.accepted().body(trackService.getAllTracks());
    }

    @PostMapping(value = {"/insert"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Track> insertTrack(@RequestBody TrackDTO trackDTO) {
        return ResponseEntity.accepted().body(trackService.insertTrack(trackDTO));
    }


    @PostMapping(value = {"/{trackId}/update"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Track> updateTrack(@PathVariable("artistId") String artistId,
                                             @RequestBody TrackDTO trackDTO) {
        return ResponseEntity.accepted().body(trackService.updateTrack(artistId, trackDTO));
    }

}
