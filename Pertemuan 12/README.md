# Implementasi Sistem Reservasi Tiket Pesawat

### 1. Definisi Kelas Dasar `Ticket`
```java
abstract class Ticket {
    protected double baseFare;

    public Ticket(double baseFare) {
        this.baseFare = baseFare;
    }

    public abstract double calculateFare();
}
```
- **Deskripsi**:
  - **Kelas Abstrak**: `Ticket` adalah kelas abstrak, yang berarti tidak dapat diinstansiasi secara langsung. Kelas ini hanya berfungsi sebagai template untuk subclass.
  - **Atribut**: `baseFare` adalah atribut yang menyimpan tarif dasar tiket. Ini adalah nilai yang akan digunakan sebagai dasar perhitungan tarif akhir.
  - **Konstruktor**: Konstruktor `Ticket(double baseFare)` digunakan untuk menginisialisasi atribut `baseFare` saat objek dibuat.
  - **Metode Abstrak**: `calculateFare()` adalah metode abstrak yang harus diimplementasikan oleh setiap subclass. Ini memaksa setiap subclass untuk menyediakan logika spesifik mereka sendiri untuk menghitung tarif.

### 2. Definisi Subclass `EconomyTicket`
```java
class EconomyTicket extends Ticket {
    public EconomyTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 0.9; // 10% discount
    }
}
```
- **Deskripsi**:
  - **Inheritance**: `EconomyTicket` mewarisi dari `Ticket`, yang berarti ia mendapatkan semua atribut dan metode dari `Ticket`.
  - **Konstruktor**: Konstruktor `EconomyTicket(double baseFare)` memanggil konstruktor superclass (`super(baseFare)`) untuk menginisialisasi `baseFare`.
  - **Overriding**: Metode `calculateFare()` di-override untuk memberikan diskon 10% pada tarif dasar. Ini menunjukkan bagaimana subclass dapat menyesuaikan perilaku metode yang diwarisi dari superclass.

### 3. Definisi Subclass `BusinessTicket`
```java
class BusinessTicket extends Ticket {
    public BusinessTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.25; // 25% additional charge
    }
}
```
- **Deskripsi**:
  - **Inheritance**: `BusinessTicket` juga mewarisi dari `Ticket`.
  - **Konstruktor**: Konstruktor `BusinessTicket(double baseFare)` memanggil konstruktor superclass untuk menginisialisasi `baseFare`.
  - **Overriding**: Metode `calculateFare()` di-override untuk menambahkan biaya 25% pada tarif dasar. Ini menunjukkan bagaimana subclass dapat memperluas perilaku metode yang diwarisi.

### 4. Definisi Subclass `FirstClassTicket`
```java
class FirstClassTicket extends Ticket {
    public FirstClassTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.5; // 50% additional charge
    }
}
```
- **Deskripsi**:
  - **Inheritance**: `FirstClassTicket` mewarisi dari `Ticket`.
  - **Konstruktor**: Konstruktor `FirstClassTicket(double baseFare)` memanggil konstruktor superclass untuk menginisialisasi `baseFare`.
  - **Overriding**: Metode `calculateFare()` di-override untuk menambahkan biaya 50% pada tarif dasar. Ini menunjukkan bagaimana subclass dapat menyesuaikan dan memperluas perilaku metode yang diwarisi.

### 5. Penggunaan Polimorfisme dalam `TicketReservationSystem`
```java
public class TicketReservationSystem {
    public static void main(String[] args) {
        Ticket economyTicket = new EconomyTicket(1000);
        Ticket businessTicket = new BusinessTicket(1000);
        Ticket firstClassTicket = new FirstClassTicket(1000);

        System.out.println("Economy Ticket Fare: " + economyTicket.calculateFare());
        System.out.println("Business Ticket Fare: " + businessTicket.calculateFare());
        System.out.println("First Class Ticket Fare: " + firstClassTicket.calculateFare());
    }
}
```
- **Deskripsi**:
  - **Inisialisasi Objek**: Objek `EconomyTicket`, `BusinessTicket`, dan `FirstClassTicket` dibuat dengan tarif dasar 1000.
  - **Polimorfisme**: Variabel `Ticket` digunakan untuk menyimpan referensi ke objek dari subclass yang berbeda. Ini menunjukkan penggunaan polimorfisme, di mana objek dari subclass dapat diperlakukan sebagai objek dari superclass.
  - **Pemanggilan Metode**: Ketika `calculateFare()` dipanggil pada setiap objek, metode yang sesuai dari subclass yang relevan akan dieksekusi. Ini menunjukkan bagaimana overriding bekerja dalam konteks polimorfisme.
  - **Output**: Tarif yang dihitung untuk setiap jenis tiket ditampilkan di konsol.

### Alur Eksekusi Kode
1. **Inisialisasi Objek**:
   - Objek `EconomyTicket`, `BusinessTicket`, dan `FirstClassTicket` dibuat dengan tarif dasar 1000.
   - Konstruktor dari masing-masing subclass memanggil konstruktor superclass untuk menginisialisasi `baseFare`.

2. **Polimorfisme**:
   - Variabel `Ticket` digunakan untuk menyimpan referensi ke objek dari subclass yang berbeda (`EconomyTicket`, `BusinessTicket`, `FirstClassTicket`).
   - Ini memungkinkan kita untuk menggunakan metode `calculateFare()` pada objek `Ticket` tanpa mengetahui subclass spesifiknya.

3. **Overriding**:
   - Ketika `calculateFare()` dipanggil pada objek `economyTicket`, `businessTicket`, dan `firstClassTicket`, metode yang di-override di masing-masing subclass akan dieksekusi.
   - `EconomyTicket` memberikan diskon 10%, `BusinessTicket` menambahkan biaya 25%, dan `FirstClassTicket` menambahkan biaya 50%.

4. **Output**:
   - Hasil perhitungan tarif untuk setiap jenis tiket ditampilkan di konsol:
     ```plaintext
     Economy Ticket Fare: 900.0
     Business Ticket Fare: 1250.0
     First Class Ticket Fare: 1500.0
     ```
