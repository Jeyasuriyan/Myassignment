Feature: Validate the signup functionality to ParaBank

  #Reference link
  #https://www.toolsqa.com/cucumber/maps-in-data-tables/
  #Its working properly
  #checking
  @regression
  Scenario: Validate the signup functionality to ParaBank
    Given user click register link from the Homepage
    When user enter the FirstName, LastName, Address, City, State, Zipcode, PhoneNo, SSN, UserName, Password, Confirm
      | jeyasuriyass | A V | 1st street | Madurai | Tamil Nadu | 12345 | 9876543120 | 345 | maara | 123 | 123 |
    And click on register button
    Then message "Your account was created successfully. You are now logged in." should be displayed in welcome page

    #checking
  @withoutheadermultirow
    #Again it will execute as a single user registration
  Scenario: Validate the signup functionality to ParaBank
    Given user click register link from the Homepage
    When user enter the FirstName, LastName, Address, City, State, Zipcode, PhoneNo, SSN, UserName, Password, Confirm with multi row
      | jeyasuriyan | A V | 1st street | Madurai | Tamil Nadu | 12345 | 9876543120 | 345 | maara | 123 | 123 |
      | jeyasuriyan | A V | 1st street | Madurai | Tamil Nadu | 12345 | 9876543120 | 345 | maara | 123 | 123 |
    And click on register button
    Then message "Your account was created successfully. You are now logged in." should be displayed in welcome page

  @withheaderbyindex
    #Its working properly
  Scenario: Validate the signup functionality to ParaBank
    Given user click register link from the Homepage
    When user enter the FirstName, LastName with Header by using index
      | FirstName   | LastName | Address    | City    | State      | Zipcode | PhoneNo    | SSN | UserName | Password | Confirm |
      | jeyasuriyan | A V      | 1st street | Madurai | Tamil Nadu | 12345   | 9876543120 | 345 | dhanush  | 123      | 123     |
    And click on register button
    Then message "Your account was created successfully. You are now logged in." should be displayed in welcome page

  @withheaderbyfor
    #Its executing as a single user registration
  Scenario: Validate the signup functionality to ParaBank
    Given user click register link from the Homepage
    When user enter the FirstName, LastName with Header and getting the data using for loop and keyword
      | FirstName   | LastName | Address    | City    | State      | Zipcode | PhoneNo    | SSN | UserName  | Password | Confirm |
      | jeyasuriyan | A V      | 1st street | Madurai | Tamil Nadu | 12345   | 9876543120 | 345 | vijay     | 123      | 123     |
      | jeyasuriyan | A V      | 1st street | Madurai | Tamil Nadu | 12345   | 9876543120 | 345 | vijay two | 123      | 123     |
    And click on register button
    Then message "Your account was created successfully. You are now logged in." should be displayed in welcome page

  @classobjects
      #facing error while converting datatable to list
  Scenario: Validate the signup functionality to ParaBank
    Given user click register link from the Homepage
    When user enter the FirstName, LastName with Header and getting the data using Class objects
      | FirstName   | LastName | Address    | City    | State      | Zipcode | PhoneNo    | SSN | UserName   | Password | Confirm |
      | jeyasuriyan | A V      | 1st street | Madurai | Tamil Nadu | 12345   | 9876543120 | 345 | suryaa     | 123      | 123     |
      | jeyasuriyan | A V      | 1st street | Madurai | Tamil Nadu | 12345   | 9876543120 | 345 | suryaa two | 123      | 123     |
    And click on register button
    Then message "Your account was created successfully. You are now logged in." should be displayed in welcome page

    #Reference link
    #https://stackoverflow.com/questions/20623338/what-is-the-regular-expression-for-cucumber-data-table
  #Its working properly
  @scenariooutline
  Scenario Outline: Validate the signup functionality to ParaBank with datatable
    Given user click register link from the Homepage
    When user enter the "<FirstName>", "<LastName>", "<Address>", "<City>", "<State>", "<Zipcode>", "<PhoneNo>", "<SSN>", "<UserName>", "<Password>" and "<Confirm>"
    And click on register button
    Then message "Your account was created successfully. You are now logged in." should be displayed in welcome page
    Examples:
      | FirstName     | LastName | Address    | City    | State      | Zipcode | PhoneNo    | SSN | UserName  | Password | Confirm |
      | jeyasuriyan   | A V      | 1st street | Madurai | Tamil Nadu | 12345   | 9876543120 | 345 | anandhu   | 123      | 123     |
      | jeyasuriyanss | A V      | 1st street | Madurai | Tamil Nadu | 12345   | 9876543120 | 345 | anandhu s | 123      | 123     |