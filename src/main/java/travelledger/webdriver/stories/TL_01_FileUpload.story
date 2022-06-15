Narrative:
Travel Ledger automation tests

Scenario: login as Seller, import Transaction file, validate the upload, login as Buyer, validate Transaction file
Given user is on Login page
Given I login as: "istvan.borbely@prozenda.com" with password: "Prozenda2022"
Given Wait for loading main page
Then Navigate to Import file page
Then Upload transaction file from
Then Commit "ER1234107"
Then Navigate to Bookings page
Then Change dropdown and select Seller - All Due
Then Check "ER1234107" transaction committed
Then Logout
Given I login as: "borbely.istvan.zoltan@gmail.com" with password: "Prozenda2022"
Then Navigate to Bookings page
Then Change dropdown and select Buyer - All Due
Then Check "ER1234107" transaction committed from Buyer side