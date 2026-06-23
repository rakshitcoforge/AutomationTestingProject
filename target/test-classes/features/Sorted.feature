@sorted
Feature: Validate sorted functionality 
Scenario: Validate sorted by price

Given user is on search screen 
When user enters "shirt" and click enter
And user select sort by
Then sort is validated