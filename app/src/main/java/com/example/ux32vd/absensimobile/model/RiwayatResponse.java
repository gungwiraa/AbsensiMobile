package com.example.ux32vd.absensimobile.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RiwayatResponse{

	@SerializedName("Riwayat")
	private List<RiwayatItem> riwayat;

	public void setRiwayat(List<RiwayatItem> riwayat){
		this.riwayat = riwayat;
	}

	public List<RiwayatItem> getRiwayat(){
		return riwayat;
	}

	@Override
 	public String toString(){
		return 
			"RiwayatResponse{" + 
			"riwayat = '" + riwayat + '\'' + 
			"}";
		}
}