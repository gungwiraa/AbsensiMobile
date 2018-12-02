package com.example.ux32vd.absensimobile.model;

public class Ortu{
	private String nama;
	private int idOrtu;
	private String username;
	private String token;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setIdOrtu(int idOrtu){
		this.idOrtu = idOrtu;
	}

	public int getIdOrtu(){
		return idOrtu;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"Ortu{" + 
			"nama = '" + nama + '\'' + 
			",id_ortu = '" + idOrtu + '\'' + 
			",username = '" + username + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}
