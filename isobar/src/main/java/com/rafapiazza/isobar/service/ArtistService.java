package com.rafapiazza.isobar.service;

import com.rafapiazza.isobar.domain.dto.ArtistDTO;
import com.rafapiazza.isobar.domain.model.Album;
import com.rafapiazza.isobar.domain.model.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistService {
    List<Artist> getAllArtists();
    

    Artist updateArtist(ArtistDTO artistDTO);

    Artist insertArtist(ArtistDTO artistDTO);

    List<Album> getAllAlbumsFromArtist(String artistId);
}
