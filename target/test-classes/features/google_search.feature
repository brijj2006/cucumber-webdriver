Feature: google search

  @page_setup @smoke_test
  Scenario: test google search
    Given open application
    When search for item "hello world"
    Then verify element "All" is present on the page

    # ======= END OF SCENARIO =======