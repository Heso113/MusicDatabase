package com.experis.se.hampus.olsson.MusicDatabase.contollers;
import com.experis.se.hampus.olsson.MusicDatabase.models.SearchObject;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebsiteController {
    SearchObjectController soc = new SearchObjectController();
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("greeting", "Music suggestions");    
        ArrayList<SearchObject> tracks = soc.getAllTracks();
        Collections.shuffle(tracks);
        ArrayList<SearchObject> artists = soc.getAllArtists();
        Collections.shuffle(artists);
        ArrayList<SearchObject> genres = soc.getAllGenres();
        Collections.shuffle(genres);
        ArrayList<SearchObject> set = new ArrayList<SearchObject>();
        for (int i = 0; i < 5; i++) {
            set.add(new SearchObject(
                    tracks.get(i).getTrackName(),
                    artists.get(i).getArtistName(),
                    "",
                    genres.get(i).getGenre()
                    ));
        }
        model.addAttribute("suggestions", set);
        return "home"; 
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getAllTracksFromSearch(@RequestParam("search") String search, Model model) {
        if (search.length() > 0) {
            ArrayList<SearchObject> tracks = soc.getAllTracksFromSearch(search);
            model.addAttribute("tracks", tracks);
        }
        else {
            search = "Search field was empty.";
        }
        String message = "Search result for: " + search;
        model.addAttribute("greeting", message);
        return "search";
    } 
}
