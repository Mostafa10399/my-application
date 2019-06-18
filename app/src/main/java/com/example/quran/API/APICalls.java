package com.example.quran.API;

import com.example.quran.API.Model.Radio.ResponseRadios;
import com.example.quran.API.Model.SoraRadio.SoraRadioResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICalls {
    @GET("radio/radio_ar.json")
    Call<ResponseRadios>getAllCalls();
    @GET("_arabic.json")
    Call<SoraRadioResponse>getSoraCalls();



}
