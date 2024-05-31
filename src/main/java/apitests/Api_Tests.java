package apitests;

import java.io.IOException;

import org.testng.annotations.Test;

import api_utils.Api_CommonUtils;
import api_utils.Api_FileUtils;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Api_Tests extends Api_BaseTest{
	protected static String token1="";
	
	
	@Test(priority=-1)
	public void verifyLogin() throws IOException {
		RestAssured.baseURI=Api_FileUtils.readapiLoginTestDatAsString("$.uri.login");
		Response login=request.login(Api_FileUtils.readapiLoginTestDatAsString("$.headers.login.header1"), 
				Api_FileUtils.readApiLoginTestdataAsObject("$.headers.login.value1"), Api_FileUtils.readApiLoginTestdataAsObject("$.body.login"), 
				Api_FileUtils.readapiLoginTestDatAsString("$.endpoint.login"));
		token1=login.jsonPath().getString("token").replace("[", "").replace("]", "");
		System.out.println(token1);
		System.out.println(login.asPrettyString());
	}
	
	
	@Test(enabled=false)
	public void verifyGetData() throws IOException {
		Response getdatarequest=request.getdata(Api_FileUtils.readapiGetTestDatAsString("$.headers.login.header1"), 
				Api_FileUtils.readApiGetTestdataAsObject("$.headers.login.value1"), Api_FileUtils.readapiGetTestDatAsString("$.headers.login.header2"), 
				request.getToken(), Api_FileUtils.readapiGetTestDatAsString("$.endpoint.getdata"));
		System.out.println(getdatarequest.getStatusCode());
		//System.out.println(getdatarequest.asPrettyString());
	}
	
	
	@Test
	public void verifyAddData() throws IOException {
		Header h1=new Header("Content-Type","application/json");
		  Header h2=new Header("token",token1);
		  Headers newh1andh2=new Headers(h1,h2);
		Response adddatarequest=request.addData(newh1andh2,jString , Api_FileUtils.readapiAddTestDataAsString("$.endpoint.adddata"));
		System.out.println(jString);
		 
		System.out.println(newh1andh2.toString());
		System.out.println(adddatarequest.getStatusCode());
		System.out.println(adddatarequest.asPrettyString());
	}
}



