package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HitungNilaiAkhirModuleTest {
    private final PengolahanNilaiMahasiswa pengolahanNilaiMahasiswa = new PengolahanNilaiMahasiswa();

    @Test
    void TC1_P1_hitungNilaiAkhirInvalidInput() {
        assertEquals(-1.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(-1, 80, 90), 0.0001);
    }

    @Test
    void TC2_P2_hitungNilaiAkhirLebihDari100() {
        assertEquals(-1.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(200, 200, 200), 0.0001);
    }

    @Test
    void TC3_P3_hitungNilaiAkhirValidNormal() {
        assertEquals(82.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(80, 80, 85), 0.0001);
    }

    @Test
    void TC4_hitungNilaiAkhirInvalidUts() {
        assertEquals(-1.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(80, -1, 85), 0.0001);
    }

    @Test
    void TC5_hitungNilaiAkhirInvalidUas() {
        assertEquals(-1.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(80, 80, -1), 0.0001);
    }

    @Test
    void TC6_hitungNilaiAkhirSemuaNolInvalid() {
        assertEquals(-1.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(0, 0, 0), 0.0001);
    }

    @Test
    void TC7_hitungNilaiAkhirBatasMaksimumValid() {
        assertEquals(100.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(100, 100, 100), 0.0001);
    }

    @Test
    void TC8_hitungNilaiAkhirBatasMinimumValid() {
        assertEquals(0.4, pengolahanNilaiMahasiswa.hitungNilaiAkhir(0, 0, 1), 0.0001);
    }

    @Test
    void TC9_hitungNilaiAkhirBranchLebihDari100_structural() {
        PengolahanNilaiMahasiswa stub = new PengolahanNilaiMahasiswa() {
            @Override
            public boolean isNilaiValid(double nilaiTugas, double nilaiUts, double nilaiUas) {
                return true;
            }
        };

        assertEquals(-1.0, stub.hitungNilaiAkhir(200, 200, 200), 0.0001);
    }
}
