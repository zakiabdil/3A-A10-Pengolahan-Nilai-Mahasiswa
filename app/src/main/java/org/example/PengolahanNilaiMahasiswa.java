package org.example;

import java.util.Scanner;

public class PengolahanNilaiMahasiswa {
    public Mahasiswa mintaInput(Scanner scanner) {
        System.out.print("Masukkan Nama Mahasiswa       : ");
        String nama = scanner.nextLine().trim();
        if (nama.isEmpty()) {
            nama = "Tanpa Nama";
        }

        double nilaiTugas = bacaNilai(scanner, "Masukkan Nilai Tugas (0-100)  : ");
        double nilaiUts = bacaNilai(scanner, "Masukkan Nilai UTS (0-100)    : ");
        double nilaiUas = bacaNilai(scanner, "Masukkan Nilai UAS (0-100)    : ");

        return new Mahasiswa(nama, nilaiTugas, nilaiUts, nilaiUas);
    }

    public boolean isNilaiValid(double nilaiTugas, double nilaiUts, double nilaiUas) {
        if (!isDalamRentang(nilaiTugas) || !isDalamRentang(nilaiUts) || !isDalamRentang(nilaiUas)) {
            return false;
        }

        return !(nilaiTugas == 0 && nilaiUts == 0 && nilaiUas == 0);
    }

    public double hitungNilaiAkhir(double nilaiTugas, double nilaiUts, double nilaiUas) {
        if (!isNilaiValid(nilaiTugas, nilaiUts, nilaiUas)) {
            return -1;
        }

        double nilaiAkhir = (0.3 * nilaiTugas) + (0.3 * nilaiUts) + (0.4 * nilaiUas);
        return nilaiAkhir > 100 ? -1 : nilaiAkhir;
    }

    public char tentukanGrade(double nilaiAkhir) {
        if (nilaiAkhir >= 85) {
            return 'A';
        }
        if (nilaiAkhir >= 70) {
            return 'B';
        }
        if (nilaiAkhir >= 60) {
            return 'C';
        }
        if (nilaiAkhir >= 50) {
            return 'D';
        }
        return 'E';
    }

    public String tentukanStatusKelulusan(double nilaiAkhir) {
        return nilaiAkhir > 60 ? "Lulus" : "Tidak Lulus";
    }

    public HasilPengolahan proses(Mahasiswa mahasiswa) {
        if (!isNilaiValid(mahasiswa.nilaiTugas(), mahasiswa.nilaiUts(), mahasiswa.nilaiUas())) {
            throw new IllegalArgumentException(
                    "Data nilai tidak valid. Pastikan rentang 0-100 dan tidak semua nilai bernilai 0.");
        }

        double nilaiAkhir = hitungNilaiAkhir(
                mahasiswa.nilaiTugas(),
                mahasiswa.nilaiUts(),
                mahasiswa.nilaiUas());

        if (nilaiAkhir < 0) {
            throw new IllegalStateException("Perhitungan nilai akhir gagal karena data tidak valid.");
        }

        char grade = tentukanGrade(nilaiAkhir);
        String statusKelulusan = tentukanStatusKelulusan(nilaiAkhir);
        return new HasilPengolahan(nilaiAkhir, grade, statusKelulusan);
    }

    private double bacaNilai(Scanner scanner, String pesan) {
        System.out.print(pesan);
        return Double.parseDouble(scanner.nextLine().trim());
    }

    private boolean isDalamRentang(double nilai) {
        return nilai >= 0 && nilai <= 100;
    }

    public record Mahasiswa(String nama, double nilaiTugas, double nilaiUts, double nilaiUas) {
    }

    public record HasilPengolahan(double nilaiAkhir, char grade, String statusKelulusan) {
    }
}