package com.rafapiazza.isobar.service.impl;

import com.rafapiazza.isobar.domain.dto.ArtistDTO;
import com.rafapiazza.isobar.domain.model.Album;
import com.rafapiazza.isobar.domain.model.Artist;
import com.rafapiazza.isobar.exception.ArtistNotFoundException;
import com.rafapiazza.isobar.repository.ArtistRepository;
import com.rafapiazza.isobar.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;


    public List<Artist> getAllArtists() {
        return this.artistRepository.findAll();
    }

    public Artist updateArtist(String artistId, ArtistDTO artistDTO) {
        Artist artist = this.artistRepository.findById(artistId)
                .orElseThrow(ArtistNotFoundException::new);

        if (!artistDTO.name().isEmpty())
            artist.setName(artistDTO.name());
        if (!artistDTO.image().isEmpty())
            artist.setImage(artistDTO.image());
        if (!artistDTO.genre().isEmpty())
            artist.setGenre(artistDTO.genre());
        if (!artistDTO.biography().isEmpty())
            artist.setBiography(artistDTO.biography());
        if (null != artistDTO.numPlays())
            artist.setNumPlays(artistDTO.numPlays());
        if (!artistDTO.albums().isEmpty())
            artist.setAlbums(artistDTO.albums());

        return artist;
    }

    public Artist insertArtist(ArtistDTO artistDTO) {
        Artist artist = new Artist(artistDTO);
        List<Album> albums = getAllAlbumsFromArtist(artist.getId());
        artist.setAlbums(albums);
        this.artistRepository.save(artist);
        return artist;
    }

    public List<Artist> insertBulkArtist(List<Artist> artists) {
        this.artistRepository.saveAll(artists);
        return artists;
    }


    @Cacheable(value = "artistCache", key = "#name")
    public List<Artist> findArtistByName(String name) {
        return this.artistRepository.findByNameStartingWith(name);
    }

    public List<Album> getAllAlbumsFromArtist(String artistId) {
        Artist artist = this.artistRepository.findById(artistId)
                .orElseThrow(ArtistNotFoundException::new);

        return artist.getAlbums();
    }
}
