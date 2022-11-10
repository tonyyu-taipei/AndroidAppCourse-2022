package com.example.ra08d_recycleview_readfromassets_json01_10130492;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonLoad  {
    String data;
    public JsonLoad(String input){
        data = input;
    }
    ArrayList<String> personNames = new ArrayList<>();
    ArrayList<String> emailIds = new ArrayList<>();
    ArrayList<String> phoneNumbers = new ArrayList<>();
    public ArrayList[] load(){
        try{
            JSONObject obj = new JSONObject(data);
            JSONArray userArray = obj.getJSONArray("users");

            for(int i = 0 ; i < userArray.length() ; i++){
                JSONObject userDetail = userArray.getJSONObject(i);
                personNames.add(userDetail.getString("name"));
                emailIds.add(userDetail.getString("email"));

                JSONObject contact = userDetail.getJSONObject("contact");
                phoneNumbers.add(contact.getString("mobile"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayList[] out = new ArrayList[]{personNames, emailIds, phoneNumbers};
        return out;
    }

}
