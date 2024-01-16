package com.rafapiazza.isobar.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rafapiazza.isobar.domain.model.Artist;
import org.springframework.stereotype.Service;

@Service
public interface EngineService {
    Artist[] fetchDatabase() throws JsonProcessingException;
}
