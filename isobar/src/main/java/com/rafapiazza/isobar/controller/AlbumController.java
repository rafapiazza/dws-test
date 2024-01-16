package com.rafapiazza.isobar.controller;

import com.rafapiazza.isobar.domain.dto.AlbumDTO;
import com.rafapiazza.isobar.domain.model.Album;
import com.rafapiazza.isobar.domain.model.Track;
import com.rafapiazza.isobar.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping(value = {"/all"}, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Album>> getAll(){
        return ResponseEntity.accepted().body(albumService.getAllAlbums());
    }

    @PostMapping(value = "/insert", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Album> insertAlbum(@RequestBody AlbumDTO albumDTO){
        return ResponseEntity.accepted().body(albumService.insertAlbum(albumDTO));
    }


    @PostMapping(value = {"/update/{albumId}"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Album> updateAlbum(@PathVariable("albumId") String albumId,
                                             @RequestBody AlbumDTO albumDTO){
        return ResponseEntity.accepted().body(albumService.updateAlbum(albumId, albumDTO));
    }

    @GetMapping(value = {"/{albumId}"}, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Track>> getAllAlbumsFromArtist(@PathVariable("albumId") String albumId) {
        return ResponseEntity.accepted().body(albumService.getAllTracksFromAlbum(albumId));
    }

}
