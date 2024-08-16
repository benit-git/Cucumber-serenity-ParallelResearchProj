package methodClass;

import io.restassured.response.Response;

public class baseObjectClass {
	private static Response apiRsp = null;

	
	public void setResponse(Response rsp)
	{
		apiRsp = rsp;
	}
	
	public Response getResponse()
	{
		return apiRsp;
	}
}
