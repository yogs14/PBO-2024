# Implementasi Studi Kasus ClockDisplay


Kode di atas mengimplementasikan beberapa konsep utama dalam **Object-Oriented Programming (OOP)**, yaitu **Encapsulation, Inheritance, Polymorphism,** dan **Abstraction**. Berikut penjelasan masing-masing konsep dan bagaimana diimplementasikan dalam kode tersebut:

### 1. **Encapsulation**
   Encapsulation adalah konsep OOP di mana data (atribut) dan metode (fungsi) yang mengoperasikannya dibungkus ke dalam satu unit, yaitu kelas. Tujuannya adalah untuk melindungi data agar tidak diakses langsung dari luar kelas, melainkan melalui metode yang telah disediakan.

   - **Kelas `ClockDisplay` dan `NumberDisplay`:** Keduanya mengenkapsulasi atribut-atribut seperti `hours`, `minutes`, `limit`, dan `value` sehingga hanya bisa dimanipulasi melalui metode getter dan setter.
   - Atribut `value` di `NumberDisplay` dienkapsulasi, sehingga akses dilakukan melalui metode `setValue()` dan `getValue()`.

   ```java
   public class NumberDisplay {
       private int limit;
       private int value;

       public int getValue() {
           return value;
       }

       public void setValue(int replacementValue) {
           if (replacementValue >= 0 && replacementValue < limit) {
               value = replacementValue;
           }
       }
   }
   ```

   - Pada kelas `ClockDisplay`, nilai `hours` dan `minutes` juga dikapsulasi dalam objek `NumberDisplay` dan manipulasi waktunya dilakukan melalui metode seperti `setTime()` dan `timeTick()`.

   ```java
   public class ClockDisplay {
       private NumberDisplay hours;
       private NumberDisplay minutes;

       public void setTime(int hour, int minute) {
           hours.setValue(hour);
           minutes.setValue(minute);
       }
   }
   ```

### 2. **Inheritance**
   Inheritance memungkinkan sebuah kelas untuk mewarisi atribut dan metode dari kelas lain. Pada kode ini, meskipun tidak ada explicit inheritance dari kelas user-defined lain, kelas `ClockDisplay` mewarisi dari kelas `JFrame` yang merupakan bagian dari Java Swing. Ini menunjukkan bahwa **ClockDisplay adalah sebuah JFrame**, sehingga dapat memanfaatkan semua metode dan properti dari JFrame, seperti `setTitle()`, `setSize()`, dan `setVisible()`.

   ```java
   public class ClockDisplay extends JFrame {
       public ClockDisplay() {
           // Memanfaatkan metode dan properti dari JFrame
           setTitle("Digital Clock");
           setSize(400, 200);
       }
   }
   ```

### 3. **Polymorphism**
   Polymorphism dalam OOP memungkinkan suatu metode atau objek memiliki banyak bentuk. Polymorphism dibagi menjadi dua jenis: compile-time dan runtime.

   - **Compile-time Polymorphism (Method Overloading):** Tidak ada overloading pada kode ini, namun kita bisa menambahkannya jika ingin memiliki beberapa varian metode dengan nama yang sama.
   - **Runtime Polymorphism:** Ini diimplementasikan saat kelas `ClockDisplay` mewarisi `JFrame`. Polymorphism terjadi ketika objek `ClockDisplay` diperlakukan sebagai objek dari kelas induknya (`JFrame`), memungkinkan metode seperti `setSize()` untuk digunakan, meskipun ini sebenarnya merupakan bagian dari `JFrame`.

### 4. **Abstraction**
   Abstraksi adalah proses menyembunyikan detail implementasi dan hanya menampilkan fungsionalitas esensial. Pada kode ini, abstraksi dilakukan dengan menyembunyikan logika perhitungan waktu dan bagaimana increment dilakukan pada jam dan menit melalui kelas `NumberDisplay`. Dengan begitu, pengguna kelas `ClockDisplay` tidak perlu mengetahui detail implementasi dari bagaimana waktu berubah.

   ```java
   public class NumberDisplay {
       private int limit;
       private int value;

       public void increment() {
           value = (value + 1) % limit;
       }
   }
   ```

   Kelas `ClockDisplay` hanya menggunakan fungsi `increment()` tanpa perlu tahu bagaimana angka tersebut di-increment di dalam kelas `NumberDisplay`.
