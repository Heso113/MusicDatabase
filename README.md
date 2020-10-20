# MusicDatabase
This is a web application created with Spring Boot and Spring Initializr which contains a Thymeleaf templated engine. The application use a SQLite JDBC database called [Chinook](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc), which is a music database. The database consist of multiple tables which are represented [here](https://www.codestencil.com/database/chinook-database-schema) and [here](https://www.sqlitetutorial.net/sqlite-sample-database/). This application was developed as part of a full stack course at [Experis Academy](https://experisacademy.se/).

# Website
The homepage can be accessed on http://localhost:8080/home when the application is running. The website has two views: the home-view and the search-view. The home-view lists five random artists, tracks and genres as a suggestion for the user to check out.  The home-view also features a search function where the user can enter a phrase in order to find each track in the database that contain the given phrase. The search function will take the user to the search-view where the user will find information about each track that was found in the database. Screenshots of the two views can be found below.

<img width="346" alt="home-view" src="https://user-images.githubusercontent.com/21289637/96583875-afb6d780-12dd-11eb-9463-a6a155826331.PNG">


<img width="957" alt="search-view" src="https://user-images.githubusercontent.com/21289637/96583928-c3fad480-12dd-11eb-90cb-9c049bdd992c.PNG">

# API-endpoints
For this application a couple of endpoints was exposed which can be tested with postman. A collection of postman api calls can be found in the "Apicalls.postman_collection.json". Each endpoint returns its data in json format.

## /api/fetch/customers
 - Returns information about each customer in the database

## /api/update/customer
 - Updates the information of a customer in the database
 
## /api/create/customer
 - Creates a new customer and adds it to the database
 
## /api/fetch/countrystats
 - Fetch the number of customers from each country
 
## /api/fetch/customers/invoice
 - Fetch the total spendings of all customers
 
## api/fetch/customer/favoritegenre/{id}
 - Fetch the favorite genre of a given customer

## /api/fetch/tracksfromsearch/
 - Fetches each track that contain the given search phrase in its name

## /api/fetch/artists/
 - Fetches the name of each artist in the database
 
## /api/fetch/genres/
 - Fetches the name of each genre in the database
 
## /api/fetch/tracks/
 - Fetches the name of each track in the database


# Goals with this application
 - Expose endpoints with Spring
 - Create a templated html page with templated data
 - Introduction to SQL queries (SELECT, JOIN, etc.)
 
 
This application was developed by [Christopher Berglund](https://github.com/cberg9) & [Hampus Olsson](https://github.com/Heso113) 
