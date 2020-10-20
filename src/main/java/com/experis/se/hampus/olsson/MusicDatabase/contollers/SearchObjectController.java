package com.experis.se.hampus.olsson.MusicDatabase.contollers;


import java.util.ArrayList;

import com.experis.se.hampus.olsson.MusicDatabase.data_access.SearchObjectRepository;
import com.experis.se.hampus.olsson.MusicDatabase.models.SearchObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchObjectController {
    SearchObjectRepository searchRepo = new SearchObjectRepository();

    //Set endpoints
    @RequestMapping(value = "/api/fetch/tracksfromsearch/", method = RequestMethod.GET)
    public ArrayList<SearchObject> getAllTracksFromSearch(@RequestParam("search") String search) {
        return searchRepo.getAllTracksFromSearch(search);
    } 

    @RequestMapping(value = "/api/fetch/artists/", method = RequestMethod.GET)
    public ArrayList<SearchObject> getAllArtists() {
        return searchRepo.getAllUniqueArtists();
    }

    @RequestMapping(value = "/api/fetch/genres/", method = RequestMethod.GET)
    public ArrayList<SearchObject> getAllGenres() {
        return searchRepo.getAllUniqueGenres();
    }

    @RequestMapping(value = "/api/fetch/tracks/", method = RequestMethod.GET)
    public ArrayList<SearchObject> getAllTracks() {
        return searchRepo.getAllTracks();
    }
}
