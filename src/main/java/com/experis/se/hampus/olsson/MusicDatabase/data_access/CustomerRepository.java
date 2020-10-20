package com.experis.se.hampus.olsson.MusicDatabase.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.experis.se.hampus.olsson.MusicDatabase.models.Customer;
import com.experis.se.hampus.olsson.MusicDatabase.models.Invoice;


public class CustomerRepository {
    private static String url = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    private static Connection connection = null;
    
    
    public ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        
        try {
			//Open the connection
			connection = DriverManager.getConnection(url);
			System.out.println("Connection to Chinook has been established.");
            PreparedStatement prepState = connection.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, SupportRepId FROM Customer");
            ResultSet set = prepState.executeQuery();
            while(set.next()){
            customers.add(new Customer(
                set.getInt("CustomerId"),
                set.getString("FirstName"),
                set.getString("LastName"),
                set.getString("Country"),
                set.getString("PostalCode"),
                set.getString("Phone"),
                set.getInt("SupportRepId")
                

            ));
            }
            System.out.println("Fetched all customers.");

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
        return customers;
}
public Boolean updateCustomer(Customer customer) {
    Boolean success = false;
    try {
        //Open the connection
        connection = DriverManager.getConnection(url);
        System.out.println("Connection to Chinook has been established.");
        PreparedStatement prepState = connection.prepareStatement("UPDATE Customer SET CustomerId=?, FirstName=?, LastName=?, Country=?, PostalCode=?, Phone=?, SupportRepId=? WHERE CustomerId=?");
            
            prepState.setString(1,Integer.toString(customer.getCustomerId()));
            prepState.setString(2,customer.getFirstName());
            prepState.setString(3,customer.getLastName());
            prepState.setString(4,customer.getCountry());
            prepState.setString(5,customer.getPostalCode());
            prepState.setString(6,customer.getPhoneNumber());
            prepState.setString(7,Integer.toString(customer.getSupportRepId()));
            prepState.setString(8,Integer.toString(customer.getCustomerId()));
            
            int updateResult = prepState.executeUpdate();
            success = (updateResult != 0); 
           
            System.out.println("Update went well!");

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
    return success;
}

public Boolean addCustomer(Customer customer) {
    Boolean success = false;
    try {
        //Open the connection
        connection = DriverManager.getConnection(url);
        System.out.println("Connection to Chinook has been established.");
        PreparedStatement prepState = connection.prepareStatement("INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
           
            prepState.setInt(1,customer.getCustomerId());
            prepState.setString(2,customer.getFirstName());
            prepState.setString(3,customer.getLastName());
            prepState.setString(4,"");
            prepState.setString(5,"");
            prepState.setString(6,"");
            prepState.setString(7,"");
            prepState.setString(8,customer.getCountry());
            prepState.setString(9,customer.getPostalCode());
            prepState.setString(10,customer.getPhoneNumber());
            prepState.setString(11,"");
            prepState.setString(12,"");
            prepState.setInt(13,customer.getSupportRepId());
            
            int addResult = prepState.executeUpdate(); 
            success = (addResult != 0); 
            
            System.out.println("Add went well!");  

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
    return success;
}
    public ArrayList<Customer> getCustomersInEachCountry(){
    ArrayList<Customer> customersCountry = new ArrayList<>();
    
    try {
        //Open the connection
        connection = DriverManager.getConnection(url);
        System.out.println("Connection to Chinook has been established.");
        PreparedStatement prepState = connection.prepareStatement("SELECT Country, COUNT (*) as 'Number' FROM Customer GROUP BY Country ORDER BY COUNT (*) DESC");
        ResultSet set = prepState.executeQuery();
        while(set.next()){
        customersCountry.add(new Customer(
                set.getString("Country"), 
                set.getInt("Number")
               
        ));
        }
        System.out.println("Fetched all customers.");

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
    return customersCountry;
}
    public ArrayList<Invoice> getCustomersTotalInvoice(){
    ArrayList<Invoice> customersInvoice = new ArrayList<>();
    
    try {
        //Open the connection
        connection = DriverManager.getConnection(url);
        System.out.println("Connection to Chinook has been established.");
        PreparedStatement prepState = connection.prepareStatement("SELECT CustomerId, SUM (Total) AS tot FROM INVOICE GROUP BY CustomerId ORDER BY tot DESC");
        ResultSet set = prepState.executeQuery();
        while(set.next()){
            customersInvoice.add(new Invoice(
                
                0,set.getInt("CustomerId"),
                null, null, null, null, null, null, set.getDouble("tot")
        ));
        }
        System.out.println("Fetched all invoices.");

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
    return customersInvoice;
}

public Customer getCustomerGenre(int id) {
    Customer newCustomer = null;
    try {
        //Open the connection
        connection = DriverManager.getConnection(url);
        System.out.println("Connection to Chinook has been established.");
        PreparedStatement prepState = connection.prepareStatement("SELECT Customer.FirstName AS firstname, Customer.LastName AS lastname, Genre.Name AS genre, SUM (InvoiceLine.Quantity) AS quantity FROM Customer, Invoice, InvoiceLine, Track, Genre WHERE Customer.CustomerId = Invoice.CustomerId AND Invoice.InvoiceId = InvoiceLine.InvoiceId AND InvoiceLine.TrackId = Track.TrackId AND Track.GenreId = Genre.GenreId AND Customer.CustomerId= ? GROUP BY firstname, lastname, genre, quantity ORDER BY quantity DESC LIMIT 1");
        prepState.setInt(1, id);
        ResultSet set = prepState.executeQuery();
        newCustomer = new Customer(
                id, 
                set.getString("firstname"),
                set.getString("lastname"),
                set.getString("genre")
           
        );
        System.out.println("Fetched specific customer.");

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




