package com.rafapiazza.isobar.controller;

import com.rafapiazza.isobar.domain.dto.AlbumDTO;
import com.rafapiazza.isobar.domain.dto.ArtistDTO;
import com.rafapiazza.isobar.domain.model.Album;
import com.rafapiazza.isobar.domain.model.Artist;
import com.rafapiazza.isobar.service.AlbumService;
import com.rafapiazza.isobar.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping(value = {"/all"}, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Artist>> getAll(){
        return ResponseEntity.accepted().body(artistService.getAllArtists());
    }

    @PostMapping(value = "/insert", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Artist> insertArtist(@RequestBody ArtistDTO artistDTO){
        return ResponseEntity.accepted().body(artistService.insertArtist(artistDTO));
    }


    @PostMapping(value = {"/update"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Artist> updateArtist(@RequestBody ArtistDTO artistDTO){
        return ResponseEntity.accepted().body(artistService.updateArtist(artistDTO));
    }

    @GetMapping(value = {"/{artistId}"}, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Album>> getAllAlbumsFromArtist(@PathVariable("artistId") String artistId) {
        return ResponseEntity.accepted().body(artistService.getAllAlbumsFromArtist(artistId));
    }

}
