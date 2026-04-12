package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TentukanStatusKelulusanTest {
    private final PengolahanNilaiMahasiswa pengolahanNilaiMahasiswa = new PengolahanNilaiMahasiswa();

    //Lulus (100-60)
    @Test
    public void TC1_P1_RentangLulus() {
        int nilaiAkhir = 84;
        String expected = "Lulus";
        String actual = pengolahanNilaiMahasiswa.tentukanStatusKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi rentang Lulus");
    }

    @Test
    public void TC2_P1_BatasAtasLulus() {
        int nilaiAkhir = 100;
        String expected = "Lulus";
        String actual = pengolahanNilaiMahasiswa.tentukanStatusKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas atas Lulus");
    }

    @Test
    public void TC3_P1_BatasBawahLulus() {
        int nilaiAkhir = 60;
        String expected = "Lulus";
        String actual = pengolahanNilaiMahasiswa.tentukanStatusKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas bawah Lulus");
    }

    //Tidak Lulus (59-1)
    @Test
    public void TC4_P2_RentangTidakLulus() {
        int nilaiAkhir = 37;
        String expected = "Tidak Lulus";
        String actual = pengolahanNilaiMahasiswa.tentukanStatusKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi rentang Tidak Lulus");
    }

    @Test
    public void TC5_P2_BatasAtasTidakLulus() {
        int nilaiAkhir = 59;
        String expected = "Tidak Lulus";
        String actual = pengolahanNilaiMahasiswa.tentukanStatusKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas atas Tidak Lulus");
    }

    @Test
    public void TC6_P2_BatasBawahTidakLulus() {
        int nilaiAkhir = 1;
        String expected = "Tidak Lulus";
        String actual = pengolahanNilaiMahasiswa.tentukanStatusKelulusan(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas bawah Tidak Lulus");
    }
}
