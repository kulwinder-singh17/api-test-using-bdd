Feature: Get City Weather details

  @Test
  Scenario Outline: Get current weather of "<City>"
    Given check weather of "<City>" using GET
    Then status code should be 200
    Examples:
      | City   |
      | London |
      | Mexico |
      | Mumbai |