package com.sleepnova.pillow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class JSONKeyValueStore {

	private KeyValueStore kv;

	public JSONKeyValueStore(Context context, String name) {
		kv = new KeyValueStore(context, name);
	}
	
	public void put(String key, JSONObject value){
		kv.put(key, value.toString());
	}
	
	public void del(String key){
		kv.del(key);
	}
	
	public JSONObject getJSONObject(String key){
		String str = kv.get(key);
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
		String str = kv.get(key);
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
	
	public boolean has(String key) {
		return kv.has(key);
	}
	
	public void close(){
		kv.close();
	}
}
