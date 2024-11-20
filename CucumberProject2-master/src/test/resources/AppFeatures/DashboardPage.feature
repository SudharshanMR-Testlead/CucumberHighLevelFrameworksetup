Feature: Dashboard Page Feature

  Background:
    Given User have already logged into application
      | username | password |
      | Admin    | admin123 |

    Scenario:Dashbodard page title
      Given user is on Dashboard page
      Then user gets the title of the page
      And page title should be "OrangeHRM"

      Scenario:Dashboard Page left panel section count
        Given user is on Dashboard page
        Then user gets leftpanel section
          | Admin       |
          | PIM         |
          | Leave       |
          | Time        |
          | Recruitment |
          | My Info     |
          | Performance |
          | Dashboard   |
          | Directory   |
          | Maintenance |
          | Claim       |
          | Buzz        |
        And Dashboard left panel section count must be 12