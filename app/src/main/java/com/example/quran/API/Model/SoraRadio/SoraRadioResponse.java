package com.example.quran.API.Model.SoraRadio;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class SoraRadioResponse{

	@SerializedName("reciters")
	private List<RecitersItem> reciters;

	public void setReciters(List<RecitersItem> reciters){
		this.reciters = reciters;
	}

	public List<RecitersItem> getReciters(){
		return reciters;
	}

	@Override
 	public String toString(){
		return 
			"SoraRadioResponse{" + 
			"reciters = '" + reciters + '\'' + 
			"}";
		}
}