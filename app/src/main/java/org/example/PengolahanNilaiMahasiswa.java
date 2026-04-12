package org.example;

import java.util.Scanner;

public class PengolahanNilaiMahasiswa {
    public Mahasiswa mintaInput(Scanner scanner) {
        while (true) {
            System.out.print("Masukkan Nama Mahasiswa       : ");
            String nama = scanner.nextLine().trim();
            if (nama.isEmpty()) {
                nama = "Tanpa Nama";
            }

            System.out.print("Masukkan Nilai Tugas (0-100)  : ");
            double nilaiTugas = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Masukkan Nilai UTS (0-100)    : ");
            double nilaiUts = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Masukkan Nilai UAS (0-100)    : ");
            double nilaiUas = Double.parseDouble(scanner.nextLine().trim());

            if (isNilaiValid(nilaiTugas, nilaiUts, nilaiUas)) {
                return new Mahasiswa(nama, nilaiTugas, nilaiUts, nilaiUas);
            }

            System.out.println("\n[ERROR] Data nilai tidak valid. Silakan input ulang.\n");
        }
    }

    public boolean isNilaiValid(double nilaiTugas, double nilaiUts, double nilaiUas) {
        if (nilaiTugas < 0 || nilaiTugas > 100) {
            return false;
        }

        if (nilaiUts < 0 || nilaiUts > 100) {
            return false;
        }

        if (nilaiUas < 0 || nilaiUas > 100) {
            return false;
        }

        if (nilaiTugas == 0 && nilaiUts == 0 && nilaiUas == 0) {
            return false;
        }

        return true;
    }

    public double hitungNilaiAkhir(double nilaiTugas, double nilaiUts, double nilaiUas) {
        if (!isNilaiValid(nilaiTugas, nilaiUts, nilaiUas)) {
            return -1;
        }

        double nilaiAkhir = (0.3 * nilaiTugas) + (0.3 * nilaiUts) + (0.4 * nilaiUas);

        if (nilaiAkhir > 100) {
            return -1;
        }

        return nilaiAkhir;
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
        if (nilaiAkhir >= 60) {
            return "Lulus";
        }

        return "Tidak Lulus";
    }

    public HasilPengolahan proses(Mahasiswa mahasiswa) {
        double nilaiAkhir = hitungNilaiAkhir(
                mahasiswa.nilaiTugas(),
                mahasiswa.nilaiUts(),
                mahasiswa.nilaiUas());

        if (nilaiAkhir < 0) {
            throw new IllegalArgumentException(
                    "Data nilai tidak valid. Pastikan rentang 0-100 dan tidak semua nilai bernilai 0.");
        }

        char grade = tentukanGrade(nilaiAkhir);
        String statusKelulusan = tentukanStatusKelulusan(nilaiAkhir);
        return new HasilPengolahan(nilaiAkhir, grade, statusKelulusan);
    }

    public record Mahasiswa(String nama, double nilaiTugas, double nilaiUts, double nilaiUas) {
    }

    public record HasilPengolahan(double nilaiAkhir, char grade, String statusKelulusan) {
    }
}