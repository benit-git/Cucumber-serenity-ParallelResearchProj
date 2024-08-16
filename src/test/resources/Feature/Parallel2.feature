Feature: Test API Parallel feature2

	Background: this is to test background
	Given First step of test is executed

  @tag11 @tag21
  Scenario: Testind first api serenity scenario2
    When API Get request is called
    When verify the response and display in console
    
    @tag11 @tag22
  Scenario: Testind second api serenity scenario2
    When weather API Get request is called
    When verify the response and display city in console
    
    @tag11 @tag23
  Scenario: Testing Post api serenity scenario2
    Given Post request with name as "Benit" and job as "Scientist"
    When verify the response and display city in console