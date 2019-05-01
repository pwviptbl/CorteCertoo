package com.mjr.cortecerto.Tools;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Location {

   private String lat;
   private String lng;

    public LocationData latlon(String end){

        new GetCoordinates().execute(end.toString().replace(" ","+"));
        return new LocationData(lat,lng);
    }


    public class GetCoordinates extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String response;
            try {
                String address = strings[0];
                HttpDataHandler http = new HttpDataHandler();
                String url = String.format("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyBZWyWGgOUQJvza1aJ1ASn4sKVRkqHmQEg&address=%s", address);
                response = http.getHTTPData(url);
                return response;
            } catch (Exception ex) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject jsonObject = new JSONObject(s);

                lat = ((JSONArray) jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").get("lat").toString();
                lng = ((JSONArray) jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").get("lng").toString();

                //lat,lng;


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}


