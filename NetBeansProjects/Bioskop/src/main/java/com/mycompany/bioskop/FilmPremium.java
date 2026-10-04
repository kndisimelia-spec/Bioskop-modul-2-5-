/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bioskop;

/**
 *
 * @author user
 */
public class FilmPremium extends Film {

    private int studio;

    public FilmPremium(String judul, int nomorFilm, String jamTayang, int studio) {
        super(judul, nomorFilm, jamTayang);
        this.studio = studio;
    }

    public int getStudio() {
        return studio;
    }

    public void setStudio(int studio) {
        this.studio = studio;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("===== FILM PREMIUM =====");
        super.tampilkanInfo();
        System.out.println("Studio     : " + studio);
    }
}