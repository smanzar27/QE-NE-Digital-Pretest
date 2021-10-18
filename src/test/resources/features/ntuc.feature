@GUI @Test @TC
Feature: NTUC NEDigital QE PRETEST
  Description: QE NE Digital Pretest

  Background: Opens TestCafe Example Webpage
    Given the user open testcafe example webpage and validates page title

  Scenario: verify by default submit button is disable until user enters any name or click populate button
    Then the user validates submit element is disable
    When the user enters name as test user
    And the user validates submit element is enable
    When the user clear the name field
    And the user validates submit element is disable
    And the user clicks on Populate button
    Then the user validates the pop up message and clicks OK
    And the user validates submit element is enable
    And the user submit the example page
    Then the user validate thank you webpage title

  Scenario Outline: verify by default rating and comment are disable until user clicks on testcafe checkbox
    Then the user validates rating element is disable
    And the user validates comment element is disable
    When the user click on TestCafe Checkbox
    Then the user validates rating element is enable
    And the user validates comment element is enable
    Then the user validates 1-10 rating options are displayed
    And the user select rating as <rating> and add comment
    And the user click on TestCafe Checkbox
    Then the user validates rating element is disable
    And the user validates comment element is disable
    And the user click on TestCafe Checkbox
    And the user verify rating as <rating> and add comment
    Examples:
      | rating  |
      | 10      |
      | 1       |
      | 5       |

  Scenario: verify user can multi select important features
    Given the user validates find following important features
      | featureList                                                         |
      | Support for testing on remote devices                               |
      | Re-using existing JavaScript code for testing                       |
      | Running tests in background and/or in parallel in multiple browsers |
      | Easy embedding into a Continuous integration system                 |
      | Advanced traffic and markup analysis                                |
    When the user validates select following important features
      | featureList                                   |
      | Support for testing on remote devices         |
      | Re-using existing JavaScript code for testing |
    When the user validates selected following important features
      | featureList                                   |
      | Support for testing on remote devices         |
      | Re-using existing JavaScript code for testing |

  Scenario: verify user can select an operating system
    Given the user validates find following operating system
      | OSList  |
      | Windows |
      | MacOS   |
      | Linux   |
    When the user validates select following operating system
      | OSList |
      | Linux  |
    Then the user validates selected following operating system
      | OSList |
      | Linux  |

  Scenario: verify user can select testcafe interface
    Given the user validates find following interface
      | interfaceList  |
      | Command Line   |
      | JavaScript API |
      | Both           |
    When the user validates select following interface
      | interfaceList  |
      | JavaScript API |
    Then the user validates selected following interface
      | interfaceList  |
      | JavaScript API |


  Scenario: verify user entered name gets displayed on thanks page on clicking submit button
    When the user enters name as Test User
    And the user submit the example page
    Then the user validate thank you webpage title
    And the user validates message on thank page for Test User

  Scenario: verify system default user name gets displayed on thanks page when populate and submit button are click in sequence
    When the user clicks on Populate button
    And the user validates the pop up message and clicks OK
    And the user validates the default name is displayed as Peter Parker
    When the user submit the example page
    Then the user validate thank you webpage title
    And the user validates message on thank page for Peter Parker

  Scenario: verify testcafe.io web app get open by clicking testcafe link on thanks page
    When the user enters name as Test User
    And the user submit the example page
    Then the user validate thank you webpage title
    And the user validates message on thank page for Test User
    And the user click on href link for more detail TestCafe Application
    And the user validate TestCafe Web Application webpage title


  Scenario: verify e2e testcafe application functionality for user entered name
    When the user enters name as Test User
    And the user click on TestCafe Checkbox
    And the user select rating as 4 and add comment
    And the user validates select following important features
      | featureList                                   |
      | Support for testing on remote devices         |
      | Re-using existing JavaScript code for testing |
    And the user validates select following operating system
      | OSList |
      | Linux  |
    And the user validates select following interface
      | interfaceList  |
      | JavaScript API |
    And the user submit the example page
    Then the user validates message on thank page for Test User
    Then the user validate thank you webpage title
    And the user click on href link for more detail TestCafe Application
    And the user validate TestCafe Web Application webpage title



  Scenario: verify e2e testcafe application functionality for default system entered name
    When the user clicks on Populate button
    Then the user validates the pop up message and clicks OK
    And the user click on TestCafe Checkbox
    And the user select rating as 6 and add comment
    And the user validates select following important features
      | featureList                                   |
      | Support for testing on remote devices         |
      | Re-using existing JavaScript code for testing |
    And the user validates select following operating system
      | OSList |
      | Linux  |
    And the user validates select following interface
      | interfaceList  |
      | JavaScript API |
    And the user submit the example page
    Then the user validates message on thank page for Peter Parker
    Then the user validate thank you webpage title
    And the user click on href link for more detail TestCafe Application
    And the user validate TestCafe Web Application webpage title
