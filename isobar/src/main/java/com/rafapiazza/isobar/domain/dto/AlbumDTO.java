package com.rafapiazza.isobar.domain.dto;

import com.rafapiazza.isobar.domain.model.Track;

import java.util.Date;
import java.util.List;

public record AlbumDTO(String name, String image, Date releasedDate, String band, List<Track> tracks) {
}
