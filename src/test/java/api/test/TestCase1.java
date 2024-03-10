package api.test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import api.endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestCase1 {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		Map<String, String> data = new HashMap<String, String>();
		Map<String, Object> bodyData = new HashMap<String, Object>();
		data.put("username", "Test32432432424534434");
		data.put("firstName", "Test3243243242");
		data.put("lastName", "Test32432");
		data.put("email", "Test3243243242324324@test.com");
		data.put("password", "Test3243243242");
		data.put("phone", "3243243242");
		bodyData.put("workload", data);

		Response response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(bodyData.get("workload")).when().post(RestAssured.baseURI + "/user");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);

		 response = given()
				.pathParam("username", "Test32432432424534434")
				.when()
				.get(RestAssured.baseURI + "/user/{username}");
		
		JsonPath jsonathEvaluator = response.jsonPath();
//		System.out.println(jsonathEvaluator.get("lastName"));
		
		

	}
}
