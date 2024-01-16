package com.rafapiazza.isobar.repository;

import com.rafapiazza.isobar.domain.model.Artist;
import com.rafapiazza.isobar.domain.model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends MongoRepository<Track, String> {
}
