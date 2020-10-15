package com.experis.se.hampus.olsson.MusicDatabase.contollers;

import java.util.ArrayList;

import com.experis.se.hampus.olsson.MusicDatabase.data_access.TrackRepository;
import com.experis.se.hampus.olsson.MusicDatabase.models.Track;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackController {
    TrackRepository trackRepo = new TrackRepository();

        //Set endpoints
        @RequestMapping(value = "api/tracks/{id}", method = RequestMethod.GET)
        public Track getTrackFromId(@PathVariable int id) { return trackRepo.getTrackFromId(id);}

        @RequestMapping(value = "api/tracks", method = RequestMethod.GET)
        public ArrayList<Track> getAllTracks(){ return trackRepo.getAllTracks();};
}
