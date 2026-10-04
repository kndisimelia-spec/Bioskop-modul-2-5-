/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bioskop;

/**
 *
 * @author user
 */
public class Film {
    
    private String judul;
    private int nomorFilm;
    private String jamTayang;

    private static int jumlahFilm = 0;

    public Film(String judul, int nomorFilm, String jamTayang) {
        this.judul = judul;
        this.nomorFilm = nomorFilm;
        this.jamTayang = jamTayang;
        jumlahFilm++;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getNomorFilm() {
        return nomorFilm;
    }

    public void setNomorFilm(int nomorFilm) {
        this.nomorFilm = nomorFilm;
    }

    public String getJamTayang() {
        return jamTayang;
    }

    public void setJamTayang(String jamTayang) {
        this.jamTayang = jamTayang;
    }

    public static int getJumlahFilm() {
        return jumlahFilm;
    }

    public void tampilkanInfo() {
        System.out.println("Judul      : " + judul);
        System.out.println("Nomor Film : " + nomorFilm);
        System.out.println("Jam Tayang : " + jamTayang);
    }
}