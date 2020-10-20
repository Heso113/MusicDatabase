package com.experis.se.hampus.olsson.MusicDatabase.models;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private int supportRepId;
    private int numbersOfCustomersFromCountry;
    private String favoriteGenre;
   

    

    public Customer() {

    }

    public Customer(int customerId, String firstName, String lastName, 
                    String country, String postalCode, String phoneNumber, int supportRedId) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.supportRepId = supportRedId;
    }

    public Customer(int customerId, String firstName, String lastName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Customer(String country, int numbersOfCustomersFromCountry) {
        this.country = country;
        this.numbersOfCustomersFromCountry = numbersOfCustomersFromCountry;
    
    }
    public Customer(int customerId, String firstName, String lastName, String favoriteGenre) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteGenre = favoriteGenre;
    }
  

	public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSupportRepId() {
        return supportRepId;
    }

    public void setSupportRepId(int supportRepId) {
        this.supportRepId = supportRepId;
    }    
    public int getNumbersOfCustomersFromCountry() {
        return numbersOfCustomersFromCountry;
    }

    public void setNumbersOfCustomersFromCountry(int numbersOfCustomersFromCountry) {
        this.numbersOfCustomersFromCountry = numbersOfCustomersFromCountry;
}

public String getFavoriteGenre() {
    return favoriteGenre;
}

public void setFavoriteGenre(String favoriteGenre) {
    this.favoriteGenre = favoriteGenre;
}
}
