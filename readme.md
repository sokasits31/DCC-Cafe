# Steve Sokasits Individual Project

## Problem Statement
Door Creek Church runs a small Coffee/Cafe that serves worshipers mostly
on weekend services. The cafe is staffed by a paid manager and voluenteers
and the menu consists of the follow catagories:
 
 * Espresso Drinks
 * Frozen Drinks
 * Brewed Coffee Drinks
 * Tea Drinks
 * Cold Bottled Drinks
 * Bakery/Food Items
 
Since the manager is expected to oversee everthing.  Volunteers are 
expected to be able to run the cash register.  Since volunteers don't
work every weekend, it hard for them to remember how to ring up
transactions.  This could cause unneed stess on volunteers, excespecially 
during a busy Sunday Service.  

This stress impacts customer service and deter individuals from helping
 out in the cafe.
 
To help volunteers gain a better comfort level prior to serving, I
have created the DCC Cafe Simulator.  This simulator will allow 
volunteers to create a user account and test/master thier cash register
skills.  This app should imporve customer service and boost volunteers
that want to serve in the cafe.


### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: View Volunteer info, test scores and update simuator screens
  * User or volunteer role: update profile info and take test
* Database
  * MySQL
  * Store users and roles
  * Store all data for menu item and user info
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * AWS email service
  * Maybe allow Google/Facebook to log into account
* CSS 
  * Bootstrap or Materialize
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * CI tools in AWS
  * Materialize
  * Google Maps API
  * Hibernate Validation
  * Hibernat Search
* Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA


### Design

* 
[Screen Design](https://github.com/sokasits31/DCC-Cafe/screenDesigns/screenDesign.md)

[Database Design](DesignDocuments/databaseDiagram.png)

### [Project Plan](ProjectPlan.md)

### [Development Journal](Journal.md)