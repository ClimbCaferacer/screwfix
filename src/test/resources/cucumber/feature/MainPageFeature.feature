Feature: MainPageTests

#  Scenario Outline: Check that elements present on Screwfix Main Page
#    Given User on Screwfix main page
#    Then Element <elementName> found by css selector <elementId>
#    Examples:
#  |elementName              |elementId                |
#  |Your account link        |#header_link_sign_in     |
#  |Search button            |#search_submit_button    |
#  |Screwfix logo            |#branding-logo           |
#  |Tools Menu               |#firstLevelCat_0         |
#  |Heating & Plumbing Menu  |#firstLevelCat_1         |
#  |Checkout                 |.checkout                |
#  |View All Top Brands link |.ViewAllLink             |
#  |Contact Us link          |.icon-contact            |
#  |Find A Store link        |a[title='Find a Store']  |
#  |About Us link            |a[title='About us']      |


    Scenario: Register user through basket
      Given User on Screwfix main page
      When User search for "THERMOMETER"
      Then "TPI 343 K-Type Digital Thermometer" found in product table
      When User click on "Deliver" button
      Then "TPI 343 K-Type Digital Thermometer" added to basket for delivery
      And Click on "Continue shopping" button
      When User search for "22622"
      Then "EURAMAX S LH DOUBLE-GLAZED UPVC WINDOW CLEAR 620 X 1050MM" found by product code
      When User click on "Deliver" button
      Then "EURAMAX S LH DOUBLE-GLAZED UPVC WINDOW CLEAR 620 X 1050MM" added to basket for delivery
      And Click on "Checkout now" button
      When User on the trolley page with 2 items in it
      Then Click on "Continue payment" button
      When User on sign in page
      Then Click on "Register now" button
      When User on registration page
      Then User enter email
      And Click on "Continue" button
      When User on registration page after adding email
      Then User fills registration info
      |Fields     |Value                                                                      |
      |Title      |Mr                                                                         |
      |FirstName  |ANY                                                                        |
      |LastName   |ANY                                                                        |
      |PostalCode |ba22 8rt                                                                   |
      |Password   |abc12345                                                                   |
      |Address    |Thrifty, Mead Avenue, Houndstone Business Park, YEOVIL, Somerset BA22 8RT  |
      |Profession |DIY                                                                        |
