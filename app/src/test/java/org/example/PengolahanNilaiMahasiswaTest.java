package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PengolahanNilaiMahasiswaTest {
    private final PengolahanNilaiMahasiswa pengolahanNilaiMahasiswa = new PengolahanNilaiMahasiswa();

    @Test
    void validasiNilaiValid() {
        assertEquals(true, pengolahanNilaiMahasiswa.isNilaiValid(80, 80, 85));
    }

    @Test
    void validasiNilaiTidakValid() {
        assertEquals(false, pengolahanNilaiMahasiswa.isNilaiValid(0, 0, 0));
    }

    @Test
    void validasiNilaiDiLuarRentangTidakValid() {
        assertEquals(false, pengolahanNilaiMahasiswa.isNilaiValid(120, 80, 90));
    }

    @Test
    void hitungNilaiAkhirValid() {
        assertEquals(82.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(80, 80, 85), 0.0001);
    }

    @Test
    void hitungNilaiAkhirInvalid() {
        assertEquals(-1.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(-1, 80, 90), 0.0001);
    }

    @Test
    void tentukanGrade() {
        assertEquals('A', pengolahanNilaiMahasiswa.tentukanGrade(85));
        assertEquals('B', pengolahanNilaiMahasiswa.tentukanGrade(70));
        assertEquals('C', pengolahanNilaiMahasiswa.tentukanGrade(60));
        assertEquals('D', pengolahanNilaiMahasiswa.tentukanGrade(50));
        assertEquals('E', pengolahanNilaiMahasiswa.tentukanGrade(49));
    }

    @Test
    void tentukanStatusKelulusan() {
        assertEquals("Lulus", pengolahanNilaiMahasiswa.tentukanStatusKelulusan(60));
        assertEquals("Tidak Lulus", pengolahanNilaiMahasiswa.tentukanStatusKelulusan(59));
    }

    @Test
    void prosesMenghasilkanHasil() {
        PengolahanNilaiMahasiswa.Mahasiswa mahasiswa = new PengolahanNilaiMahasiswa.Mahasiswa("Budi", 80, 80, 85);

        PengolahanNilaiMahasiswa.HasilPengolahan hasil = pengolahanNilaiMahasiswa.proses(mahasiswa);

        assertEquals(82.0, hasil.nilaiAkhir(), 0.0001);
        assertEquals('B', hasil.grade());
        assertEquals("Lulus", hasil.statusKelulusan());
    }

    @Test
    void prosesMelemparException() {
        PengolahanNilaiMahasiswa.Mahasiswa mahasiswa = new PengolahanNilaiMahasiswa.Mahasiswa("Ani", 0, 0, 0);

        assertThrows(IllegalArgumentException.class, () -> pengolahanNilaiMahasiswa.proses(mahasiswa));
    }
}