package basicframework;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Basic {

	public static void main(String[] args) {
		
		RestAssured.basePath="https://reqres.in/api/users/2";
         RequestSpecification https=RestAssured.given();
            

 		Response resp =https.get();
 		Assert.assertEquals(resp.statusCode(), 200);
 		Assert.assertEquals(resp.statusLine().contains("OK"), true);
        
	}

}
