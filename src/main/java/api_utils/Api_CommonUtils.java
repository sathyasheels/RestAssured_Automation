package api_utils;

import java.util.HashMap;

import apitests.Api_Tests;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Api_CommonUtils extends Api_Tests{
	
	/*//both headers and body are HashMap
	public Response login(HashMap<String,String> hmheader,HashMap<String,String> hmbody,String endpoint) {
		return RestAssured.given().headers(hmheader).body(hmbody).when().post(endpoint);
	}*/
	
	
	//header is hashMap and body is object
	public Response login(HashMap<String,String> hmheader,Object body,String endpoint) {
		return RestAssured.given().headers(hmheader).body(body).when().post(endpoint);
	}
	
	//headers are string and object and body is object
	public Response login(String headers,Object values,Object body,String endpoint) {
		return RestAssured.given().headers(headers,values).body(body).when().post(endpoint);
	}
	
	public String getToken() {
		return token1;
	}
	
	public Response getdata(String header1,Object value1,String header2,Object value2,String endpoint) {
		return RestAssured.given().header(header1,value1).header(header2,value2).when().get(endpoint).then().statusCode(200).extract().response();
	}
	
	/*public Response addData_old(String header1,Object value1,String header2,Object value2,String body,String endpoint) {
		return RestAssured.given().header(header1,value1).header(header2,value2).body(body).post(endpoint);
	}*/
	
	public Response addData(Headers headers,String body,String endpoint) {
		return RestAssured.given().headers(headers).body(body).post(endpoint);
	}
	
	public Response updateData(HashMap<String,String> hmheader,HashMap<String,String> hmbody,String endpoint) {
		return RestAssured.given().headers(hmheader).body(hmbody).when().put(endpoint);
	}
	
	public Response deleteData(HashMap<String,String> hmheader,HashMap<String,String> hmbody,String endpoint) {
		return RestAssured.given().headers(hmheader).body(hmbody).when().delete(endpoint);
	}
	
	public Response logout(HashMap<String,String> hmheader,HashMap<String,String> hmbody,String endpoint) {
		return RestAssured.given().headers(hmheader).body(hmbody).when().post(endpoint);
	}
	
	

}
