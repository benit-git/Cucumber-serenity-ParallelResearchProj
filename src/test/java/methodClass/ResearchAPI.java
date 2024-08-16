package methodClass;


import java.util.HashMap;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ResearchAPI extends baseObjectClass {

	public void largeAPIops() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/photos";
		//RequestSpecification reqsp = RestAssured.given().relaxedHTTPSValidation();
		Response rsp = RestAssured.given().relaxedHTTPSValidation().contentType("/application/json").queryParam("id", "1400").when().get()
				.then().extract().response();
		// Response rsp =
		// given().contentType("/application/json").when().get().then().extract().response();

		setResponse(rsp);

	}

	public void weatherAPIops() {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/photos";
		//RestAssured.given().relaxedHTTPSValidation();
		Response rsp = RestAssured.given().relaxedHTTPSValidation().contentType("/application/json").queryParam("id", "2490").when().get()
				.then().extract().response();
		// Response rsp =
		// given().contentType("/application/json").queryParam("id","2490").when().get().then().extract().response();
		setResponse(rsp);

	}

	public void verifyRsp() {

		Response rsp1 = getResponse();
		rsp1.prettyPrint();
		// System.out.println(rsp1.prettyPrint());
	}

	public void post_req_BDD(String nm, String jobdesc) {
		HashMap queryParams = new HashMap();
		queryParams.put("name", nm);
		queryParams.put("job", jobdesc);

		// json object trial
		JSONObject crunchifyObject = new JSONObject(queryParams);
		System.out.println(crunchifyObject.toString());
		String s= crunchifyObject.toString();
		//with json object body as string
		//Response rsp = SerenityRest.given().baseUri("https://reqres.in/api/users").contentType("application/json").body(crunchifyObject)
		//Hashmap body		
		Response rsp = RestAssured.given().relaxedHTTPSValidation().baseUri("https://reqres.in/api/users").contentType("application/json").body(queryParams)
		.when().post()
		.then().extract().response();
		setResponse(rsp);
	}

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * ResearchAPI ea = new ResearchAPI(); ea.largeAPIops(); ea.verifyRsp(); }
	 */
	
	

}
