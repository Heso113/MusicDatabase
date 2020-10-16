package com.experis.se.hampus.olsson.MusicDatabase.contollers;


import java.util.ArrayList;

import com.experis.se.hampus.olsson.MusicDatabase.data_access.SearchObjectRepository;
import com.experis.se.hampus.olsson.MusicDatabase.models.SearchObject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchObjectController {
    SearchObjectRepository searchRepo = new SearchObjectRepository();

    //Set endpoints
    @RequestMapping(value = "/api/search/{search}", method = RequestMethod.GET)
    public ArrayList<SearchObject> getAllTracksFromSearch(@PathVariable String search) {return searchRepo.getAllTracksFromSearch(search);} 
}
