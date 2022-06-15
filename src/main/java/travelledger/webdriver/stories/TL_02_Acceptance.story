Narrative:
Travel Ledger automation tests

Scenario: login as Seller, import Transaction file, validate the upload, login as Buyer, validate Transaction file
Given user is on Login page
Given I login as: "borbely.istvan.zoltan@gmail.com" with password: "Prozenda2022"
Given Wait for loading main page
Then Change dropdown and select Buyer - All Due
Then Filter for "ER1234105" booking reference
Then Check that transaction status dropdown has proper elements for "ER1234105"
Then Click on the "ER1234105" transaction status which has blank status and select ACCEPTED status