@sort
Feature: Validate sort functionality 
Scenario: Validate sort by price
Given user is home page
When click login button
And user enters phone number "9784264069"  and click continue button
Then otp verification window opens

When user enters otp 
And click on start shoping button
Then user is successfully logged in

Given user is on search screen 
When user enters "shirt" and click enter
And user select sort by
Then sort is validated