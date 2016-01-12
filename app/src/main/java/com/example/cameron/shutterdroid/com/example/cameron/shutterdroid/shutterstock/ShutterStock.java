package com.example.cameron.shutterdroid.com.example.cameron.shutterdroid.shutterstock;

import android.util.Base64;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by Cameron on 7/16/15.
 */
public class ShutterStock {
    private static final RestAdapter ADAPTER = new RestAdapter.Builder()
            .setEndpoint("https://api.shutterstock.com/v2")
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    String authInfo = "997c0d23d74616da943d:372768235ac8d1c245c9c66f48eb87509cc7d739";
                    String auth = "Basic " + Base64.encodeToString(authInfo.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", auth);
                }
            })
            .build();


    private static final ShutterStockService SERVICE = ADAPTER.create(ShutterStockService.class);

    public static void search(String query, final Callback<List<Image>> cb) {
        SERVICE.search(query, new ImageCallback(cb) {
        });
    }

    public static void getRecent(Date date, Callback<List<Image>> cb){
        SERVICE.getRecent(new SimpleDateFormat("yyy-MM-dd").format(date), new ImageCallback(cb));
    }

    private static class ImageCallback implements Callback<Response> {
        Callback<List<Image>> cb;

        ImageCallback(Callback<List<Image>> cb) {
            this.cb = cb;
        }

        @Override
        public void success(Response response, retrofit.client.Response response2) {
            cb.success(response.data, response2);
        }

        @Override
        public void failure(RetrofitError error) {
            cb.failure(error);
        }
    }
}
