package com.example.ux32vd.absensimobile.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static APIService getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://serene-dawn-16804.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(APIService.class);
    }
}
