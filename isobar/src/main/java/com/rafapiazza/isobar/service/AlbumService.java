package com.rafapiazza.isobar.service;

import com.rafapiazza.isobar.domain.dto.AlbumDTO;
import com.rafapiazza.isobar.domain.model.Album;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlbumService {
    Album insertAlbum(AlbumDTO albumDTO);

    List<Album> getAllAlbums();

    Album updateAlbum(AlbumDTO albumDTO);

    List<Album> getAllTracksFromAlbum(String artistId);
}
