## BACKEND CHALLENGE ##

This challenge was made using java and springboot 

- to run the tests you need to enter `mvn test` to run all the tests

### The following considerations where taking on account for the implementation:
- A company has a different budget for meals and gifts and each deposit is done from its own budget. 
  Each time a company want to make a deposit, there is a check to see if there is enough balance to make the operation. 
  After each deposit the balance is update.
  
- A user has also 2 different accounts, one with all the meals deposits and other with gifts deposits. 

- A deposit has an start date and end date and an amount. 
  A deposit can be created with a specific start date, or it will be created by default with the start date corresponding 
  to the date when the transaction was made.
- Everytime a deposit is created, the end date with its specific rule, 365 days for the gifts or the end of february of 
  the following year for the meals.

- The user balance is calculated at a given date to take on account only the deposits that haven't expired yet. 

- to go further it will be good to model the user's expenses to be able to calculate the balance taking on account the 
  expenses made
  