package com.rafapiazza.isobar.service.impl;

import com.rafapiazza.isobar.domain.dto.TrackDTO;
import com.rafapiazza.isobar.domain.model.Track;
import com.rafapiazza.isobar.exception.TrackNotFoundException;
import com.rafapiazza.isobar.repository.TrackRepository;
import com.rafapiazza.isobar.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public List<Track> getAllTracks() {
        return this.trackRepository.findAll();
    }

    public Track updateTrack(String trackId, TrackDTO trackDTO) {
        Track track = this.trackRepository.findById(trackId)
                .orElseThrow(TrackNotFoundException::new);

        if (!trackDTO.name().isEmpty())
            track.setName(trackDTO.name());
        if (null != trackDTO.duration())
            track.setDuration(trackDTO.duration());

        return track;
    }

    public Track insertTrack(TrackDTO trackDTO) {
        Track track = new Track(trackDTO);
        this.trackRepository.save(track);
        return track;
    }

    @Cacheable(value = "trackCache", key = "#name")
    public List<Track> findTrackByName(String name) {
        return this.trackRepository.findByNameStartingWith(name);
    }

}
