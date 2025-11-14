package com.mdm.OPSI_details;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonObj {

	public static void main(String[] args) throws ParseException, IOException, java.text.ParseException {
		
		String Rn="[{\"Uname\":\"Balram\",\r\n\"Pass\":\"Rajak\"},"
				+ "{\"Uname\":\"Kiran\",\"Pass\":\"kumar\"}]";
		JsonMapper mp=new JsonMapper();
		
		JSONArray jsonArray=new JSONArray(Rn);
		for(Object o: jsonArray) {
			JSONObject json=new JSONObject(o.toString());
		
			System.out.println(json.get("Uname"));
			/*
			 * JsonNode jsonNode=mp.readTree(o.toString());
			 * System.out.println(jsonNode.get("Uname").asText());
			 */
		}
		
		System.out.println(jsonArray.get(0));
		JSONArray postBodyConnArr = new JSONArray();
		JSONObject objBR = new JSONObject();
		JSONObject objBRI = new JSONObject();
		JSONObject objBPU = new JSONObject();
		JSONArray brArr = new JSONArray();
		JSONArray briArr = new JSONArray();
		JSONArray bpuArr = new JSONArray();

		brArr.put("m");
		briArr.put("configuration/relationTypes/OPSIToBRI");
		bpuArr.put("configuration/relationTypes/OPSIToBPU");

		objBR.put("inRelations", brArr);
		objBR.put("max", 1);
		objBRI.put("outRelations", briArr);
		objBRI.put("max", 1);
		objBPU.put("outRelations", bpuArr);
		objBPU.put("max", 1);

		postBodyConnArr.put(objBR);
		postBodyConnArr.put(objBRI);
		postBodyConnArr.put(objBPU);
		
		//postBodyConnArr.forEach(t -> );
	
		System.out.println(postBodyConnArr);
		
		Date date=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		
		
		System.out.println(sdf.format(date));
		//sdf=new SimpleDateFormat("2022-02-20 14:14:49:993");
		sdf.parse("2022-02-20 14:14:00:000");
		System.out.println(sdf.getCalendar().getTimeInMillis());
		
		
		//readAttributes();
				
	}
	
	@SuppressWarnings("unchecked")
	static void readAttributes() throws ParseException {
		
		try (FileInputStream fin = new FileInputStream(
				new File("/Users/rakesh/eclipse-workspace/OPSI_details"
						+ "/src/main/resources/ID-67867867.json"))) {
			
			
			List<Object> values=new JSONParser(fin).parseArray().stream()
			.map(t -> (LinkedHashMap<String, LinkedHashMap<String,ArrayList<Object>>>)t)
			.flatMap(inMap -> 
					inMap.get("attributes").get("OrganizationName").stream()
			)
			.map(inMap2 -> ((LinkedHashMap<String, Object>)inMap2).get("refRelation"))
			.collect(Collectors.toList());
			
			for(Object o: values) {
				
				System.out.println(((LinkedHashMap<String, String>)o).get("type")
						.split("/",-2)[2]);
			}
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
