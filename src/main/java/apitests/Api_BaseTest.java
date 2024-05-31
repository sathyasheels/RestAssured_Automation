package apitests;

import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api_utils.Api_CommonUtils;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import testdata.AddData;

public class Api_BaseTest {
	Api_CommonUtils request=null;
	public String jString;
	Headers h1andh2;
	
	
	@BeforeTest
	public void prerequisite() throws JsonProcessingException {
	  request=new Api_CommonUtils();
	  AddData ad=new AddData("TA-5670217","5","90700","567007");
	 /* ObjectMapper om=new ObjectMapper();
	  om.setVisibility(PropertyAccessor.FIELD,Visibility.ANY);
	  jString=om.writeValueAsString(ad);*/
	  Header h1=new Header("Content-Type","application/json");
	  Header h2=new Header("token",Api_Tests.token1);
	  h1andh2=new Headers(h1,h2);
	}

}
