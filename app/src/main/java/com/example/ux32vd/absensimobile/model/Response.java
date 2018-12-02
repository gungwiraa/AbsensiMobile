package com.example.ux32vd.absensimobile.model;

public class Response{
	private Ortu ortu;
	private String message;
	private boolean status;

	public void setOrtu(Ortu ortu){
		this.ortu = ortu;
	}

	public Ortu getOrtu(){
		return ortu;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"ortu = '" + ortu + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
