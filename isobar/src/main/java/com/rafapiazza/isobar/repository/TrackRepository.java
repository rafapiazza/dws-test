package com.rafapiazza.isobar.repository;

import com.rafapiazza.isobar.domain.model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track, String> {
    List<Track> findByNameStartingWith(String name);
}
