package com.experis.se.hampus.olsson.MusicDatabase.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.experis.se.hampus.olsson.MusicDatabase.models.SearchObject;

public class SearchObjectRepository {
    private static String url = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    private static Connection connection = null;

    public ArrayList<SearchObject> getAllTracksFromSearch(String searchInput) {
        ArrayList<SearchObject> tracks = new ArrayList<SearchObject>();
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement prepState = connection.prepareStatement("SELECT Track.Name AS tName, Album.Title, Artist.Name AS aName, Genre.Name AS gName FROM Genre INNER JOIN Track ON Track.GenreId=Genre.GenreId INNER JOIN Album ON Track.AlbumId=Album.AlbumId INNER JOIN Artist ON Album.ArtistId=Artist.ArtistId WHERE Track.Name LIKE ?");
            prepState.setString(1,"%" + searchInput + "%");
            ResultSet set = prepState.executeQuery();
            while (set.next()) {
                tracks.add(new SearchObject(
                    set.getString("tName"),
                    set.getString("aName"),
                    set.getString("Title"),
                    set.getString("gName")
                ));
            }
            System.out.println("Fetched all tracks from search.");

        } catch (Exception e) {
            System.out.println("getAllTracksFromSearch method failed.");
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Failed to close connection to Chinnok in getAllTracksFromSearch method.");
            }
        }
        return tracks;
    }

    public ArrayList<SearchObject> getAllUniqueArtists() {
        ArrayList<SearchObject> artists = new ArrayList<SearchObject>();
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement prepState = connection.prepareStatement("SELECT DISTINCT Name FROM Artist");
            ResultSet set = prepState.executeQuery();
            while (set.next()) {
                artists.add(new SearchObject(
                    "",
                    set.getString("Name"),
                    "",
                    ""
                ));
            }
            System.out.println("Fetched all artists.");

        } catch (Exception e) {
            System.out.println("getAllArtists method failed.");
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Failed to close connection to Chinnok in getAllTracksFromSearch method.");
            }
        }
        return artists;
    }

    public ArrayList<SearchObject> getAllUniqueGenres() {
        ArrayList<SearchObject> genres = new ArrayList<SearchObject>();
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement prepState = connection.prepareStatement("SELECT DISTINCT Name FROM Genre");
            ResultSet set = prepState.executeQuery();
            while (set.next()) {
                genres.add(new SearchObject(
                    "",
                    "",
                    "",
                    set.getString("Name")
                ));
            }
            System.out.println("Fetched all genres.");

        } catch (Exception e) {
            System.out.println("getAllGenres method failed.");
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Failed to close connection to Chinnok in getAllTracksFromSearch method.");
            }
        }
        return genres;
    }

    public ArrayList<SearchObject> getAllTracks() {
        ArrayList<SearchObject> tracks = new ArrayList<SearchObject>();
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement prepState = connection.prepareStatement("SELECT Name FROM Track");
            ResultSet set = prepState.executeQuery();
            while (set.next()) {
                tracks.add(new SearchObject(
                    set.getString("Name"),
                    "",
                    "",
                    ""
                ));
            }
            System.out.println("Fetched all tracks.");

        } catch (Exception e) {
            System.out.println("getAllTracks method failed.");
        }
        finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Failed to close connection to Chinnok in getAllTracksFromSearch method.");
            }
        }
        return tracks;
    }
    
}
