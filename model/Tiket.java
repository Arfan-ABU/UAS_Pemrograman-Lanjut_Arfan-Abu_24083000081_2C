/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Tiket {
    private String namaPembeli;
    private String namaKonser;
    private int jumlahTiket;
    private String kategoriKursi;
    private int harga;

    public Tiket(String namaPembeli, String namaKonser, int jumlahTiket, String kategoriKursi, int harga) {
        this.namaPembeli = namaPembeli;
        this.namaKonser = namaKonser;
        this.jumlahTiket = jumlahTiket;
        this.kategoriKursi = kategoriKursi;
        this.harga = harga;
    }

    public String getNamaPembeli() { return namaPembeli; }
    public String getNamaKonser() { return namaKonser; }
    public int getJumlahTiket() { return jumlahTiket; }
    public String getKategoriKursi() { return kategoriKursi; }
    public int getHarga() { return harga; }

    public void setNamaPembeli(String namaPembeli) { this.namaPembeli = namaPembeli; }
    public void setNamaKonser(String namaKonser) { this.namaKonser = namaKonser; }
    public void setJumlahTiket(int jumlahTiket) { this.jumlahTiket = jumlahTiket; }
    public void setKategoriKursi(String kategoriKursi) { this.kategoriKursi = kategoriKursi; }
    public void setHarga(int harga) { this.harga = harga; }
}
