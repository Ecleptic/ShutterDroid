package com.example.cameron.shutterdroid.com.example.cameron.shutterdroid.shutterstock;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Cameron on 7/16/15.
 */
interface ShutterStockService {

    static final String API_URL = ("https://api.shutterstock.com/v2");

    public static final String CLIENT_ID = "997c0d23d74616da943d";
    public static final String CLIENT_SECRET = "372768235ac8d1c245c9c66f48eb87509cc7d739";

// GET https://api.shutterstock.com/v2/images?id=254446402&id=241570090&view=full

    @GET("/images/search")
    public void search(@Query("query") String query, Callback<Response> cb);

    @GET("/images/search")
    public void getRecent(@Query("added_date_start") String date, Callback<Response> cb);
}
