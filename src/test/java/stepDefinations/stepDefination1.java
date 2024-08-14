package stepDefinations;

import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import methodClass.BaseClass;
import methodClass.CheckoutClass;
import methodClass.HomePage;
import methodClass.JacketsWomen;
import methodClass.LightJacket;

public class stepDefination1 {

	HomePage hobj = new HomePage();
	JacketsWomen jobj = new JacketsWomen();
	LightJacket ljobj = new LightJacket();
	CheckoutClass cobj = new CheckoutClass();
	BaseClass bobj = new BaseClass();

	@Given("^Set webdriver and launch site \"([^\"]*)\"$")
	public void set_webdriver_and_launch_site(String site) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		hobj.launch_site(site);

	}

	@Given("^Page title as \"([^\"]*)\"$")
	public void page_title(String t) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		hobj.homeTitle(t);
	}

	@Then("^i select Women's tab$")
	public void i_select_Women_s_tab() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		hobj.select_women_section();
	}

	@Then("^i select Tops$")
	public void i_select_Tops() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		hobj.select_tops();
	}

	@Then("^i select Jackets$")
	public void i_select_Jackets_dropdown() throws Throwable {
		hobj.select_jackets();
	}

	@Then("^i select Add to cart$")
	public void i_select_Add_to_cart() throws Throwable {
		jobj.select_1st_jacket();
	}

	@Then("^i select Size as \"([^\"]*)\"$")
	public void i_select_Size_as(String size) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ljobj.jacketSize("XS");
	}

	@Then("^i select Colour as \"([^\"]*)\"$")
	public void i_select_Colour_as(String color) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ljobj.jacketColor("Purple");
	}

	@Then("^i click on Add to cart$")
	public void i_click_on_Add_to_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ljobj.addToCart();
	}

	@Then("^i click on Cart$")
	public void i_click_on_Cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ljobj.goToCart();
	}

	@Then("^i select proceed to checkout$")
	public void i_select_proceed_to_checkout() throws Throwable {
		ljobj.checkout();
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^I enter \"([^\"]*)\" as the E-mail id$")
	public void i_enter_as_the_E_mail_id(String email) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cobj.enter_email(email);
	}

	@Then("^I enter first name as \"([^\"]*)\" and last name as \"([^\"]*)\"$")
	public void i_enter_first_name_as_and_last_name_as(String fname, String lname) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cobj.fName(fname);
		cobj.lName(lname);
	}

	@Then("^i add current address as \"([^\"]*)\"$")
	public void i_add_current_address_as(String addrs) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cobj.streetAddress(addrs);
	}

	@Then("^i add city as \"([^\"]*)\"$")
	public void i_add_city_as(String cityname) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cobj.cityName(cityname);
	}

	@Then("^i select State as \"([^\"]*)\"$")
	public void i_select_State_as(String state) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cobj.selectState(state);
	}

	@Then("^I enter Zip code  as \"([^\"]*)\"$")
	public void i_enter_Zip_code_as(String zip) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cobj.addZipCode(zip);
	}

	@Then("^i select Country as \"([^\"]*)\"$")
	public void i_select_Country_as(String country) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cobj.addCountry(country);
	}

	@Then("^I enter Phone number as \"([^\"]*)\"$")
	public void i_enter_Phone_number_as(String number) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cobj.addPhoneNumber(number);
	}

	@Then("^i select Shipping method$")
	public void i_select_Shipping_method() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cobj.shippingCharge();
	}

	@Then("^i click on Next$")
	public void i_click_on_Next() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cobj.nextPage();
	}

	@Then("^verify payment page is loaded$")
	public void payment_page_loaded() throws Throwable {
		cobj.paymentPageIsLoaded();
	}

	@Then("^i verify details as \"([^\"]*)\"$")
	public void i_verify_detail(String fname) throws Throwable {
		cobj.verifyDetail(fname);
	}

	@Then("^i click on Place Order$")
	public void i_click_on_Place_Order() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^i verify Error messages$")
	public void i_verify_Error_messages() throws Throwable {
		cobj.verifyErrorMsgs();

	}

	@Then("^i verify Error message as \"([^\"]*)\"$")
	public void i_verify_Error_messages_as(String err) throws Throwable {
		cobj.verifyErrorMsgs(err);
	}

	@Before
	public void before(Scenario scenario)
	{
		System.out.println("before hook");
		bobj.scene = scenario;
	}
	
	@After
	public void quitdriver(Scenario scenario) {
		System.out.println("bye - after hook");
		if(scenario.isFailed())
		bobj.screensht(scenario);
		cobj.quitDriver();
	}

	@Then("^i verify shipping error message$")
	public void i_verify_shipping_error_message() throws Throwable {
		cobj.verifyErrorMsgs();
	}

}
