package com.androidevelopers.cs5540.businessexchange.MAPS;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DataParser {

    private HashMap<String, String> getPlace(JSONObject googlePlaceJson)
    {
        HashMap<String, String> googlePlaceMap = new HashMap<>();
        String placeName = "--NA--";
        String vicinity= "--NA--";
        String latitude= "";
        String longitude="";
        String reference="";

        Log.d("DataParser","jsonobject ="+googlePlaceJson.toString());



            if (!googlePlaceJson.isNull("name")) {
                try {
                    placeName = googlePlaceJson.getString("name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (!googlePlaceJson.isNull("vicinity")) {
                try {
                    vicinity = googlePlaceJson.getString("vicinity");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        try {
            latitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            longitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            reference = googlePlaceJson.getString("reference");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        googlePlaceMap.put("place_name", placeName);
            googlePlaceMap.put("vicinity", vicinity);
            googlePlaceMap.put("lat", latitude);
            googlePlaceMap.put("lng", longitude);
            googlePlaceMap.put("reference", reference);

        return googlePlaceMap;

        }



    private List<HashMap<String, String>>getPlaces(JSONArray jsonArray)
    {
        int count = jsonArray.length();
        List<HashMap<String, String>> placelist = new ArrayList<>();
        HashMap<String, String> placeMap = null;

        for(int i = 0; i<count;i++)
        {
            try {
                placeMap = getPlace((JSONObject) jsonArray.get(i));
                placelist.add(placeMap);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return placelist;
    }

    public List<HashMap<String, String>> parse(String jsonData)
    {
        JSONArray jsonArray = null;
        JSONObject jsonObject;

        Log.d("json data", jsonData);

        try {
            jsonObject = new JSONObject(jsonData);
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getPlaces(jsonArray);
    }
}
