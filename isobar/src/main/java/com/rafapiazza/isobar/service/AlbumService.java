package com.rafapiazza.isobar.service;

import com.rafapiazza.isobar.domain.dto.AlbumDTO;
import com.rafapiazza.isobar.domain.model.Album;
import com.rafapiazza.isobar.domain.model.Track;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlbumService {
    Album insertAlbum(AlbumDTO albumDTO);

    List<Album> getAllAlbums();

    Album updateAlbum(String albumId, AlbumDTO albumDTO);

    List<Track> getAllTracksFromAlbum(String albumId);
}
