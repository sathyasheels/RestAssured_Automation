package apitests;
import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.google.gson.*;

import api_utils.Api_FileUtils;

public class Api_LoginTestOld extends Api_BaseTest{
	String token1="";
	
	@Test(enabled=false)
	public void verifyLogin() {
		RestAssured.baseURI="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";
		Response loginrequest=RestAssured.given().header("Content-Type","application/json").
				body("{\"username\":\"stella@tekarch.com\",\"password\":\"Admin123\"}").when().post("login").
				then().statusCode(201).extract().response();
		System.out.println(loginrequest.asPrettyString());
		//System.out.println(loginrequest.jsonPath().getString("token").replace("[", "").replace("]", ""));
		token1=loginrequest.jsonPath().getString("token").replace("[", "").replace("]", "");
		
	}
	
	@Test(enabled=false)
	public void verifyLogin1() throws IOException {
		RestAssured.baseURI="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";
		//HashMap<String,String> hmbody=new HashMap<String,String>();
		//hmbody.put("username","stella@tekarch.com");
		//hmbody.put("password","Admin123");
		
		HashMap<String,String>hmheader=new HashMap<String,String>();
		hmheader.put("Content-Type","application/json");
		Response login=request.login(hmheader,Api_FileUtils.readApiLoginTestdataAsObject("$.body.login"),
				Api_FileUtils.readapiLoginTestDatAsString("$.endpoint.login"));
		token1=login.jsonPath().getString("token").replace("[", "").replace("]", "");
		System.out.println(login.asPrettyString());
		//Assert.assertEquals(login.statusCode(), 201);//TestNG assertion
		//login.then().assertThat().statusCode(201);//RestAssured assertion
	}
	
	
	@Test(enabled=false)
	public void verifyLogin2() throws IOException {
		RestAssured.baseURI=Api_FileUtils.readapiLoginTestDatAsString("$.uri.login");
		Response login=request.login(Api_FileUtils.readapiLoginTestDatAsString("$.headers.login.header1"), 
				Api_FileUtils.readApiLoginTestdataAsObject("$.headers.login.value1"), Api_FileUtils.readApiLoginTestdataAsObject("$.body.login"), 
				Api_FileUtils.readapiLoginTestDatAsString("$.endpoint.login"));
		token1=login.jsonPath().getString("token").replace("[", "").replace("]", "");
		System.out.println(login.asPrettyString());
	}
	
	
	@Test(enabled=false)
	public void verifyGetData() {
		
		Response getdatarequest=RestAssured.given().header("Content-Type","application/json").header("token",token1).
				when().get("getdata").then().statusCode(200).extract().response();
		System.out.println(getdatarequest.asPrettyString());
	}
	
	
	@Test(enabled=false)
	public void verifyGetData1() throws IOException {
		Response getdatarequest=request.getdata(Api_FileUtils.readapiGetTestDatAsString("$.headers.login.header1"), 
				Api_FileUtils.readApiGetTestdataAsObject("$.headers.login.value1"), Api_FileUtils.readapiGetTestDatAsString("$.headers.login.header2"), 
				token1, Api_FileUtils.readapiGetTestDatAsString("$.endpoint.getdata"));
		System.out.println(getdatarequest.getStatusCode());
		//System.out.println(getdatarequest.asPrettyString());
	}
	
	@Test(enabled=false)
	public void verifyAddUsers_usingHashMap() {
		HashMap<String,String> hmbody=new HashMap<String,String>();
		hmbody.put("accountno","TA-5670127");
		hmbody.put("departmentno","5");
		hmbody.put("salary","90700");
		hmbody.put("pincode","567007");
		
		HashMap<String,String>hmheader=new HashMap<String,String>();
		hmheader.put("Content-Type","application/json");
		hmheader.put("token",token1);
		
		//Response adddatarequest=RestAssured.given().header("Content-Type","application/json").header("token",token).
				//body("{\"accountno\":\"TA-5670117\",\"departmentno\": \"5\",\"salary\": \"90700\",\"pincode\": \"567007\"}").when().post("addData").
				//then().statusCode(201).extract().response();
		Response adddatarequest=RestAssured.given().headers(hmheader).body(hmbody).when().post("addData").
				then().statusCode(201).extract().response();
		System.out.println(adddatarequest.asPrettyString());
	}
	
	
	@Test(enabled=false)
	public void verifyAddUsers_usingJsonObject() {
		JsonObject jsbody=new JsonObject();
		jsbody.addProperty("accountno","TA-5670127");
		jsbody.addProperty("departmentno","5");
		jsbody.addProperty("salary","90700");
		jsbody.addProperty("pincode","567007");
		
		JsonObject jsheader=new JsonObject();
		jsheader.addProperty("Content-Type","application/json");
		jsheader.addProperty("token", token1);
		
		//Response adddatarequest=RestAssured.given().headers(jsheader).body(jsbody).when().post("addData").
				//then().statusCode(201).extract().response();
		//System.out.println(adddatarequest.asPrettyString());
		
		
		
		
	}
	
}
