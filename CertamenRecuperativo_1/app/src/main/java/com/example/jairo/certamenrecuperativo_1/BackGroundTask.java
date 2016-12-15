package com.example.jairo.certamenrecuperativo_1;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jairo on 14-12-2016.
 */

public class BackGroundTask implements Response.Listener<JSONObject>, Response.ErrorListener{

    Context context;
    String joke;

    public BackGroundTask(View.OnClickListener context, String json_url){

        this.context = (Context) context;
        RequestQueue  request = Volley.newRequestQueue((Context) context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,json_url,this,this);
        request.add(jsonObjectRequest);

    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(context, "Error2: ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            JSONObject jsonObject = response;
            this.joke =jsonObject.getString("joke");
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error1: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


}