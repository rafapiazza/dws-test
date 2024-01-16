package com.rafapiazza.isobar.service.impl;

import com.rafapiazza.isobar.domain.dto.AlbumDTO;
import com.rafapiazza.isobar.domain.model.Album;
import com.rafapiazza.isobar.domain.model.Track;
import com.rafapiazza.isobar.exception.AlbumNotFoundException;
import com.rafapiazza.isobar.repository.AlbumRepository;
import com.rafapiazza.isobar.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album insertAlbum(AlbumDTO albumDTO) {
        Album album = new Album(albumDTO);
        this.albumRepository.save(album);
        return album;
    }

    public List<Album> getAllAlbums() {
        return this.albumRepository.findAll();
    }

    public Album updateAlbum(String albumId, AlbumDTO albumDTO) {
        Album album = this.albumRepository.findById(albumId)
                .orElseThrow(AlbumNotFoundException::new);

        if (!albumDTO.name().isEmpty())
            album.setName(albumDTO.name());
        if (!albumDTO.image().isEmpty())
            album.setImage(albumDTO.image());
        if (null != albumDTO.releasedDate())
            album.setReleasedDate(albumDTO.releasedDate());
        if (!albumDTO.band().isEmpty())
            album.setBand(albumDTO.band());
        if (!albumDTO.tracks().isEmpty())
            album.setTracks(albumDTO.tracks());

        return album;
    }

    public List<Track> getAllTracksFromAlbum(String albumId) {
        Album album = this.albumRepository.findById(albumId)
                .orElseThrow(AlbumNotFoundException::new);

        return album.getTracks();
    }

    @Cacheable(value = "albumCache", key = "#name")
    public List<Album> findAlbumByName(String name) {
        return this.albumRepository.findByNameStartingWith(name);
    }
}
