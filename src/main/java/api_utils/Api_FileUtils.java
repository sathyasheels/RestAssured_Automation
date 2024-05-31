package api_utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.jayway.jsonpath.JsonPath;
import constants.Api_FileConstants;

public class Api_FileUtils {
	
	//public static String readApiLoginTestData() throws IOException {
		//byte[] data=Files.readAllBytes(Paths.get(Api_FileConstants.API_LOGINTESTDATA_FILEPATH));
		//JsonArray arJson =  
		//return new String(data);
	//}
	
	public static Object readApiLoginTestdataAsObject(String jsonPath) throws IOException {
		Object data= JsonPath.read(new String(Files.readAllBytes(Paths.get(Api_FileConstants.API_LOGINTESTDATA_FILEPATH))), jsonPath);
		return data;
	}
	
	
	public static String readapiLoginTestDatAsString(String jsonPath) throws IOException {
		Object data= JsonPath.read(new String(Files.readAllBytes(Paths.get(Api_FileConstants.API_LOGINTESTDATA_FILEPATH))), jsonPath);
		String result=data.toString();
		return result;
	}
	
	public static Object readApiGetTestdataAsObject(String jsonPath) throws IOException {
		Object data= JsonPath.read(new String(Files.readAllBytes(Paths.get(Api_FileConstants.API_GETTESTDATA_FILEPATH))), jsonPath);
		return data;
	}
	
	
	public static String readapiGetTestDatAsString(String jsonPath) throws IOException {
		Object data= JsonPath.read(new String(Files.readAllBytes(Paths.get(Api_FileConstants.API_GETTESTDATA_FILEPATH))), jsonPath);
		String result=data.toString();
		return result;
	}
	
	public static String readapiAddTestDataAsString(String jsonPath) throws IOException {
		Object data= JsonPath.read(new String(Files.readAllBytes(Paths.get(Api_FileConstants.API_ADDTESTDATA_FILEPATH))), jsonPath);
		String result=data.toString();
		return result;
	}


}
