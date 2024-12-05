# **Konsep Debugging dengan JUnit**

**1. Pengenalan Debugging dengan JUnit**
JUnit adalah framework pengujian unit yang memungkinkan pengembang Java untuk membuat dan menjalankan pengujian otomatis. Debugging menggunakan JUnit melibatkan eksekusi berbagai metode pengujian untuk memastikan bahwa setiap unit dari kode (misalnya, metode atau kelas) bekerja sesuai spesifikasi. Dengan JUnit, Anda dapat mendeteksi kesalahan atau bug lebih awal dalam siklus pengembangan perangkat lunak.

**2. Konsep dari File yang Diberikan**
File yang diberikan mencakup:
- **`Comment.java`**: Mengelola komentar terkait item penjualan, termasuk fitur seperti memberikan rating, upvote, dan downvote.
- **`SalesItem.java`**: Merepresentasikan barang dagangan, termasuk pengelolaan daftar komentar pelanggan.
- **`SalesItemTest.java`**: Berisi pengujian unit yang memvalidasi berbagai fitur di kelas `SalesItem`.

**3. Metodologi Pengujian dengan JUnit**
Metode pengujian di **`SalesItemTest.java`** menunjukkan bagaimana JUnit digunakan untuk memverifikasi perilaku kode:
- **Pengujian Fungsionalitas Tambah Komentar**: Memastikan bahwa komentar dapat ditambahkan ke item penjualan, dan jumlah komentar meningkat sesuai ekspektasi.
- **Pengujian Validasi Rating**: Memastikan rating yang tidak valid ditolak dengan benar.
- **Pengujian Inisialisasi Objek**: Memastikan bahwa nama dan harga item ditetapkan dengan benar saat objek diinisialisasi.

**4. Proses Debugging**
Saat pengujian JUnit dijalankan, debugging dilakukan untuk mengidentifikasi kegagalan atau anomali dalam kode:
- **Langkah-Langkah Debugging**:
  1. **Tulis Metode Pengujian**: Tentukan input dan output yang diharapkan.
  2. **Jalankan Pengujian**: Gunakan JUnit untuk menjalankan metode pengujian.
  3. **Analisis Kegagalan**: Jika pengujian gagal, periksa pesan kesalahan dan gunakan debugger IDE untuk menelusuri logika program.
  4. **Perbaikan Kode**: Temukan dan perbaiki bug yang menyebabkan kegagalan.
  5. **Ulangi Pengujian**: Jalankan kembali pengujian untuk memastikan perbaikan berhasil.

**5. Contoh Debugging**
Di metode `testIllegalRating`, JUnit memvalidasi bahwa rating tidak valid (misalnya, -5) ditolak oleh metode `addComment`. Jika implementasi metode `addComment` salah dan menerima rating ini, pengujian akan gagal, menunjukkan bug yang harus diperbaiki.

```java
@Test
public void testIllegalRating() {
    SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
    assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
}
```

Ketika pengujian dijalankan, JUnit akan membandingkan hasil aktual dengan hasil yang diharapkan:
- Jika hasil aktual `false`, pengujian lulus.
- Jika tidak, pengujian gagal, dan pengembang dapat men-debug metode `addComment` untuk memahami penyebabnya.
