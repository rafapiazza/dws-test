package com.rafapiazza.isobar.repository;

import com.rafapiazza.isobar.domain.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends MongoRepository<Artist, String> {
    List<Artist> findByNameStartingWith(String name);

}
