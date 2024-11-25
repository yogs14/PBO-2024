Abstract Class "Makhluk Hidup"
---

### Penjelasan:

1. **Abstract Class `MakhlukHidup`**:
    - **Deklarasi Abstract Class**: `abstract class MakhlukHidup` mendefinisikan sebuah abstract class yang tidak bisa diinstansiasi secara langsung.
    - **Metode Abstract `bernafas()`**: Metode ini dideklarasikan tanpa implementasi. Setiap subclass harus mengimplementasikan metode ini sesuai dengan cara bernafas masing-masing.
    - **Metode Konkret `makan()`**: Metode ini memiliki implementasi yang sama untuk semua subclass. Semua makhluk hidup makan, jadi kita bisa memberikan implementasi umum di abstract class.

2. **Subclass `Manusia`**:
    - **Mengoverride Metode `bernafas()`**: `Manusia` mengimplementasikan metode `bernafas()` dengan cara yang spesifik, yaitu bernafas dengan paru-paru.

3. **Subclass `Hewan`**:
    - **Mengoverride Metode `bernafas()`**: `Hewan` mengimplementasikan metode `bernafas()` dengan cara yang berbeda, yaitu bisa bernafas dengan paru-paru atau insang, tergantung jenis hewannya.

4. **Subclass `Tumbuhan`**:
    - **Mengoverride Metode `bernafas()`**: `Tumbuhan` mengimplementasikan metode `bernafas()` dengan cara bernafas melalui stomata.

5. **Main Class untuk Menjalankan Program**:
    - **Instansiasi Objek**: Membuat objek dari subclass `Manusia`, `Hewan`, dan `Tumbuhan`.
    - **Pemanggilan Metode**: Memanggil metode `bernafas()` dan `makan()` pada setiap objek untuk menunjukkan bagaimana masing-masing subclass mengimplementasikan metode `bernafas()` dan menggunakan metode `makan()` yang diwariskan.

### Contoh Kode

```java
// Abstract class MakhlukHidup
abstract class MakhlukHidup {
    // Abstract method
    abstract void bernafas();
    
    // Concrete method
    void makan() {
        System.out.println("Makhluk hidup sedang makan.");
    }
}

// Subclass Manusia
class Manusia extends MakhlukHidup {
    @Override
    void bernafas() {
        System.out.println("Manusia bernafas dengan paru-paru.");
    }
}

// Subclass Hewan
class Hewan extends MakhlukHidup {
    @Override
    void bernafas() {
        System.out.println("Hewan bernafas dengan paru-paru atau insang.");
    }
}

// Subclass Tumbuhan
class Tumbuhan extends MakhlukHidup {
    @Override
    void bernafas() {
        System.out.println("Tumbuhan bernafas melalui stomata.");
    }
}

// Main class untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        MakhlukHidup manusia = new Manusia();
        MakhlukHidup hewan = new Hewan();
        MakhlukHidup tumbuhan = new Tumbuhan();
        
        manusia.bernafas();
        manusia.makan();
        
        hewan.bernafas();
        hewan.makan();
        
        tumbuhan.bernafas();
        tumbuhan.makan();
    }
}
```
---


Simulation of Fox and Rabbit
---

### **1. Hierarki Hewan: Animal, Fox, Rabbit**
#### **Konsep Abstraksi**:
- **`Animal`** adalah kelas abstrak yang menjadi kerangka dasar untuk semua jenis hewan.
  - **Atribut Umum**: `alive`, `field`, `location` — atribut ini merepresentasikan status hidup, lokasi, dan lingkungan hewan.
  - **Metode Abstrak**: `act(List<Animal> newAnimals)` — menyediakan kerangka perilaku tanpa detail spesifik.
- **`Fox`** dan **`Rabbit`** mengimplementasikan detail dari metode `act()` sesuai dengan perilaku masing-masing:
  - `Fox` mungkin memiliki logika berburu (interaksi dengan `Rabbit`).
  - `Rabbit` fokus pada reproduksi atau menghindari predator.

#### **Hubungan Antar File**:
- **Animal** adalah kelas induk, dan **Fox** serta **Rabbit** adalah subclass yang memperluas perilaku abstrak menjadi implementasi konkret.
- Abstraksi ini memungkinkan penambahan jenis hewan baru di masa depan tanpa mengubah kode inti simulasi.

---

### **2. Lokasi dan Lapangan: Field, Location**
#### **Konsep Abstraksi**:
- **`Field`**:
  - Merepresentasikan lapangan simulasi dalam bentuk grid 2D.
  - Berfungsi sebagai abstraksi ruang yang menyimpan posisi setiap objek di simulasi.
- **`Location`**:
  - Mewakili titik tertentu dalam grid (koordinat x, y).
  - Hanya menyimpan detail sederhana seperti posisi, tanpa memperdulikan apa yang berada di lokasi tersebut.

#### **Hubungan Antar File**:
- `Field` mengandalkan `Location` untuk merepresentasikan posisi objek, dan `Field` digunakan oleh `Animal` (melalui atribut `field` dan `location`).
- Dengan memisahkan konsep lokasi (`Location`) dan ruang keseluruhan (`Field`), abstraksi ini menjaga fleksibilitas untuk mengubah representasi spasial tanpa memengaruhi implementasi logika hewan.

---

### **3. Simulator dan SimulatorView**
#### **Konsep Abstraksi**:
- **`Simulator`**:
  - Mengabstraksi logika inti simulasi: iterasi waktu, pemanggilan metode `act()` untuk semua hewan, dan pembaruan status lapangan.
  - Tidak memuat detail implementasi entitas individu, seperti bagaimana rubah berburu atau kelinci berkembang biak.
- **`SimulatorView`**:
  - Mengabstraksi antarmuka visual dari logika simulasi.
  - Tidak mempedulikan bagaimana simulasi bekerja di belakang layar, hanya fokus pada representasi lapangan (visualisasi grid).

#### **Hubungan Antar File**:
- `Simulator` menggunakan `Field` untuk mengelola entitas dan berkomunikasi dengan `SimulatorView` untuk menampilkan status lapangan.
- Pemisahan logika simulasi (`Simulator`) dan tampilan visual (`SimulatorView`) memastikan modularitas: perubahan di salah satu bagian tidak memengaruhi yang lain.

---

### **4. Statistik dan Pengacakan: FieldStats, Counter, Randomizer**
#### **Konsep Abstraksi**:
- **`FieldStats`**:
  - Mengelola statistik lapangan, seperti jumlah rubah atau kelinci.
  - Mengabstraksi penghitungan entitas di lapangan tanpa memedulikan detil entitas itu sendiri.
- **`Counter`**:
  - Berfungsi sebagai alat bantu untuk `FieldStats`, mengabstraksi logika penghitungan jumlah entitas tertentu.
- **`Randomizer`**:
  - Mengabstraksi proses pengacakan, seperti menentukan apakah hewan akan bergerak, bereproduksi, atau mati.

#### **Hubungan Antar File**:
- `FieldStats` dan `Counter` digunakan oleh `Simulator` untuk memberikan laporan statistik selama simulasi.
- `Randomizer` digunakan oleh hewan (melalui `Animal`) atau `Simulator` untuk perilaku yang tidak terduga.

---

### **5. Hubungan Keseluruhan Antar Kelas**
#### **Konsep Abstraksi Utama dalam Proyek**:
1. **Pemecahan Kompleksitas**:
   - **`Animal`**: Mengabstraksi karakteristik dasar hewan.
   - **`Field`**: Mengabstraksi ruang simulasi.
   - **`Simulator`**: Mengelola iterasi waktu dan eksekusi perilaku.
   - **`SimulatorView`**: Mengabstraksi cara data ditampilkan.

2. **Fleksibilitas dan Ekstensibilitas**:
   - Penambahan jenis hewan (subclass `Animal`) atau perubahan logika lapangan (`Field`) dapat dilakukan tanpa mengubah komponen lain.

3. **Pemisahan Tanggung Jawab**:
   - Setiap kelas hanya fokus pada tugas tertentu:
     - `Animal` fokus pada perilaku individu.
     - `Simulator` fokus pada alur simulasi.
     - `FieldStats` fokus pada data statistik.

---

### **Diagram Abstraksi (Secara Konseptual)**:


![TLDDRuCm3BqZyHzyf6By0LHLhIRrD6tIAkrIzH30wpA5f4jCsttzzmL26kWebs0xxzb-TfQ6cAQc5d742aEQbGIbOCR0IlAQ2VYE8x1V1apm8-PGA2MGIUzzvIYg7DRjuNr2bOouaZayz7ykae9bJoIU](https://github.com/user-attachments/assets/0e320d0c-9a30-44ea-ab9b-a335df3ed60e)


---
