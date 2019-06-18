package com.example.quran.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManger {
    private static Retrofit retrofitInstance;
    private  static  Retrofit getInstance()
    {
        if (retrofitInstance==null)
        {
            retrofitInstance=new Retrofit.Builder()
                    .baseUrl("http:/www.mp3quran.net/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
         return retrofitInstance;


    }

    public static APICalls getApis()
    {
     APICalls apiCalls=getInstance().create(APICalls.class);
     return apiCalls;
    }
}
