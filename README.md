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


# Praktikum 2: Layout

**Layout** adalah cara untuk mengatur tata letak suatu komponen dalam pemrograman Android. Untuk mengatur antarmuka aplikasi Android, digunakan sebuah file XML. File XML tersebut digunakan untuk mengatur elemen seperti teks, tombol, dan komponen lainnya. File XML ini diletakkan pada direktori:

```
project_android -> res -> layout
```

## Jenis Layout
Berikut adalah beberapa jenis layout yang dapat digunakan dalam pengembangan aplikasi Android:

### 1. **Relative Layout**
Relative Layout memungkinkan Anda mengatur posisi sebuah komponen terhadap komponen lainnya. Contoh:
- Tombol **OK** berada di bawah **EditText**.
- Tombol **Cancel** berada di sebelah kanan tombol **OK** dan di bawah **EditText**.
Inti dari Relative Layout adalah saling berkaitannya posisi komponen satu dengan yang lain.

### 2. **Linear Layout**
Linear Layout merupakan layout yang **memberikan susunan tata letak** komponen secara **garis 
lurus baik vertikal maupun horizontal**. 

![image](https://github.com/user-attachments/assets/2d3598fd-3eb7-4b81-85b2-05e0dba5ecc6)


### 3. **Table Layout**
Table Layout **memberikan tata letak** komponen **berdasarkan susunan tabel** (baris dan kolom), mirip dengan struktur tabel pada HTML.

![image](https://github.com/user-attachments/assets/1be8d2e5-e308-4ee7-9e1a-409b8a818b18)

**Gambar 2.2: Table Layout**

### 4. **Frame Layout**
Frame Layout **memberikan tata letak** komponen yang **saling bertumpuk satu sama lain**. Komponen yang ditambahkan akan ditempatkan di atas komponen sebelumnya.

### 5. **Constraint Layout**
Constraint Layout adalah salah satu komponen **ViewGroup** yang digunakan untuk menyusun **tampilan aplikasi kompleks tanpa menggunakan nested layout**. ConstraintLayout tersedia dengan dukungan kompatibilitas mulai dari Android 2.3 (API Level 9) sampai dengan yang terbaru. 

**Gambar 2.4: Constraint Layout**

### 6. **Scroll View**
Dalam pengembangan aplikasi android biasanya sering terkendala dengan ukuran tampilan layar. 
Konten yang ingin dimasukkan cukup banyak sehingga layar tidak dapat menampilkannya dalam 
satu layar. ScrollView digunakan untuk mengatasi masalah tersebut. Pasti sudah tidak asing lagikan 
dengan Scroll View ini? 

### 7. **Kombinasi Layout**
Beberapa layout yang telah dijelaskan sebelumnya juga dapat dikombinasikan. Kombinasi layout 
tersebut bertujuan agar antarmuka yang dibangun menjadi lebih bagus dan sesuai dengan 
keinginan. Kombinasi layout dapat dipilih sesuai dengan kebutuhan antarmuka. 
Bagian ini menjadi dasar untuk mengembangkan User Interface sebuah aplikasi. Jangan pedulikan 
scriptnya dahulu, karena kelihatanya banyak dan susah, namun sebenarnya sangat sederhana dan 
mudah dimengerti. Semakin banyak Anda berlatih coding, semakin paham juga maksud programnya.

# PRAKTIKUM 3: PENGENALAN WIDGET FORM

**Basic Views** merupakan alat dasar yang digunakan untuk menampilkan sesuatu di dalam Android sesuai dengan kebutuhannya, umumnya seperti **TextView, EditText, Button, ImageButton, ImageView, Checkbox, ToggleButton, RadioButton, dan RadioGroup.**

## a. Atribut
Untuk menentukan bagaimana objek View akan ditampilkan di layar maka kita perlu menambahkan atribut pada objek View. Kita dapat menambahkan atribut pada tag XML.

Contoh: Mengatur atribut panjang dan tinggi suatu View dapat kita tentukan dengan menuliskan kode di bawah:
```xml
android:layout_width="match_parent"
android:layout_height="wrap_content"
```

## b. Identifier
Kita menggunakan atribut `id` pada tag XML untuk memberikan identifier pada objek View kita. Id tersebut akan kita gunakan untuk mereferensikan objek tersebut. Gunakan atribut `id="@+id/namaId"` untuk menambahkan id pada objek View.

## Penjelasan Basic Views

1. **TextView**: Digunakan untuk menampilkan teks di layar.
2. **EditText**: Merupakan subclass dari Views TextView, bedanya memungkinkan pengguna untuk mengedit isi teks.  
   _Gambar 3.2 Tampilan EditText_
3. **Button**: Mewakili sebuah widget tombol push.  
   _Gambar 3.3 Tampilan Button_
4. **ImageButton**: Mirip dengan tampilan Button, perbedaannya dapat menampilkan gambar sebagai tombol.  
   _Gambar 3.4 Tampilan ImageButton_
5. **CheckBox**: Berfungsi sebagai tipe khusus dari tombol yang memiliki dua keadaan yaitu checked atau unchecked.
6. **ToggleButton**: Berfungsi untuk menampilkan keadaan checked atau unchecked menggunakan lampu indikator.  
   _Gambar 3.6 Tampilan ToggleButton_
7. **RadioButton**: Memiliki dua keadaan yaitu checked atau unchecked. Sekali sebuah RadioButton diberi checked, maka tidak dapat di-unchecked kembali. Sebuah **RadioGroup** digunakan untuk mengelompokkan satu atau lebih views RadioButton, dengan demikian mengizinkan hanya satu RadioButton yang akan di-checked dalam RadioGroup.  
   _Gambar 3.7 Tampilan RadioButton_

## c. View Binding
View binding memungkinkan pengikatan langsung antara file layout XML dan kode Java/Kotlin tanpa perlu menggunakan `findViewById()`. Langkah-langkah penggunaannya meliputi mengaktifkan view binding di proyek Android Studio.

## d. Intent
**Intent** adalah mekanisme yang digunakan dalam platform Android untuk berkomunikasi antara komponen aplikasi, seperti **Activity, Service, BroadcastReceiver, dan ContentProvider.** Intent digunakan untuk memulai komponen baru, memulai layanan latar belakang, mengirim dan menerima pesan antar komponen, dan melakukan tugas lain yang melibatkan komunikasi antar komponen dalam aplikasi Android.

### Intent dapat memiliki dua jenis:

1. **Explicit Intent**: Berfungsi untuk mengaktifkan komponen-komponen dalam satu aplikasi yang sama. Misalnya, berpindah Activity.  
   Explicit intents mendefinisikan suatu komponen yang harus dipanggil oleh sistem Android dengan menggunakan Java class sebagai identifier.

2. **Implicit Intent**: Berfungsi untuk memanggil fungsi Activity yang sudah ada di fungsi internal Android seperti Dial Number, Open Browser, dan lainnya.  
   Implicit intents meminta sistem untuk melakukan service tanpa memberitahu sistem kelas Java mana yang harus melakukan layanan ini. Dalam membangun sebuah implicit intents, Anda harus menentukan tindakan yang harus dilakukan dan opsional suatu URI yang harus digunakan untuk tindakan ini. Misalnya, Anda bisa mengatakan sistem yang ingin Anda lihat (tindakan) adalah sebuah halaman web (URI). Dengan memulai intent untuk ini data sistem akan mencoba untuk menemukan sebuah aplikasi yang terdaftar untuk acara ini, misalnya browser.

### Hasil Intent:

1. Explicit Intent
2. Implicit Intent
3. Mengirim data melalui Intent

### Contoh Explicit Intent:
Baris berikut menunjukkan bagaimana membuat sebuah explicit intent dan mengirimkan suatu variable ke sistem Android. Jika ada class yang merepresentasikan sebuah Activity Intents maka harus di-start oleh sistem Android.
```kotlin
val intent = Intent(this, ActivityTujuan::class.java)
    .putExtra("KEY_VALUE1", "Value1")
    .putExtra("KEY_VALUE2", "Value2")
startActivity(intent)
```
Komponen yang menerima Intents dapat menggunakan metode `getIntent().getExtras()` untuk mendapatkan variable data yang dikirim.
```kotlin
val value1 = intent.getStringExtra("KEY_VALUE1")
val value2 = intent.getStringExtra("KEY_VALUE2")
```

### Contoh Implicit Intent:
Sedangkan implicit intents dikhususkan untuk sebuah aksi yang harus dilaksanakan dan terdapat data opsional dari aksi tersebut.
```kotlin
val intent = Intent(Intent.ACTION_VIEW).apply {
    data = Uri.parse("https://www.google.com")
}
startActivity(intent)
```



# PRAKTIKUM 4: ROOM DATABASE

Room Database adalah library dari Android Jetpack yang menyediakan cara lebih mudah untuk membuat, mengelola, dan berinteraksi dengan database SQLite pada aplikasi Android. Room menyediakan lapisan abstraksi di atas SQLite untuk menyederhanakan penggunaan database dalam proyek Android.

Room Database adalah salah satu cara untuk menyimpan data secara lokal di aplikasi Android. Dalam konteks ini, penyimpanan lokal berarti data disimpan di perangkat pengguna, biasanya di dalam database SQLite, sehingga dapat diakses dan digunakan ketika aplikasi dijalankan, bahkan tanpa koneksi internet.

## Pengertian dan Fitur Utama dari Room Database

### Basis Data SQLite
Room menggunakan SQLite sebagai basis data lokal untuk menyimpan data secara persisten dalam aplikasi Android.

### Lapisan Abstraksi
Room menyediakan lapisan abstraksi yang memungkinkan Anda berinteraksi dengan database menggunakan konsep objek daripada menggunakan kueri SQL mentah. Anda dapat mengakses database menggunakan metode yang didefinisikan di dalam DAO (Data Access Object) tanpa harus menulis kueri SQL secara langsung.

### Entity
Entity adalah representasi kelas Java yang mewakili tabel dalam database SQLite. Setiap entitas (Entity) biasanya memiliki atribut yang mewakili kolom dalam tabel.

### DAO (Data Access Object)
DAO adalah antarmuka yang berisi deklarasi metode untuk mengakses data dari database. Metode-metode ini dapat digunakan untuk mengambil, menyisipkan, memperbarui, atau menghapus entitas dari database.

### Database
Database adalah entitas yang mewakili basis data SQLite dalam aplikasi Anda. Ini biasanya merupakan kelas abstract yang mengextend `RoomDatabase`. Database menyediakan metode untuk mendapatkan instance DAO dan menginisialisasi database.

### Migrasi
Room menyediakan mekanisme migrasi yang memungkinkan Anda memperbarui skema database tanpa kehilangan data yang ada.

# PRAKTIKUM 5: RECYCLERVIEW

RecyclerView adalah komponen antarmuka pengguna (UI) yang disediakan oleh Android untuk menampilkan daftar item dengan cara yang lebih fleksibel dan efisien daripada ListView. Ini adalah bagian dari Android Jetpack, yang merupakan kumpulan alat untuk membantu Anda membangun aplikasi Android yang lebih baik dan lebih mudah.

Berikut adalah beberapa poin penting tentang RecyclerView:

### a. View Recycling
Salah satu fitur paling penting dari RecyclerView adalah kemampuannya untuk mendaur ulang tampilan (View Recycling). Ini berarti saat Anda menggulir melalui daftar, tampilan item yang tidak terlihat dihapus dari layar dan digunakan kembali untuk menampilkan item-item baru yang muncul.

### b. LayoutManager
RecyclerView memiliki konsep LayoutManager yang memungkinkan Anda untuk mengatur cara tampilan item ditampilkan di dalam RecyclerView. Anda dapat menggunakan **LinearLayoutManager** untuk membuat daftar linear vertikal atau horizontal, **GridLayoutManager** untuk tata letak kotak, atau **StaggeredGridLayoutManager** untuk tampilan kotak dengan ukuran berbeda.

### c. Adapter
Seperti ListView, RecyclerView juga menggunakan konsep adapter untuk menghubungkan data dengan tampilan. Anda perlu membuat kelas Adapter yang mewarisi **RecyclerView.Adapter**. Adapter ini bertanggung jawab untuk mengembalikan tampilan (ViewHolder) yang sesuai dan mengisi data ke dalam tampilan tersebut.

### d. ViewHolder
ViewHolder adalah komponen yang menyimpan referensi ke tampilan individu dalam daftar. Ini membantu dalam menghindari pemanggilan **findViewById** berulang-ulang, yang dapat merugikan kinerja aplikasi. Setiap item dalam RecyclerView memiliki ViewHolder yang berkorespondensi dengan tampilan item itu sendiri.

### e. Listener dan Interaksi
Anda dapat menambahkan pendengar klik atau interaksi lainnya pada tampilan item dalam ViewHolder. Ini memudahkan implementasi tindakan yang sesuai ketika pengguna berinteraksi dengan item dalam daftar.

### f. Fleksibilitas dan Kustomisasi
Dibandingkan dengan ListView, RecyclerView jauh lebih fleksibel dan memungkinkan Anda untuk mengatur tampilan dan perilaku item dengan lebih terperinci.

Dalam keseluruhan, RecyclerView merupakan pilihan yang lebih disarankan saat Anda ingin menampilkan daftar item dalam aplikasi Android Anda, karena kemampuannya untuk mendaur ulang tampilan dan kinerja yang lebih baik.


# PRAKTIKUM 6: SERVICE

Secara umum, **service** adalah Komponen Aplikasi Android yang bekerja di belakang layar, tanpa user interface dan interaksi dengan pengguna. Contohnya adalah ketika kita menggunakan Gmail yang tanpa kita buka aplikasinya bisa menotifikasi kalau ada email baru masuk. **Service** juga bisa dikatakan sebuah komponen aplikasi yang bisa melakukan operasi yang berjalan lama di latar belakang dan tidak menyediakan antarmuka pengguna. Komponen aplikasi lain bisa memulai layanan, dan komponen aplikasi tersebut akan terus berjalan di latar belakang walaupun pengguna beralih ke aplikasi lain. Selain itu, komponen bisa mengikat ke layanan untuk berinteraksi dengannya dan bahkan melakukan komunikasi antarproses (IPC). Misalnya, layanan mungkin menangani transaksi jaringan, memutar musik, melakukan file I/O, atau berinteraksi dengan penyedia materi dari latar belakang. Berikut adalah tiga tipe layanan yang berbeda:

## Foreground
Layanan latar depan melakukan beberapa operasi yang terlihat oleh pengguna. Misalnya, aplikasi audio akan menggunakan layanan latar depan untuk memutar track audio. Layanan latar depan harus menampilkan **Notifikasi**. Layanan latar depan terus berjalan bahkan saat pengguna tidak berinteraksi dengan aplikasi.

## Background
Layanan latar belakang melakukan operasi yang tidak terlihat secara langsung oleh pengguna. Misalnya, jika aplikasi menggunakan layanan untuk memadatkan penyimpanannya, aplikasi tersebut biasanya akan menjadi layanan latar belakang.

## Bound
Sebuah layanan akan **bound** bila komponen aplikasi mengikatkan kepadanya dengan memanggil `bindService()`. Layanan terikat menawarkan antarmuka klien-server yang memungkinkan komponen berinteraksi dengan layanan tersebut, mengirim permintaan, mendapatkan hasil, dan bahkan melakukannya pada sejumlah proses dengan komunikasi antarproses (IPC). Layanan terikat hanya berjalan selama komponen aplikasi terikat padanya. Beberapa komponen bisa diikat ke layanan sekaligus, namun bila semuanya telah dilepas, layanan akan dimusnahkan.

Walaupun dokumentasi ini umumnya membahas layanan yang dimulai dan terikat secara terpisah, layanan Anda bisa bekerja dengan dua cara—layanan tersebut bisa dimulai (untuk berjalan terus-menerus) dan juga memungkinkan pengikatan. Ini hanyalah masalah apakah Anda mengimplementasikan beberapa metode callback: `onStartCommand()` untuk memungkinkan komponen memulainya dan `onBind()` untuk memungkinkan pengikatan.

Apakah service sudah dimulai, bound, atau keduanya, semua komponen aplikasi bisa menggunakan **service** (bahkan dari aplikasi terpisah), demikian pula semua komponen bisa menggunakan suatu aktivitas—dengan memulainya dengan **Intent**. Akan tetapi, Anda bisa mendeklarasikan layanan sebagai privat pada file manifes, dan memblokir akses dari aplikasi lain. Hal ini dibahas selengkapnya di bagian tentang **Mendeklarasikan layanan dalam manifes**.

Seperti aktivitas, **service** memiliki metode callback daur hidup yang bisa Anda implementasikan untuk memantau perubahan keadaan layanan dan melakukan pekerjaan pada waktu yang sesuai. Diagram berikut memperagakan setiap metode daur hidup:
![image](https://github.com/user-attachments/assets/c6bd8965-8d95-4174-8108-61b3a5f2bcc7)


**Gambar 1. Daur hidup layanan.** Diagram di sebelah kiri menampilkan daur hidup bila layanan dibuat dengan `startService()` dan diagram di sebelah kanan menampilkan daur hidup bila layanan dibuat dengan `bindService()`. 

# PRAKTIKUM 7: KONSUMSI REST API

## Apa itu API?
API adalah singkatan dari Application Programming Interface, yaitu sebuah software yang memungkinkan para developer untuk mengintegrasikan dan mengizinkan dua aplikasi yang berbeda secara bersamaan untuk saling terhubung satu sama lain.

Tujuan penggunaan dari API adalah untuk saling berbagi data antar aplikasi yang berbeda tersebut. Tujuan penggunaan API lainnya yaitu untuk mempercepat proses pengembangan aplikasi dengan menyediakan sebuah function yang terpisah sehingga para developer tidak perlu lagi membuat fitur yang serupa.

Istilah “API” sebenarnya tidak ada hubungannya dengan hal-hal yang berkaitan dengan web, karena istilah tersebut sudah ada sebelum web. Hal ini semacam dikooptasi yang berarti “pemanggilan web service”. Tapi secara tradisional, pengertian API lebih berkaitan dengan fungsi-fungsi yang disediakan oleh Sistem Operasi.

## Apa itu REST API?
REST, atau Representational State Transfer, adalah API yang mengikuti seperangkat aturan untuk aplikasi dan layanan agar dapat berkomunikasi satu sama lain.

REST API bekerja dengan mengajukan permintaan untuk sumber daya dan mengembalikan semua informasi yang relevan tentang sumber daya tersebut, diterjemahkan ke dalam format yang dapat dengan mudah ditafsirkan oleh klien. Klien juga dapat memodifikasi item di server dan bahkan menambahkan item baru ke server melalui REST API.

## Apa itu RESTful API?
RESTful API adalah Application Programming Interface (API) yang mematuhi batasan arsitektur REST dan berinteraksi dengan layanan web RESTful. RESTful API juga mengikuti prinsip REST API.

RESTful API lebih skalabel dan memiliki masa pakai yang lebih lama. RESTful API menggunakan permintaan HTTP untuk mengakses dan menggunakan data. Ada beberapa permintaan HTTP dasar yang dapat dibuat klien, yaitu:

- **GET** — Untuk mengambil sumber daya.
- **POST** — Untuk membuat sumber daya baru.
- **PUT** — Untuk mengedit atau memperbarui sumber daya yang ada.
- **DELETE** — Untuk menghapus sumber daya.
- **OPTION** — Untuk mendapatkan operasi yang didukung oleh resource pada REST server.

## Endpoint REST API dan RESTful API
Saat pengguna membuat respons, API mengirim informasi ‘request’ dari aplikasi web atau server web, dan ia akan menerima ‘response’. Lokasi tempat API mengirim request atau tempat sumber daya berada disebut endpoint. Dalam REST API, endpoint adalah salah satu ujung saluran komunikasi.

## Kenapa Kamu Harus Menggunakan API
Mengapa harus memilih menggunakan Web API? Jika dilihat dari penjelasan di atas, sudah dapat dipahami apa saja kelebihan dan manfaat yang bisa didapatkan saat menggunakan Web API dalam pengembangan aplikasi.

Berikut alasan mengapa memilih Web API:

1. **Web API bersifat Open Source.**
2. **Tidak membutuhkan SOAP:** Saat membutuhkan Web Service dan tidak perlu SOAP, maka ASP.NET Web API adalah solusi dan pilihan terbaik.
3. **Mudah digunakan:** Web API dapat digunakan untuk membangun layanan HTTP sederhana, non-SOAP di atas WCF message pipeline.
4. **Konfigurasi yang mudah:** Tidak seperti pada layanan WCF REST.
5. **Pembuatan Service sederhana:** Pembuatan service dengan API Web cukup sederhana, berbeda dengan layanan WCF REST yang membuat pembuatan service menjadi sulit.
6. **Berbasis HTTP:** Mudah untuk didefinisikan, mengekspos, dan mengonsumsi dengan cara RESTful.
7. **Ringan dan efisien:** Berdasarkan arsitektur RESTful yang ringan dan bagus untuk perangkat dengan bandwidth terbatas seperti ponsel pintar.

## Perbedaan antara REST API dan RESTful API

Meskipun arsitektur REST dan RESTful API serupa, keduanya memiliki sedikit perbedaan:

- **REST API:**
  - Mengikuti semua aturan arsitektur REST.
  - Memiliki sistem lapisan client-server, stateless, cacheable, dengan antarmuka yang seragam.
  - Protokolnya kuat dan mewarisi banyak langkah keamanan sebagai lapisan arsitektur bawaan.
- **RESTful API:**
  - Memiliki semua fitur arsitektur REST dengan fitur tambahan yang unik.
  - Multi-layer dan memiliki protokol transport yang membuat sistem kurang aman dibandingkan dengan REST.

Saat menggunakan layanan web REST API, kerja URL didasarkan pada permintaan dan respons. Cara kerja RESTful sepenuhnya didasarkan pada aplikasi REST.

REST API sangat mudah beradaptasi dan ramah pengguna untuk semua perusahaan bisnis dan IT yang menggunakannya. RESTful API, di sisi lain, terlalu fleksibel jika dibandingkan dengan layanan web RESTLESS.
