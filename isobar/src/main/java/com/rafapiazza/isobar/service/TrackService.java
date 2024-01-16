package com.rafapiazza.isobar.service;

import com.rafapiazza.isobar.domain.dto.TrackDTO;
import com.rafapiazza.isobar.domain.model.Track;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrackService {
    List<Track> getAllTracks();

    Track insertTrack(TrackDTO trackDTO);

    Track updateTrack(String trackId, TrackDTO trackDTO);
}
