package com.rafapiazza.isobar.repository;

import com.rafapiazza.isobar.domain.model.Album;
import com.rafapiazza.isobar.domain.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends MongoRepository<Artist, String> {
}
