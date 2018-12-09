package com.example.ux32vd.absensimobile.model;

import com.google.gson.annotations.SerializedName;

public class RiwayatItem{

	@SerializedName("Status")
	private int status;

	@SerializedName("waktu_absensi")
	private String waktuAbsensi;

	@SerializedName("nama_kelas")
	private String namaKelas;

	@SerializedName("nama_mahasiswa")
	private String namaMahasiswa;

	@SerializedName("id_ortu")
	private int idOrtu;

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public void setWaktuAbsensi(String waktuAbsensi){
		this.waktuAbsensi = waktuAbsensi;
	}

	public String getWaktuAbsensi(){
		return waktuAbsensi;
	}

	public void setNamaKelas(String namaKelas){
		this.namaKelas = namaKelas;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	public void setNamaMahasiswa(String namaMahasiswa){
		this.namaMahasiswa = namaMahasiswa;
	}

	public String getNamaMahasiswa(){
		return namaMahasiswa;
	}

	public void setIdOrtu(int idOrtu){
		this.idOrtu = idOrtu;
	}

	public int getIdOrtu(){
		return idOrtu;
	}

	@Override
 	public String toString(){
		return 
			"RiwayatItem{" + 
			"status = '" + status + '\'' + 
			",waktu_absensi = '" + waktuAbsensi + '\'' + 
			",nama_kelas = '" + namaKelas + '\'' + 
			",nama_mahasiswa = '" + namaMahasiswa + '\'' + 
			",id_ortu = '" + idOrtu + '\'' + 
			"}";
		}
}