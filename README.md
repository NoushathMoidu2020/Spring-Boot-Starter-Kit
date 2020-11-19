# SpringBootStarterKit
This code base holds the starter kit for spring boot with swagger enabled and local h2 file as database.
To use this starter kit follow below steps 
1. Clone this project into your ide, preferably intelliJ.
2. Import as gradle project
3. Refresh gradle dependencies
4. Run the SpringBootStarterApplication from the IDE (note it runs on 8080 by default, if that's ocuupied already try to add custom port in application.properties          server.port=PORT_NO)
5. Open a browser and try accessing  http://localhost:8080/h2 login using db details mentioned in application.properties create database use EmployeeDDL.sql to create the sample table
6. Open another tab in browser and try accessing http://localhost:8080/swagger-ui.html and play around the apis


