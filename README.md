# Praktikum 1: Struktur Proyek Android

## A. Mengenal Android Studio
Android Studio adalah **Integrated Development Environment (IDE)** resmi untuk pengembangan aplikasi Android. Berbasis editor kode dan alat developer yang andal dari IntelliJ IDEA, Android Studio menawarkan lebih banyak fitur yang mampu meningkatkan produktivitas Anda saat membangun aplikasi Android, seperti:

- **Sistem build berbasis Gradle yang fleksibel**
- **Emulator yang cepat dan kaya fitur**
- **Lingkungan terpadu tempat Anda bisa mengembangkan aplikasi untuk semua perangkat Android**
- **Edit Live untuk mengupdate composable di emulator dan perangkat fisik secara real time**
- **Template kode dan integrasi GitHub untuk membantu Anda membuat fitur aplikasi umum dan mengimpor kode sampel**
- **Framework dan alat pengujian yang lengkap**
- **Alat lint untuk merekam/memeriksa performa, kegunaan, kompatibilitas versi, dan masalah lainnya**
- **Dukungan C++ dan NDK**
- **Dukungan bawaan untuk Google Cloud Platform**, yang memudahkan integrasi Google Cloud Messaging dan App Engine

## B. Struktur Proyek
Setiap proyek di Android Studio berisi satu atau beberapa modul dengan file kode sumber dan file resource. Jenis modul meliputi:

- **Modul aplikasi Android**
- **Modul library**
- **Modul Google App Engine**

Secara default, Android Studio menampilkan file proyek Anda dalam tampilan **Project Android**, yang disusun menurut modul untuk memberikan akses cepat ke file sumber utama proyek Anda. Semua file build terlihat di tingkat atas, di bagian **Gradle Scripts**. Setiap modul aplikasi berisi folder berikut:

1. **Manifes**  
   Berisi file `AndroidManifest.xml`. File ini digunakan untuk melakukan beberapa pengaturan seperti:
   - Nama aplikasi
   - Icon aplikasi
   - Theme style
   - User permission (jika membuat aplikasi yang membutuhkan akses hardware smartphone ataupun koneksi internet)

2. **Java**  
   Di folder ini terdapat file `MainActivity.java` yang digunakan untuk memberikan perintah agar aplikasi melakukan sesuatu menggunakan bahasa pemrograman Java.

3. **Res Drawable**  
   Folder yang digunakan untuk memasukkan gambar pendukung aplikasi yang kita buat, baik berupa icon ataupun lainnya. Cara memasukkan gambar ke folder ini cukup mudah:
   - Klik kanan pada folder drawable, pilih **Show in Explorer**, kemudian copykan gambar yang sudah kita siapkan di komputer ke folder drawable.

4. **Res Layout**  
   Folder ini berisi file `activity_main.xml` yang digunakan untuk pengaturan layout untuk antarmuka utama pada aplikasi Android. Saat pertama kali dibuka, file ini biasanya memiliki kode default.

5. **Mipmap**  
   Folder ini digunakan untuk memasukkan gambar berupa icon. Icon default aplikasi yang kita buat juga diambil dari folder ini.

6. **Values**
   - **`colors.xml`**: Berisi kode-kode untuk pengaturan warna, seperti warna status bar, teks, ataupun lainnya.
   - **`strings.xml`**: Digunakan untuk pengaturan teks-teks aplikasi yang dibuat.
   - **`styles.xml`**: Digunakan untuk memberikan nama warna setelah kode-kode warna dimasukkan atau disetting pada `colors.xml`. File ini juga bisa disebut theme dasar dari aplikasi Android.

Untuk melihat struktur file proyek sebenarnya, pilih **Project**, bukan **Android**, dari menu Project.

## C. Sistem Build Gradle
Android Studio menggunakan **Gradle** sebagai dasar sistem build, dengan lebih banyak kemampuan khusus Android yang disediakan oleh plugin Android Gradle. Sistem build ini berjalan sebagai alat terintegrasi dari menu Android Studio dan terpisah dari command line. Anda dapat menggunakan fitur-fitur sistem build untuk:

- **Menyesuaikan, mengonfigurasi, dan memperluas proses build**
- **Membuat banyak APK untuk aplikasi Anda dengan berbagai fitur yang menggunakan project dan modul yang sama**
- **Menggunakan kembali kode dan resource ke seluruh set sumber build**

Berkat fleksibilitas Gradle, Anda dapat mencapai semua ini tanpa mengubah file sumber inti aplikasi Anda. File build Android Studio diberi nama `build.gradle.kts` jika Anda menggunakan Kotlin (direkomendasikan) atau `build.gradle` jika Anda menggunakan Groovy. File tersebut adalah file teks biasa yang menggunakan sintaksis Kotlin atau Groovy untuk mengonfigurasi build dengan elemen yang disediakan oleh plugin Android Gradle.

### Varian Build
Sistem build dapat membantu Anda membuat beberapa versi berbeda untuk aplikasi yang sama dari satu proyek. Hal ini berguna saat Anda menyediakan aplikasi dalam versi gratis dan berbayar atau jika Anda ingin mendistribusikan beberapa APK untuk berbagai konfigurasi perangkat di Google Play.

### Dukungan Multi-APK
Dukungan multi-APK memungkinkan Anda membuat beberapa APK sekaligus secara efisien berdasarkan kepadatan layar atau ABI. Misalnya, Anda dapat membuat APK aplikasi terpisah untuk kepadatan layar **hdpi** dan **mdpi**, sambil tetap mempertimbangkannya sebagai satu varian dan mengizinkannya berbagi setelan APK pengujian, javac, dx, dan ProGuard.

### Penyingkatan Resource
Penyingkatan resource di Android Studio otomatis menghapus resource yang tidak digunakan dari aplikasi terpaket dan dependensi library Anda. Misalnya, jika aplikasi Anda menggunakan layanan Google Play untuk mengakses fungsi Google Drive, dan saat ini Anda tidak menggunakan Login dengan Google, penyingkatan resource dapat menghapus beragam aset drawable untuk tombol SignInButton.

### Mengelola Dependensi
Dependensi untuk proyek Anda ditetapkan berdasarkan nama dalam skrip build level modul. Gradle menemukan dependensi dan menyediakannya di build Anda. Anda dapat mendeklarasikan:

- **Dependensi modul**
- **Dependensi biner jarak jauh**
- **Dependensi biner lokal**

Android Studio mengonfigurasi proyek untuk menggunakan **Maven Central Repository** secara default. Konfigurasi ini disertakan dalam file build level atas untuk proyek.

## Persiapan Proyek Baru
Agar lebih memahami lingkungan kerja sekaligus cara pembuatan proyek Android, mulailah dengan sebuah proyek baru. Namun, sebelum proses pembuatan proyek dilakukan, Anda harus memiliki tiga buah komponen yang dapat diunduh langsung dari situs resminya. Komponen tersebut adalah:

1. **Java JDK**  
   Unduh dari [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) dan pilih Java JDK terbaru.

2. **Android Studio**  
   Unduh dari [Android Studio](https://developer.android.com/studio/index.html).

3. **Android SDK**  
   Unduh dari [Android SDK](http://developer.android.com/sdk/index.html). Saat mendownload, jangan lupa pilih platform atau sistem operasi yang sesuai dengan milik Anda. Sistem operasi yang digunakan dalam panduan ini adalah **Windows**.

