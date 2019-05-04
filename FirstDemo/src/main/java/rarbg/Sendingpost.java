package rarbg;



import java.io.File;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Sendingpost{
	
public static void main(String[] args) throws UnirestException {
	
	
		/*
		 * HttpResponse<String> response =
		 * Unirest.post("https://api.ocr.space/parse/image") .header("content-type",
		 * "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
		 * .header("apikey", "95308559f088957") .header("cache-control", "no-cache")
		 * .header("postman-token", "ccfe7f43-657d-3056-7c54-ec873d5759f2")
		 * .body("------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"language\"\r\n\r\neng\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"isoverlayrequired\"\r\n\r\ntrue\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"filetype\"; filename=\"kk.png\"\r\nContent-Type: image/png\r\n\r\n\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--"
		 * ) .asString();
		 * 
		 */
	
		
		  HttpResponse<JsonNode> jsonResponse =Unirest.post("https://api.ocr.space/parse/image") 
				  .header("apikey","95308559f088957") 
				  .field("language", "eng") 
				  .field("isoverlayrequired","true") 
				  .field("filetype", new File("C:\\Users\\Vikash\\git\\Frameworks\\FirstDemo\\screenshots\\captcha.png"))
		  .asJson();
		 
	
	
	
	System.out.println(jsonResponse.getStatusText());
	//System.out.println(jsonResponse.getBody().toString());
	DEMO.resp=jsonResponse.getBody().toString();
	DEMO2.resp=jsonResponse.getBody().toString();
}
}