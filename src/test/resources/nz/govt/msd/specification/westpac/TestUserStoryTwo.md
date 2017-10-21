# Test User Story 2 
As a Product Owner  
I want the feature to Convert Currency A to a Currency B and vice versa with the currency converter  
So that The user gets an indication of the exchange rates and makes an informed decision on their foreign transactions  


## Acceptance Criteria
-	User is able to convert 1 NZD to USD successfully
-	User is able to convert 1 USD to NZD successfully
-	User is able to convert 1 Pound Sterling to NZD successfully
-	User is able to convert 1 Swiss Franc To Euro successfully


## [Various Currency Conversion Scenarios](-)
Given a currency  
When I convert to another currency  
Then I can see the conversion details as per below table  

| [convertCurrency][][From Currency][] | [Amount][] | [To Currency][]      | [Result][] |
| ------------------------------------ | ---------- | -------------------- | ---------- |
| New Zealand Dollar                   | 1          | United States Dollar | Passed     |
| United States Dollar                 | 1          | New Zealand Dollar   | Passed     |
| Pound Sterling                       | 1          | New Zealand Dollar   | Passed     |
| Swiss Franc                          | 1          | Euro                 | Passed     |


[From Currency]: - "#from"
[Amount]: - "#amount"
[To Currency]: - "#to"
[convertCurrency]: - "#result = convertCurrency(#from, #amount, #to)"
[Result]: - "?=#result"
