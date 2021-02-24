  
Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|barani_ramachandran255@yahoo.com|25Suresh5!|

@accounts
Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

@accounts
Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6

