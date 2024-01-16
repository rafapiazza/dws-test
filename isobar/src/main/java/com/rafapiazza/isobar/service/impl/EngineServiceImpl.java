package com.rafapiazza.isobar.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafapiazza.isobar.domain.model.Artist;
import com.rafapiazza.isobar.repository.AlbumRepository;
import com.rafapiazza.isobar.repository.ArtistRepository;
import com.rafapiazza.isobar.repository.TrackRepository;
import com.rafapiazza.isobar.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public Artist[] fetchDatabase() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        RestTemplate restTemplate = new RestTemplate();
        String dwsApiUIrl
                = "https://dws-recruiting-bands-api.dwsbrazil.io/api/bands";
        ResponseEntity<String> response
                = restTemplate.getForEntity(dwsApiUIrl, String.class);


        Artist[] data = objectMapper.readValue(response.getBody(), Artist[].class);
        ArrayList<Artist> artistList = new ArrayList<>(Arrays.stream(data).toList());

        artistRepository.saveAll(artistList);

        artistList.forEach(artist -> {
            albumRepository.saveAll(artist.getAlbums());
            artist.getAlbums().forEach(album -> trackRepository.saveAll(album.getTracks()));
        });

        return data;
    }
}
