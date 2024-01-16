package com.rafapiazza.isobar.repository;

import com.rafapiazza.isobar.domain.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {
    List<Album> findByNameStartingWith(String name);
}
