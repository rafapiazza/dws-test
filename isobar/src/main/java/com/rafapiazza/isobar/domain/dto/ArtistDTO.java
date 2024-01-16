package com.rafapiazza.isobar.domain.dto;

import com.rafapiazza.isobar.domain.model.Album;

import java.util.List;

public record ArtistDTO(String name, String image, String genre, String biography, String numPlays,
                        List<Album> albums) {
}
