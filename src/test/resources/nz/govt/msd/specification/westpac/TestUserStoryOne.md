# Test User Story One
As a Product Owner  
If there is no amount entered and the convert button is clicked then I want to see an error message “Please enter the amount you want to convert.” on the currency converter page.  
So that The user is able to get a clear indication as to what has to be rectified.  


## Acceptance Criteria
The message “Please enter the amount you want to convert.” is displayed on the screen when convert button is clicked without entering a value in the Enter amount input box



## [Convert Currency With No Amount Specified](-)
Given I am on the currency conversion page    
When I [did not enter a currency and proceed with the conversion](- "convertCurrencyWithNoAmount()")   
Then I can see the error message "[Please enter the amount you want to convert.](- "?=getErrorMessage()")" displayed  
