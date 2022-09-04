import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo1 {
 
   private String baseurl="https://reqres.in/api/users/2";	 
   private Response resp;	
   
   public Response set() {
		RestAssured.baseURI=baseurl;
			
		return RestAssured.given().get();
				}
	@BeforeClass	
		public void setup() {
			
			resp=set();
		} 
	@Test(priority = 1)	
	public void verifystatuscode() {
		
		Assert.assertEquals(resp.getStatusCode(),200);
	}	
	
	@Test(priority = 2)
	public void validateStatusLine() {
		Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 200 OK");
	}

	
	@Test(priority = 4)
	public void validateLastNameInResponseBody() {
		
		Assert.assertEquals(resp.jsonPath().getString("Lastname"), true );
	}
		
}