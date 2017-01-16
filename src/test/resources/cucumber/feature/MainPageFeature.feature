Feature: MainPageTests

  Scenario Outline: Check that elements present on Screwfix Main Page
    Given User on Screwfix main page
    Then Element <elementName> found by css selector <elementId>
    Examples:
  |elementName              |elementId                |
  |Your account link        |#header_link_sign_in     |
  |Search button            |#search_submit_button    |
  |Screwfix logo            |#branding-logo           |
  |Tools Menu               |#firstLevelCat_0         |
  |Heating & Plumbing Menu  |#firstLevelCat_1         |
  |Checkout                 |.checkout                |
  |View All Top Brands link |.ViewAllLink             |
  |Contact Us link          |.icon-contact            |
  |Find A Store link        |a[title='Find a Store']  |
  |About Us link            |a[title='About us']      |
