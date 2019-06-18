package com.example.quran.API.Model.Radio;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseRadios{

	@SerializedName("Radios")
	private List<RadiosItem> radios;

	public void setRadios(List<RadiosItem> radios){
		this.radios = radios;
	}

	public List<RadiosItem> getRadios(){
		return radios;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRadios{" + 
			"radios = '" + radios + '\'' + 
			"}";
		}
}