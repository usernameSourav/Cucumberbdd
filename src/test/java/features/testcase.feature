Feature: Search and place the order
@seleniumTest
Scenario: Search for items and validate results
Given User is in Greenkart Landing Page
When User search for "Cashews" in the search box
Then "Cashews" results displayed

@seleniumTest
Scenario: Search for item and proceed to checkout
Given User is in Greenkart Landing Page
When User search for "Water Melon" in the search box
And Added items to cart
And User proceed to Checkout Page
Then Verify the selected "Water Melon" are  displayed in checkout page
