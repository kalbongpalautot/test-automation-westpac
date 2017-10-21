# Currency Conversion  
As a Product Owner I want the feature to Convert Currency A to a Currency B and vice versa with the currency converter
So that The user gets an indication of the exchange rates and makes an informed decision on their foreign transactions

## Acceptance Criteria
-	User is able to convert 1 NZD to USD successfully
-	User is able to convert 1 USD to NZD successfully
-	User is able to convert 1 Pound Sterling to NZD successfully
-	User is able to convert 1 Swiss Frack To Euro successfully


## [New Zealand To US Dollar](-)
Given I have [100](- "#amount") [New Zealand Dollar](- "#from")  
When I convert to [US Dollar](- "#to")
Then I can see the conversion [displayed correctly](- "?=convertCurrency(#from, #amount, #to)")