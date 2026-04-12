package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PengolahanNilaiMahasiswaTest {
    private final PengolahanNilaiMahasiswa pengolahanNilaiMahasiswa = new PengolahanNilaiMahasiswa();

    @Test
    void TC1_P1_validasiNilaiNormal() {
        assertEquals(true, pengolahanNilaiMahasiswa.isNilaiValid(80, 75, 90));
    }

    @Test
    void TC2_P2_nilaiTugasTidakValid() {
        assertEquals(false, pengolahanNilaiMahasiswa.isNilaiValid(-1, 75, 90));
    }

    @Test
    void TC3_P3_nilaiUtsTidakValid() {
        assertEquals(false, pengolahanNilaiMahasiswa.isNilaiValid(80, 120, 90));
    }

    @Test
    void TC4_P4_nilaiUasTidakValid() {
        assertEquals(false, pengolahanNilaiMahasiswa.isNilaiValid(80, 75, -10));
    }

    @Test
    void TC5_P5_semuaNilaiNol() {
        assertEquals(false, pengolahanNilaiMahasiswa.isNilaiValid(0, 0, 0));
    }

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

    @Test
    void mintaInputMengembalikanMahasiswaSaatDataValid() {
        String input = "Budi\n80\n75\n90\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        PengolahanNilaiMahasiswa.Mahasiswa mahasiswa = pengolahanNilaiMahasiswa.mintaInput(scanner);

        assertEquals("Budi", mahasiswa.nama());
        assertEquals(80.0, mahasiswa.nilaiTugas(), 0.0001);
        assertEquals(75.0, mahasiswa.nilaiUts(), 0.0001);
        assertEquals(90.0, mahasiswa.nilaiUas(), 0.0001);
    }

    @Test
    void mintaInputMengulangSampaiDataValid() {
        String input = "Ani\n-1\n70\n80\nAni\n80\n70\n90\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        PengolahanNilaiMahasiswa.Mahasiswa mahasiswa = pengolahanNilaiMahasiswa.mintaInput(scanner);

        assertEquals("Ani", mahasiswa.nama());
        assertEquals(80.0, mahasiswa.nilaiTugas(), 0.0001);
        assertEquals(70.0, mahasiswa.nilaiUts(), 0.0001);
        assertEquals(90.0, mahasiswa.nilaiUas(), 0.0001);
    }
}