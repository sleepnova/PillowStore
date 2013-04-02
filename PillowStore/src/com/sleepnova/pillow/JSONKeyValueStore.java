package com.sleepnova.pillow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class JSONKeyValueStore extends KeyValueStore {

	public JSONKeyValueStore(Context context, String name) {
		super(context, name);
	}
	
	public void put(String key, JSONObject value){
		put(key, value.toString());
	}
	
	public void put(String key, JSONArray value){
		put(key, value.toString());
	}
	
	public JSONObject getJSONObject(String key){
		String str = get(key);
		JSONObject result = null;
        if(str != null) {
        	try {
    			result = new JSONObject(str);
    		} catch (JSONException e) {
    			e.printStackTrace();
    		}	
        }
        return result;
	}
	
	public JSONArray getJSONArray(String key){
		String str = get(key);
		JSONArray result = null;
        if(str != null) {
        	try {
    			result = new JSONArray(str);
    		} catch (JSONException e) {
    			e.printStackTrace();
    		}	
        }
        return result;
	}

}
