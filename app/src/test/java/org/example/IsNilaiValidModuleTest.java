package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsNilaiValidModuleTest {
    private final PengolahanNilaiMahasiswa pengolahanNilaiMahasiswa = new PengolahanNilaiMahasiswa();

    @Test
    void TC1_P1_validasiNilaiNormal() {
        assertTrue(pengolahanNilaiMahasiswa.isNilaiValid(80, 75, 90));
    }

    @Test
    void TC2_P2_nilaiTugasTidakValid() {
        assertFalse(pengolahanNilaiMahasiswa.isNilaiValid(-1, 75, 90));
    }

    @Test
    void TC3_P3_nilaiUtsTidakValid() {
        assertFalse(pengolahanNilaiMahasiswa.isNilaiValid(80, 120, 90));
    }

    @Test
    void TC4_P4_nilaiUasTidakValid() {
        assertFalse(pengolahanNilaiMahasiswa.isNilaiValid(80, 75, -10));
    }

    @Test
    void TC5_P5_semuaNilaiNol() {
        assertFalse(pengolahanNilaiMahasiswa.isNilaiValid(0, 0, 0));
    }

    @Test
    void TC6_P1_batasBawahDanAtasValid() {
        assertTrue(pengolahanNilaiMahasiswa.isNilaiValid(0, 100, 1));
    }

    @Test
    void TC7_P2_nilaiTugasDiAtas100TidakValid() {
        assertFalse(pengolahanNilaiMahasiswa.isNilaiValid(101, 75, 90));
    }

    @Test
    void TC8_P3_nilaiUtsDiBawah0TidakValid() {
        assertFalse(pengolahanNilaiMahasiswa.isNilaiValid(80, -0.5, 90));
    }

    @Test
    void TC9_P4_nilaiUasDiAtas100TidakValid() {
        assertFalse(pengolahanNilaiMahasiswa.isNilaiValid(80, 75, 100.1));
    }

    @Test
    void TC10_P1_satuNilaiNolMasihValid() {
        assertTrue(pengolahanNilaiMahasiswa.isNilaiValid(0, 70, 80));
    }
}
