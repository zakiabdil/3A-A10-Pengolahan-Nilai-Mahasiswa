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
    void validasiSemuaNolTidakValid() {
        assertEquals(false, pengolahanNilaiMahasiswa.isNilaiValid(0, 0, 0));
    }

    @Test
    void hitungNilaiAkhirValid() {
        assertEquals(82.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(80, 80, 85), 0.0001);
    }

    @Test
    void hitungNilaiAkhirInvalidMengembalikanMinusSatu() {
        assertEquals(-1.0, pengolahanNilaiMahasiswa.hitungNilaiAkhir(-1, 80, 85), 0.0001);
    }

    @Test
    void tentukanGradeSesuaiRentang() {
        assertEquals('A', pengolahanNilaiMahasiswa.tentukanGrade(85));
        assertEquals('B', pengolahanNilaiMahasiswa.tentukanGrade(70));
        assertEquals('C', pengolahanNilaiMahasiswa.tentukanGrade(60));
        assertEquals('D', pengolahanNilaiMahasiswa.tentukanGrade(50));
        assertEquals('E', pengolahanNilaiMahasiswa.tentukanGrade(49));
    }

    @Test
    void tentukanStatusSesuaiBatasKelulusan() {
        assertEquals("Lulus", pengolahanNilaiMahasiswa.tentukanStatusKelulusan(60));
        assertEquals("Tidak Lulus", pengolahanNilaiMahasiswa.tentukanStatusKelulusan(59));
    }

    @Test
    void prosesMenghasilkanNilaiAkhirGradeDanStatus() {
        PengolahanNilaiMahasiswa.Mahasiswa mahasiswa = new PengolahanNilaiMahasiswa.Mahasiswa("Budi", 80, 80, 85);

        PengolahanNilaiMahasiswa.HasilPengolahan hasil = pengolahanNilaiMahasiswa.proses(mahasiswa);

        assertEquals(82.0, hasil.nilaiAkhir(), 0.0001);
        assertEquals('B', hasil.grade());
        assertEquals("Lulus", hasil.statusKelulusan());
    }

    @Test
    void prosesMelemparExceptionJikaDataTidakValid() {
        PengolahanNilaiMahasiswa.Mahasiswa mahasiswa = new PengolahanNilaiMahasiswa.Mahasiswa("Ani", 0, 0, 0);

        assertThrows(IllegalArgumentException.class, () -> pengolahanNilaiMahasiswa.proses(mahasiswa));
    }
}