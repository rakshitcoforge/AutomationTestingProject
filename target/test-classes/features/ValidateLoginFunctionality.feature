@login
Feature: Login functionality using otp
Scenario: login via phone number and otp
Given user is home page
When click login button
And user enters phone number "9784264069"  and click continue button
Then otp verification window opens

When user enters otp 
And click on start shoping button
Then user is successfully logged in

