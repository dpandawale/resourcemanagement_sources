package com.resourcemanagement.response;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
/**
 * 
 * @author Mauli-DITPL
 * this class is responsible for returning response in json format
 */
public class ResponseHandler {
	public static String sendResponse(ResponseCode responseCode,boolean success) {
		Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
		jsonMap.put("code",responseCode.ordinal());
		jsonMap.put("success", success);
		jsonMap.put("data", "");
		jsonMap.put("message", responseCode.value());
		return new Gson().toJson(jsonMap);
	}
	public static String sendResponseWithData(ResponseCode responseCode,boolean success,Object data) {
		Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
		jsonMap.put("code",responseCode.ordinal());
		jsonMap.put("success", success);
		jsonMap.put("data", data);
		jsonMap.put("message", responseCode.value());
		return new Gson().toJson(jsonMap);
	}
	public static String sendResponseWithException(ResponseCode responseCode,boolean success,String message) {
		Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
		jsonMap.put("code",responseCode.ordinal());
		jsonMap.put("success", success);
		jsonMap.put("data", "");
		jsonMap.put("message",message);
		return new Gson().toJson(jsonMap);
	}
}
