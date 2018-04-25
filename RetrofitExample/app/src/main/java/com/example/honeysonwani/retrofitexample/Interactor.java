package com.example.honeysonwani.retrofitexample;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by honeysonwani on 4/25/2018.
 */

public interface Interactor {
    String BASE_API_URL = "https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<ConvertJsonToJavaObjects>> getAllObjects();
}
