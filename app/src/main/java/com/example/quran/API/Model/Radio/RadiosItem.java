package com.example.quran.API.Model.Radio;


import com.google.gson.annotations.SerializedName;


public class RadiosItem{
//int img;
//
//	public int getImg() {
//		return img;
//	}
//
//	public int setImg(int img) {
//		this.img = img;
//		return img;
//	}
//
//	public RadiosItem(int img) {
//		this.img = img;
//	}

	@SerializedName("URL")
	private String uRL;

	@SerializedName("Name")
	private String name;

	public void setURL(String uRL){
		this.uRL = uRL;
	}

	public String getURL(){
		return uRL;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"RadiosItem{" + 
			"uRL = '" + uRL + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}