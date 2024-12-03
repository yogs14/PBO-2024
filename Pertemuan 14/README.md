Berikut adalah penjelasan mengenai implementasi aplikasi **Image Viewer** di atas:

---

### **Konsep OOP yang Digunakan**

#### 1. **Encapsulation**
   - **Definisi**: Encapsulation adalah proses membungkus data dan metode yang bekerja pada data tersebut dalam satu unit (class). Dengan encapsulation, akses ke data dibatasi melalui method tertentu.
   - **Penerapan dalam Kode**:
     - Semua atribut (`imageLabel`, `loadButton`) dan metode tambahan (`loadImage`) dibungkus dalam class `ImageViewer`. Ini mencegah akses langsung ke atribut tersebut dari luar kelas.
     - Akses ke atribut dilakukan secara **internal**, melalui konstruktor atau listener, tanpa memaparkan atribut secara langsung.

     ```java
     private JLabel imageLabel;
     private JButton loadButton;
     ```
   - **Manfaat**:
     - Data dan fungsi terorganisir dalam satu unit.
     - Mengurangi risiko modifikasi yang tidak disengaja dari luar.

---

#### 2. **Abstraction**
   - **Definisi**: Abstraction adalah proses menyembunyikan detail implementasi dan hanya memaparkan fungsionalitas inti kepada pengguna.
   - **Penerapan dalam Kode**:
     - Pengguna aplikasi hanya berinteraksi dengan tombol "Load Image" tanpa perlu mengetahui detail implementasi metode `loadImage`.
     - Detail teknis seperti penggunaan `JFileChooser`, konversi gambar, dan pengaturan ikon tidak terlihat oleh pengguna.

     ```java
     loadButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             loadImage();
         }
     });
     ```
   - **Manfaat**:
     - Mengurangi kompleksitas aplikasi.
     - Memisahkan antarmuka pengguna (UI) dengan detail implementasi.

---

#### 3. **Inheritance**
   - **Definisi**: Inheritance memungkinkan sebuah class mewarisi atribut dan metode dari class lain.
   - **Penerapan dalam Kode**:
     - Class `ImageViewer` mewarisi sifat dari `JFrame`:
       ```java
       public class ImageViewer extends JFrame
       ```
     - Dengan inheritance ini, `ImageViewer` secara otomatis memiliki kemampuan untuk bertindak sebagai jendela utama GUI, seperti:
       - Mengatur tata letak (`setLayout`).
       - Menentukan ukuran (`setSize`).
       - Mengatur operasi tutup jendela (`setDefaultCloseOperation`).
   - **Manfaat**:
     - Menghindari pengulangan kode (reusability).
     - Memperluas fitur kelas induk (`JFrame`) tanpa memodifikasinya langsung.

---

#### 4. **Polymorphism**
   - **Definisi**: Polymorphism memungkinkan metode atau aksi tertentu untuk memiliki bentuk yang berbeda, tergantung pada objek yang digunakan.
   - **Penerapan dalam Kode**:
     - **Polymorphism melalui Interface**: `ActionListener` adalah interface yang diimplementasikan oleh objek **Anonymous Inner Class** untuk mendefinisikan perilaku klik tombol.
       ```java
       loadButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               loadImage();
           }
       });
       ```
     - Implementasi metode `actionPerformed` menunjukkan polymorphism, karena kode dapat menggunakan berbagai listener untuk tombol yang berbeda tanpa mengubah struktur dasar aplikasi.
   - **Manfaat**:
     - Mempermudah penyesuaian fungsionalitas.
     - Meningkatkan fleksibilitas kode.

---

### **Analisis Class**

#### **Class `ImageViewer`**
   - **Tujuan**: Berfungsi sebagai kerangka utama aplikasi Image Viewer.
   - **Atribut**:
     - `imageLabel`: Digunakan untuk menampilkan gambar.
     - `loadButton`: Digunakan untuk memicu aksi memuat gambar.
   - **Metode**:
     - `loadImage`: Berisi logika untuk memilih dan menampilkan gambar dari sistem file.

---

### **Konsep Desain OOP**

1. **High Cohesion**:
   - Semua atribut dan metode dalam `ImageViewer` memiliki tanggung jawab yang erat kaitannya, yaitu untuk memuat dan menampilkan gambar.
   - Cohesion yang tinggi meningkatkan kejelasan dan kemudahan perawatan kode.

2. **Low Coupling**:
   - Kelas ini memiliki dependensi minimal terhadap kelas lain. 
   - Komponen seperti `JFileChooser` atau `ImageIcon` digunakan sebagai komponen mandiri dan tidak memiliki hubungan langsung satu sama lain di luar metode `loadImage`.

3. **Reusability**:
   - Class `ImageViewer` dapat diperluas untuk menambahkan fitur baru tanpa memodifikasi kode yang ada, berkat konsep inheritance dan encapsulation.

---
