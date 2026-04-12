package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TentukanGradeTest {
    private final PengolahanNilaiMahasiswa pengolahanNilaiMahasiswa = new PengolahanNilaiMahasiswa();

    //GRADE A (100-85)
    @Test
    public void TC1_P1_RentangGradeA() {
        int nilaiAkhir = 88;
        char expected = 'A';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi rentang Grade A");
    }

    @Test
    public void TC2_P1_BatasAtasGradeA() {
        int nilaiAkhir = 100; 
        char expected = 'A';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas atas Grade A");
    }

    @Test
    public void TC3_P1_BatasBawahGradeA() {
        int nilaiAkhir = 85; 
        char expected = 'A';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas bawah Grade A");
    }

    //GRADE B (84-70)
    @Test
    public void TC4_P2_RentangGradeB() {
        int nilaiAkhir = 83;
        char expected = 'B';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi rentang Grade B");
    }

    @Test
    public void TC5_P2_BatasAtasGradeB() {
        int nilaiAkhir = 84;
        char expected = 'B';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas atas Grade B");
    }

    @Test
    public void TC6_P2_BatasBawahGradeB() {
        int nilaiAkhir = 70;
        char expected = 'B';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas bawah Grade B");
    }

    //GRADE C (69-60)
    @Test
    public void TC7_P3_RentangGradeC() {
        int nilaiAkhir = 63;
        char expected = 'C';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi rentang Grade C");
    }

    @Test
    public void TC8_P3_BatasAtasGradeC() {
        int nilaiAkhir = 69;
        char expected = 'C';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas atas Grade C");
    }

    @Test
    public void TC9_P3_BatasBawahGradeC() {
        int nilaiAkhir = 60;
        char expected = 'C';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas bawah Grade C");
    }

    //GRADE D (59-50)
    @Test
    public void TC10_P4_RentangGradeD() {
        int nilaiAkhir = 54;
        char expected = 'D';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi rentang Grade D");
    }

    @Test
    public void TC11_P4_BatasAtasGradeD() {
        int nilaiAkhir = 59;
        char expected = 'D';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas atas Grade D");
    }

    @Test
    public void TC12_P4_BatasBawahGradeD() {
        int nilaiAkhir = 50;
        char expected = 'D';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas bawah Grade D");
    }

    //GRADE E (49-1)
    @Test
    public void TC13_P5_RentangGradeE() {
        int nilaiAkhir = 25; 
        char expected = 'E';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi rentang Grade E");
    }

    @Test
    public void TC14_P5_BatasAtasGradeE() {
        int nilaiAkhir = 49;
        char expected = 'E';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas atas Grade E");
    }

    @Test
    public void TC15_P5_BatasBawahGradeE() {
        int nilaiAkhir = 1; 
        char expected = 'E';
        char actual = pengolahanNilaiMahasiswa.tentukanGrade(nilaiAkhir);
        assertEquals(expected, actual, "Gagal kalkulasi batas bawah Grade E");
    }
}
