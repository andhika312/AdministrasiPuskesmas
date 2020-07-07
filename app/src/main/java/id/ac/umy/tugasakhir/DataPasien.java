package id.ac.umy.tugasakhir;

import android.provider.ContactsContract;

public class DataPasien {
    private String nama, jenisK, usia, alamat, key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisK() {
        return jenisK;
    }

    public void setJenisK(String jenisK) {
        this.jenisK = jenisK;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    //Konstruktor
    public DataPasien(){
    }

    public DataPasien(String nama, String jenisK, String usia, String alamat){
        this.nama = nama;
        this.jenisK = jenisK;
        this.usia = usia;
        this.alamat = alamat;
    }
}
