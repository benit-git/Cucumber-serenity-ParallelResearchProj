Feature: LUMA Project

Background: this is to test background in feature file
	Given Set webdriver and launch site "https://magento.softwaretestingboard.com/"
	
	
@WomenSection
Scenario: Select Women's Tab
	Given Page title as "Home Page"
	Then i select Women's tab
	Then i select Tops
	Then i select Jackets
	Then i select Add to cart
	Then i select Size as "XS"
	Then i select Colour as "Purple"
	Then i click on Add to cart
	Then i click on Cart
	Then i select proceed to checkout
	Then I enter "vids@bulls.com" as the E-mail id
	Then I enter first name as "Vidhi" and last name as "Shetty"
	Then i add current address as "vasai fort"
	Then i add city as "vasai"
	Then i select State as "Florida"
	Then I enter Zip code  as "1234567"
	Then i select Country as "United States"
	Then I enter Phone number as "12345678909"
	Then i select Shipping method
	Then i click on Next
	Then verify payment page is loaded
	Then i verify details as "Vidhi Shetty"
	Then i click on Place Order 
	
@Negative_Scenario
Scenario: Negative scenario
	Given Page title as "Home Page"
	Then i select Women's tab
	Then i select Tops
	Then i select Jackets
	Then i select Add to cart
	Then i select Size as "XS"
	Then i select Colour as "Purple"
	Then i click on Add to cart
	Then i click on Cart
	Then i select proceed to checkout
	Then i select Shipping method
	Then i click on Next
	Then i verify Error messages
	
@Negative_Scenario @vi
Scenario Outline: Negative scenario2
	Given Page title as "Home Page"
	Then i select Women's tab
	Then i select Tops
	Then i select Jackets
	Then i select Add to cart
	Then i select Size as "XS"
	Then i select Colour as "Purple"
	Then i click on Add to cart
	Then i click on Cart
	Then i select proceed to checkout
	Then I enter <Email> as the E-mail id
	Then i select Shipping method
	Then i click on Next
	Then i verify Error message as "emailError"
	Then I enter <Email1> as the E-mail id
	Then i select Shipping method
	Then i click on Next
	Then i verify Email Error message
	
Examples:
	|Email           |Email1	 |Email2		|
	|"vids"          |"vids@bull"|"vids@bulls.c"|
	
@Scenario3
Scenario: Shipping Error Case
	Given Page title as "Home Page"
	Then i select Women's tab
	Then i select Tops
	Then i select Jackets
	Then i select Add to cart
	Then i select Size as "XS"
	Then i select Colour as "Purple"
	Then i click on Add to cart
	Then i click on Cart
	Then i select proceed to checkout
	Then i click on Next
	Then i verify shipping error message
	