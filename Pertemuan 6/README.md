# **Tech Support System**

Tech Support System yang diimplementasikan dalam program ini adalah sebuah sistem percakapan otomatis yang dapat memberikan respons berdasarkan input dari pengguna. Sistem ini bekerja dengan mencocokkan kata kunci tertentu dari input pengguna dan memberikan tanggapan yang relevan. Prinsip ini terinspirasi dari proyek ELIZA dari MIT, yang dirancang untuk meniru percakapan antara terapis dan pasien, namun kali ini disesuaikan untuk memberikan dukungan teknis.

Dalam sistem ini, kita menggunakan **`HashMap`** sebagai struktur data utama untuk menyimpan **pasangan kata kunci dan respons**. Sistem membaca input dari pengguna, mencari kata kunci yang relevan, dan mengeluarkan jawaban sesuai dengan kata kunci tersebut. Jika tidak ada kata kunci yang cocok, sistem akan memberikan jawaban default.

### **Konsep Utama:**

1. **Input Pengguna**: 
   Pengguna memasukkan pertanyaan atau permasalahan mereka dalam bentuk teks. Input ini kemudian diubah menjadi huruf kecil untuk memudahkan pencarian kata kunci tanpa memperhatikan besar kecil huruf (case-insensitive).

2. **Cocokan Kata Kunci (Keyword Matching)**: 
   Sistem menggunakan kata kunci seperti "network", "error", "slow", "crash", dan "internet". Kata-kata ini akan digunakan untuk mendeteksi masalah yang dilaporkan oleh pengguna. Jika salah satu dari kata kunci ini ada dalam input pengguna, sistem akan mengeluarkan respons yang telah disediakan.

3. **HashMap**: 
   **`HashMap`** digunakan untuk menyimpan pasangan **kata kunci dan respons** dalam bentuk:
   
   ```java
   Map<String, String> responseMap = new HashMap<>();
   ```
   Di mana, kata kunci seperti "network" adalah kunci (`key`) dan tanggapannya adalah nilai (`value`), misalnya: "It seems you are having network issues...".

4. **Respons Default**: 
   Jika tidak ada kata kunci yang cocok dalam input pengguna, sistem akan memberikan respons default: "I'm sorry, I didn't understand that. Could you please elaborate on the issue?"

5. **Keluar dari Sistem**: 
   Sistem ini memiliki mekanisme keluar yang sederhana. Jika pengguna mengetikkan "exit" atau "quit", maka sistem akan mengakhiri percakapan.

### **Pendeskripsian Konsep Library yang Digunakan:**

Dalam implementasi ini, beberapa kelas dan fungsi dari **Java Standard Library** digunakan untuk mempermudah pembuatan sistem ini:

1. **`HashMap` (java.util.HashMap)**:
   - **Deskripsi**: `HashMap` adalah bagian dari **Java Collections Framework** yang digunakan untuk menyimpan pasangan kunci-nilai (`key-value pairs`). Struktur data ini memungkinkan pencarian data yang cepat dengan kompleksitas rata-rata O(1).
   - **Kegunaan di Sistem**: Di sini, `HashMap` digunakan untuk menyimpan kata kunci sebagai kunci (`key`) dan respons sebagai nilai (`value`). Penggunaan `HashMap` memungkinkan kita mencari respons yang relevan dengan cepat berdasarkan kata kunci yang ditemukan dalam input pengguna.
   
   **Contoh Penggunaan**:
   ```java
   Map<String, String> responseMap = new HashMap<>();
   responseMap.put("network", "It seems you are having network issues. Have you tried restarting your router?");
   ```

2. **`Scanner` (java.util.Scanner)**:
   - **Deskripsi**: `Scanner` adalah class di Java yang digunakan untuk membaca input dari berbagai sumber, seperti input dari konsol atau file.
   - **Kegunaan di Sistem**: Dalam sistem ini, `Scanner` digunakan untuk membaca input dari pengguna melalui konsol. Setiap input dari pengguna akan diproses dalam bentuk string, kemudian dicocokkan dengan kata kunci.
   
   **Contoh Penggunaan**:
   ```java
   Scanner scanner = new Scanner(System.in);
   String input = scanner.nextLine();
   ```

3. **`Map` Interface (java.util.Map)**:
   - **Deskripsi**: `Map` adalah interface di Java yang mendefinisikan operasi dasar untuk menyimpan dan mengakses data dalam bentuk pasangan kunci-nilai. `HashMap` adalah salah satu implementasi dari `Map`.
   - **Kegunaan di Sistem**: Sistem ini menggunakan interface `Map` untuk mendefinisikan koleksi data kata kunci-respons, yang kemudian diimplementasikan dengan `HashMap` untuk efisiensi.

   **Contoh Penggunaan**:
   ```java
   Map<String, String> responseMap = new HashMap<>();
   ```

4. **`System` (java.lang.System)**:
   - **Deskripsi**: `System` adalah class yang memberikan akses ke berbagai elemen dasar dalam Java, seperti input/output standar dan operasi exit.
   - **Kegunaan di Sistem**: Sistem ini menggunakan `System.out.println` untuk menampilkan pesan kepada pengguna dan `System.exit(0)` untuk keluar dari program saat pengguna mengetikkan "quit" atau "exit".

   **Contoh Penggunaan**:
   ```java
   System.out.println("Thank you for contacting tech support. Have a nice day!");
   ```
