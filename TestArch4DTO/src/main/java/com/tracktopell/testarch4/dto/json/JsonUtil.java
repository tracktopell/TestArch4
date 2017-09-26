package com.tracktopell.testarch4.dto.json;

import com.tracktopell.testarch4.dto.Address;
import com.tracktopell.testarch4.dto.Person;
import com.tracktopell.testarch4.dto.PhoneNumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author alfredo.estrada
 */
public class JsonUtil {
	public static String toJSonString(Person person) {
		try {
			// Here we convert Java Object to JSON 
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", person.getId()); 
			jsonObj.put("name", person.getName()); 
			jsonObj.put("surname", person.getSurname());

			JSONObject jsonAdd = new JSONObject(); // we need another object to store the address
			jsonAdd.put("address", person.getAddress().getAddress());
			jsonAdd.put("city", person.getAddress().getCity());
			jsonAdd.put("state", person.getAddress().getState());

			jsonObj.put("address", jsonAdd);

			JSONArray jsonArr = new JSONArray();

			for (PhoneNumber pn : person.getPhoneList()) {
				JSONObject pnObj = new JSONObject();
				
				pnObj.put("type", pn.getType());
				pnObj.put("number", pn.getNumber());				
				
				jsonArr.put(pnObj);
			}

			jsonObj.put("phoneList", jsonArr);

			return jsonObj.toString();

		} catch (JSONException ex) {
			ex.printStackTrace();
		}

		return null;

	}

	public static Person toJsonObject(String json){
		Person x = new Person();
		JSONObject jObj = new JSONObject(json);
		x.setId     (jObj.getInt("id"));
		x.setName   (jObj.getString("name"));
		x.setSurname(jObj.getString("surname"));
		
		JSONObject addressObj = jObj.getJSONObject("address");
		
		x.getAddress().setCity(addressObj.getString("city"));
		x.getAddress().setAddress(addressObj.getString("address"));
		x.getAddress().setState(addressObj.getString("state"));
		
		
		JSONArray jArr = jObj.getJSONArray("phoneList");
		
		for (int i=0; i < jArr.length(); i++) {
			JSONObject obj = jArr.getJSONObject(i);
			PhoneNumber pn=new PhoneNumber();
			
			pn.setNumber(obj.getString("number"));
			pn.setType  (obj.getString("number"));
			
			x.getPhoneList().add(pn);
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		
		Person x = new Person(
				"ALFREDO", "ESTRADA", 
				new Address("4TA PRIV SEC 54 M173 L47 C3","H TECAMAC","MEXICO"), 
				Arrays.asList(new PhoneNumber[]{
						new PhoneNumber("M", "5539804751"),
						new PhoneNumber("H", "5549775787")
					}
				));		
		
		String json = toJSonString(x);
		System.out.println("->x="+json);
		
		Person y = toJsonObject(json);
		
		System.out.println("->y="+json);		
	}
	
}
