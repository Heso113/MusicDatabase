package com.experis.se.hampus.olsson.MusicDatabase.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.experis.se.hampus.olsson.MusicDatabase.models.Track;

public class TrackRepository {
    private static String url = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    private static Connection connection = null;
    
    
    public Track getTrackFromId(int id) {
        Track track = null;
        try {
			//Open the connection
			connection = DriverManager.getConnection(url);
			System.out.println("Connection to Chinook has been established.");
            PreparedStatement prepState = connection.prepareStatement("SELECT TrackId, Name, AlbumId, GenreId FROM Track WHERE TrackId=?");
            prepState.setInt(1, id);
            ResultSet set = prepState.executeQuery();
            track = new Track(
                set.getInt("TrackId"),
                set.getString("Name"),
                set.getInt("AlbumId"),
                set.getInt("GenreId")
            );
            System.out.println("Fetched new Track.");

		} catch (Exception e){
			System.out.println("Failed to connect to Chinook.");
		}
		finally {
			try {
				//Close the connection
				connection.close();
			} catch (Exception e) {
				System.out.println("Failed to close connection to Chinook.");
			}
        }
        return track;
    }

    public ArrayList<Track> getAllTracks() {
        ArrayList<Track> tracks = new ArrayList<Track>();
        try {
			//Open the connection
			connection = DriverManager.getConnection(url);
			System.out.println("Connection to Chinook has been established.");
            PreparedStatement prepState = connection.prepareStatement("SELECT TrackId, Name, AlbumId, GenreId FROM Track");
            ResultSet set = prepState.executeQuery();
            while (set.next()) {
                tracks.add(new Track(
                        set.getInt("TrackId"),
                        set.getString("Name"),
                        set.getInt("AlbumId"),
                        set.getInt("GenreId")));
            }
            System.out.println("Fetched all Tracks.");
		} catch (Exception e){
			System.out.println("Failed to connect to Chinook.");
		}
		finally {
			try {
				//Close the connection
				connection.close();
			} catch (Exception e) {
				System.out.println("Failed to close connection to Chinook.");
			}
        }
        return tracks;
    }
}
