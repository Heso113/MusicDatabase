package com.experis.se.hampus.olsson.MusicDatabase.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.experis.se.hampus.olsson.MusicDatabase.models.Customer;

public class CustomerRepository {
    private static String url = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    private static Connection connection = null;
    
    
    public Customer getCustomerFromId(int id) {
        Customer newCustomer = null;
        try {
			//Open the connection
			connection = DriverManager.getConnection(url);
			System.out.println("Connection to Chinook has been established.");
            PreparedStatement prepState = connection.prepareStatement("SELECT CustomerId, FirstName, LastName FROM Customer WHERE CustomerId=?");
            prepState.setInt(1, id);
            ResultSet set = prepState.executeQuery();
            newCustomer = new Customer(
                set.getInt("CustomerId"),
                set.getString("FirstName"),
                set.getString("LastName")
            );
            System.out.println("Fetched new customer.");

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
        return newCustomer;
    }

}
