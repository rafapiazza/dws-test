package com.rafapiazza.isobar.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rafapiazza.isobar.domain.model.Artist;
import com.rafapiazza.isobar.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/engine")
public class EngineController {

    @Autowired
    private EngineService engineService;

    @GetMapping(value = {"/all"}, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Artist[]> fetchAll() throws JsonProcessingException {
        return ResponseEntity.accepted().body(engineService.fetchDatabase());
    }
}
