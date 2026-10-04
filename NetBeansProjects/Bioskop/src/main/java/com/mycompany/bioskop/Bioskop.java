/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bioskop;

/**
 *
 * @author user
 */
import java.util.Scanner;

public class Bioskop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Film[] daftarFilm = new Film[10];

        int jumlahFilm = 0;
        Boolean isRunning = true;

        System.out.println("================================");
        System.out.println("       SISTEM BIOSKOP KITA");
        System.out.println("================================");

        while (isRunning) {

            System.out.println();
            System.out.println("1. Tambah Jadwal Film");
            System.out.println("2. Jadwal Film");
            System.out.println("3. Cari Film");
            System.out.println("4. Pesan Tiket");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                case 1:

                    if (jumlahFilm < daftarFilm.length) {

                        System.out.println();
                        System.out.println("===== TAMBAH JADWAL FILM =====");

                        System.out.print("Judul film: ");
                        String judul = scanner.nextLine();

                        System.out.print("Nomor film: ");
                        int nomorFilm = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Jam tayang: ");
                        String jamTayang = scanner.nextLine();

                        System.out.println();
                        System.out.println("Pilih jenis film:");
                        System.out.println("1. Film 2D");
                        System.out.println("2. Film 3D");
                        System.out.println("3. Film Premium");
                        System.out.print("Pilih: ");

                        int jenisFilm = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nomor studio: ");
                        int studio = scanner.nextInt();
                        scanner.nextLine();

                        if (jenisFilm == 1) {

                            daftarFilm[jumlahFilm] =
                                new Film2D(
                                    judul,
                                    nomorFilm,
                                    jamTayang,
                                    studio
                                );

                            jumlahFilm++;

                        } else if (jenisFilm == 2) {

                            daftarFilm[jumlahFilm] =
                                new Film3D(
                                    judul,
                                    nomorFilm,
                                    jamTayang,
                                    studio
                                );

                            jumlahFilm++;

                        } else if (jenisFilm == 3) {

                            daftarFilm[jumlahFilm] =
                                new FilmPremium(
                                    judul,
                                    nomorFilm,
                                    jamTayang,
                                    studio
                                );

                            jumlahFilm++;

                        } else {

                            System.out.println("Jenis film tidak tersedia.");
                        }

                    } else {

                        System.out.println("Jadwal film penuh.");
                    }

                    break;

                case 2:

                    System.out.println();
                    System.out.println("===== JADWAL FILM =====");

                    if (jumlahFilm == 0) {

                        System.out.println("Tidak ada jadwal film.");

                    } else {

                        for (int i = 0; i < jumlahFilm; i++) {

                            System.out.println();
                            daftarFilm[i].tampilkanInfo();
                        }
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("===== CARI FILM =====");
                    System.out.println("1. Berdasarkan judul");
                    System.out.println("2. Berdasarkan nomor film");
                    System.out.print("Pilih: ");

                    int jenisCari = scanner.nextInt();
                    scanner.nextLine();

                    if (jenisCari == 1) {

                        System.out.print("Masukkan judul film: ");
                        String judulCari = scanner.nextLine();

                        cariFilm(daftarFilm, jumlahFilm, judulCari);

                    } else if (jenisCari == 2) {

                        System.out.print("Masukkan nomor film: ");
                        int nomorCari = scanner.nextInt();
                        scanner.nextLine();

                        cariFilm(daftarFilm, jumlahFilm, nomorCari);

                    } else {

                        System.out.println("Pilihan tidak tersedia.");
                    }

                    break;

                case 4:

                    System.out.println();
                    System.out.println("===== PESAN TIKET =====");

                    System.out.print("Masukkan nomor film: ");
                    int nomorPesan = scanner.nextInt();
                    scanner.nextLine();

                    boolean ditemukan = false;

                    for (int i = 0; i < jumlahFilm; i++) {

                        if (daftarFilm[i].getNomorFilm() == nomorPesan) {

                            pesanTiket(daftarFilm[i]);
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Film tidak ditemukan.");
                    }

                    break;

                case 5:

                    isRunning = false;

                    System.out.println();
                    System.out.println("Terima kasih.");

                    break;

                default:

                    System.out.println("Pilihan tidak tersedia.");
            }
        }

        scanner.close();
    }

    // Method untuk menunjukkan Runtime Polymorphism / Dynamic Binding

    public static void pesanTiket(Film film) {

        System.out.println("===== TIKET DIPESAN =====");
        film.tampilkanInfo();
    }

    // Overloading Modul 4

    public static void cariFilm(
        Film[] daftarFilm,
        int jumlahFilm,
        String judul
    ) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahFilm; i++) {

            if (daftarFilm[i].getJudul().equalsIgnoreCase(judul)) {

                daftarFilm[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Film tidak ditemukan.");
        }
    }

    public static void cariFilm(
        Film[] daftarFilm,
        int jumlahFilm,
        int nomorFilm
    ) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahFilm; i++) {

            if (daftarFilm[i].getNomorFilm() == nomorFilm) {

                daftarFilm[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Film tidak ditemukan.");
        }
    }
}