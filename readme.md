# Program Pengolahan Nilai Mahasiswa

Repositori ini adalah proyek Gradle multi-modul untuk pengolahan nilai mahasiswa. Proyek utama terdiri dari beberapa modul yang saling terpisah, seperti `app`, `validasidata`, `penentuankelulusan`, `penentuangrade`, dan `perhitungannilaiakhir`.

## Struktur Proyek

- `app/` - modul utama yang mungkin mengandung titik masuk aplikasi.
- `validasidata/` - modul untuk validasi input dan data.
- `penentuankelulusan/` - modul untuk menentukan kelulusan mahasiswa.
- `penentuangrade/` - modul untuk menentukan grade atau nilai huruf.
- `perhitungannilaiakhir/` - modul untuk menghitung nilai akhir.

File `settings.gradle.kts` menggabungkan semua modul ini sebagai subproyek Gradle.

## Persiapan

Pastikan Anda menggunakan Windows dan menjalankan perintah Gradle dari folder root proyek

## Perintah Penting

1. `./gradlew.bat build`
   - Membangun seluruh proyek Gradle, termasuk semua submodul.
   - Menyusun kode sumber dan menghasilkan file JAR jika konfigurasi proyek sudah siap.

2. `./gradlew.bat run`
   - Menjalankan aplikasi dari proyek yang dikonfigurasi untuk tugas `run`.
   - Jika root project tidak memiliki target `run` langsung, gunakan perintah modul spesifik seperti `app:run`.

3. `./gradlew.bat test`
   - Menjalankan semua tes unit di seluruh proyek.
   - Proyek ini menggunakan `JUnit 5` sebagai dependency pengujian.

4. `gradle init`
   - Menginisialisasi proyek Gradle baru.
   - Perintah ini biasanya dilakukan satu kali saat membuat struktur Gradle pertama kali.

5. `gradle clean build`
   - Membersihkan semua hasil build sebelumnya lalu membangun ulang proyek.
   - Ini memastikan hasil build bersih tanpa cache atau build lama.

6. `gradle run -q --console=plain`
   - Menjalankan tugas `run` dengan output minimal.
   - `-q` mengaktifkan mode quiet, sedangkan `--console=plain` menonaktifkan progress bar dan pewarnaan output.

7. `app:run` atau `validasidata:run`
   - Menjalankan modul tertentu dalam proyek multi-modul.
   - Contoh: `./gradlew.bat app:run` menjalankan modul `app`.
   - Contoh: `./gradlew.bat validasidata:run` menjalankan modul `validasidata` jika modul tersebut memiliki konfigurasi aplikasi.

## Contoh Perintah Jalankan

- Membangun semua modul:
  ```powershell
  .\gradlew.bat build
  ```

- Menjalankan aplikasi modul `app`:
  ```powershell
  .\gradlew.bat app:run
  ```

- Menjalankan aplikasi dengan output polos:
  ```powershell
  gradle run -q --console=plain
  ```

- Menjalankan semua tes unit:
  ```powershell
  .\gradlew.bat test
  ```

- Membersihkan dan membangun ulang:
  ```powershell
  gradle clean build
  ```

## Laporan Build dan Tes

Setelah menjalankan `build` atau `test`, laporan dapat ditemukan di dalam folder `build/reports` untuk setiap modul. Contohnya:

- `app/build/reports`
- `validasidata/build/reports`
- `penentuankelulusan/build/reports`
- `penentuangrade/build/reports`
- `perhitungannilaiakhir/build/reports`

Untuk tes unit, lokasi umum file laporan adalah:

```text
<modul>/build/reports/tests/test/index.html
```

## Tips Struktur Program

- `settings.gradle.kts` menentukan subproyek yang diikutkan dalam build.
- Setiap submodul memiliki `build.gradle.kts` sendiri untuk konfigurasi dependency, plugin, dan tugas khusus.
- Modul `app` biasanya menjadi titik masuk aplikasi, sedangkan modul lain menyediakan logika bisnis dan validasi.
- Jika ingin menambahkan fungsi baru, buat modul baru atau perluas modul yang sudah ada dengan menambahkan kode dan dependensi di `build.gradle.kts` masing-masing.

## Catatan Tambahan

- Gunakan `./gradlew.bat` pada Windows agar versi Gradle yang dikonfigurasi pada proyek digunakan.
- `gradle` saja bisa dijalankan jika Gradle sudah terpasang sebagai command global, tetapi `./gradlew.bat` lebih aman dan konsisten.
- Perintah `gradle init` hanya perlu dijalankan jika Anda membuat ulang proyek Gradle dari awal.

---

Jika Anda ingin mengecek laporan hasil testing, buka folder `modul/build/reports` setelah build atau test selesai.
