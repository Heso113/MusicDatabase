package com.experis.se.hampus.olsson.MusicDatabase;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicDatabaseApplication.class, args);
		connectToDataBase();
	}

	public static boolean connectToDataBase() {
		String url = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
		Connection connection = null;

		try {
			//Open the connection
			connection = DriverManager.getConnection(url);
			System.out.println("Connection to Chinook has been established.");

		} catch (Exception e){
			System.out.println("Failed to connect to Chinook.");
			return false;
		}
		finally {
			try {
				//Close the connection
				connection.close();
			} catch (Exception e) {
				System.out.println("Failed to close connection to Chinook.");
			}
		}
		return true;
	}

}
