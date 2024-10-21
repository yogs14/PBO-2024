# Desain Kelas (World of Zuul)

Desain kelas dari implementasi "World of Zuul" ini memiliki beberapa aspek yang bisa dianalisis dari segi **cohesion**, **coupling**, dan prinsip desain lainnya.

### 1. **Cohesion (Kohesi)**
Kohesi mengukur seberapa erat tanggung jawab dalam satu kelas berkaitan satu sama lain.

- **Command Class**: Memiliki tanggung jawab tunggal yaitu menyimpan dan memanipulasi kata perintah yang diinput oleh pemain. Kelas ini memiliki kohesi yang baik karena setiap atribut dan metode fokus pada tujuan tunggal tersebut.
  
- **Game Class**: Tanggung jawabnya adalah mengatur logika permainan. Kelas ini menginisialisasi ruangan, menangani masukan dari pemain, dan memproses perintah. Meski kelas ini memiliki beberapa tanggung jawab, ia tetap memiliki kohesi yang cukup baik karena setiap metode terkait dengan inti pengaturan alur permainan.

- **Room Class**: Kelas ini bertanggung jawab untuk merepresentasikan lokasi (ruangan) dalam permainan, menyimpan deskripsi ruangan dan menentukan arah keluar. Kohesi kelas ini juga cukup baik, karena tanggung jawabnya fokus pada representasi ruangan.

- **Parser Class**: Parser memiliki tanggung jawab untuk memproses input dari pemain dan menerjemahkannya menjadi objek `Command`. Kelas ini berfokus pada satu tugas, yaitu parsing input, yang menunjukkan kohesi yang kuat.

- **CommandWords Class**: Bertanggung jawab untuk mengelola daftar perintah yang valid. Tugas ini sangat jelas dan spesifik, sehingga kohesinya juga sangat baik.

### 2. **Coupling (Kopling)**
Kopling mengukur seberapa saling terkait satu kelas dengan kelas lain.

- **Command dan CommandWords**: Kelas `Command` tidak bergantung langsung pada `CommandWords`, tetapi `Parser` bergantung pada `CommandWords` untuk memvalidasi perintah. Kopling antara `Parser` dan `CommandWords` bisa dianggap wajar karena `Parser` perlu tahu perintah apa saja yang valid.

- **Game dan Room**: Kelas `Game` bergantung pada kelas `Room` untuk mengelola posisi pemain dalam ruangan, tetapi dependensi ini diatur dengan baik. Kopling antara `Game` dan `Room` bisa dianggap wajar karena game ini memang berpusat pada eksplorasi ruangan.

- **Game dan Parser**: `Game` bergantung pada `Parser` untuk menerima input perintah dari pemain. Ini adalah hubungan yang wajar, karena `Game` membutuhkan parser untuk melanjutkan alur permainan berdasarkan input pemain.

- **Kelas-Kelas Lainnya**: Secara keseluruhan, tingkat kopling antar kelas dalam implementasi ini relatif rendah dan dijaga minimal, hanya ada ketergantungan yang wajar di antara kelas-kelas yang perlu berkomunikasi.

### 3. **Desain Umum**
- **Encapsulation (Enkapsulasi)**: Setiap kelas menyembunyikan detail internal dan hanya mengekspos hal-hal yang diperlukan melalui metode publik seperti `getCommandWord()` dan `getDescription()`. Ini membuat implementasi fleksibel dan lebih mudah untuk diubah tanpa mempengaruhi bagian lain dari sistem.
  
- **Single Responsibility Principle (SRP)**: Sebagian besar kelas mematuhi SRP, di mana setiap kelas memiliki tanggung jawab tunggal. Misalnya, kelas `Room` hanya mengelola informasi ruangan, dan `Parser` hanya fokus pada parsing input.

- **Expandability**: Kode ini mudah untuk diperluas. Misalnya, jika ingin menambahkan lebih banyak perintah, cukup tambahkan di `CommandWords` dan buat logika baru di `Game`. Kode ini dirancang cukup modular sehingga perubahan pada satu bagian tidak mengganggu bagian lain.

### 4. **Potential Improvements**
- **Kopling antara kelas `Game` dan `Room`**: Saat ini, kelas `Game` memiliki logika untuk menampilkan deskripsi ruangan dan arah keluar. Jika ingin meningkatkan modularitas, mungkin bisa menambahkan metode di `Room` untuk menampilkan informasi ini, sehingga tanggung jawab menampilkan informasi ruangan sepenuhnya berada di kelas `Room`.

- **Open-Closed Principle (OCP)**: Prinsip ini mengatakan bahwa kelas harus terbuka untuk ekstensi tetapi tertutup untuk modifikasi. Saat ini, jika ingin menambah fitur (misalnya perintah baru), perlu memodifikasi beberapa kelas (seperti `CommandWords`, `Game`). Untuk meningkatkan kepatuhan terhadap OCP, bisa dipertimbangkan untuk menggunakan pola desain seperti `Command Pattern`, di mana setiap perintah adalah objek terpisah yang bisa ditambahkan tanpa mengubah logika inti.
