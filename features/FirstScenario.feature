Feature: Reserve tickets

Scenario: Reserve 1 ticket
Given access the url: http://www.newtours.demoaut.com/
And enter the username
And enter the password
And click on the sign in button
And select the departing city
And select the arriving city
And select the date
And select the class
And set the passengers number
And click on Continue button
And select the flight
And click on Continue button select flight
And enter first and last name
And enter the card number
And enter the passenger name
And click on the Secure Purchase
Then the order is generated