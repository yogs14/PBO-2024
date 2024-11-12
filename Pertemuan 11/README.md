# Aplikasi Rental Kendaraan

### 1. Kelas Dasar `Vehicle`
Kelas `Vehicle` adalah kelas abstrak yang mewakili kendaraan umum. Kelas ini berisi atribut dasar yang dimiliki oleh semua kendaraan, yaitu `brand` (merk), `model`, dan `productionYear` (tahun produksi). Kelas ini juga memiliki metode abstrak `getDetail()` yang nantinya akan diimplementasikan oleh kelas turunannya.

```java
abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int productionYear;

    public Vehicle(String brand, String model, int productionYear) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
    }

    public abstract String getDetail();
}
```

**Penjelasan:**
- `Vehicle` adalah kelas abstrak yang tidak dapat dibuat objek langsungnya.
- Atribut `brand`, `model`, dan `productionYear` digunakan untuk menyimpan data kendaraan.
- Metode `getDetail()` akan memberikan detail tentang kendaraan yang akan diimplementasikan pada setiap jenis kendaraan (misalnya Mobil, Motor, atau Sepeda).

### 2. Kelas `Car` (Subclass dari `Vehicle`)
Kelas `Car` adalah turunan dari `Vehicle` dan menambahkan atribut `numberOfWheels` (jumlah roda). Kelas ini juga mengimplementasikan metode `getDetail()` yang memberikan detail spesifik tentang mobil.

```java
class Car extends Vehicle {
    private int numberOfWheels;

    public Car(String brand, String model, int productionYear, int numberOfWheels) {
        super(brand, model, productionYear);
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String getDetail() {
        return "Car - Brand: " + brand + ", Model: " + model + ", Year: " + productionYear + ", Wheels: " + numberOfWheels;
    }
}
```

**Penjelasan:**
- `Car` menggunakan keyword `extends` untuk mewarisi dari kelas `Vehicle`.
- `numberOfWheels` menambahkan informasi khusus tentang mobil.
- Metode `getDetail()` ditimpa (override) untuk memberikan informasi tentang merk, model, tahun produksi, dan jumlah roda mobil.

### 3. Kelas `Motorcycle` (Subclass dari `Vehicle`)
Kelas `Motorcycle` mirip dengan `Car`, tetapi digunakan untuk objek motor. Kelas ini juga memiliki atribut `numberOfWheels` dan metode `getDetail()` yang diimplementasikan secara spesifik untuk motor.

```java
class Motorcycle extends Vehicle {
    private int numberOfWheels;

    public Motorcycle(String brand, String model, int productionYear, int numberOfWheels) {
        super(brand, model, productionYear);
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String getDetail() {
        return "Motorcycle - Brand: " + brand + ", Model: " + model + ", Year: " + productionYear + ", Wheels: " + numberOfWheels;
    }
}
```

**Penjelasan:**
- `Motorcycle` juga merupakan subclass dari `Vehicle` dan memiliki atribut `numberOfWheels`.
- Metode `getDetail()` memberikan informasi detail tentang motor yang disesuaikan.

### 4. Kelas `Bicycle` (Subclass dari `Vehicle`)
Kelas `Bicycle` memiliki atribut tambahan `bicycleType` untuk jenis sepeda. Kelas ini juga mengimplementasikan metode `getDetail()` secara spesifik untuk sepeda.

```java
class Bicycle extends Vehicle {
    private String bicycleType;

    public Bicycle(String brand, String model, int productionYear, String bicycleType) {
        super(brand, model, productionYear);
        this.bicycleType = bicycleType;
    }

    @Override
    public String getDetail() {
        return "Bicycle - Brand: " + brand + ", Model: " + model + ", Year: " + productionYear + ", Type: " + bicycleType;
    }
}
```

**Penjelasan:**
- `Bicycle` adalah turunan dari `Vehicle` dengan atribut `bicycleType` yang digunakan untuk menyimpan jenis sepeda (misalnya BMX, balap).
- Metode `getDetail()` menampilkan informasi lengkap tentang sepeda.

### 5. Kelas `Rental` untuk Manajemen Penyewaan
Kelas `Rental` digunakan untuk mengelola daftar kendaraan yang tersedia dan daftar penyewa. Kelas ini memiliki beberapa metode untuk menambah kendaraan, menyewa kendaraan, dan menampilkan daftar kendaraan atau penyewa.

```java
class Rental {
    private List<Vehicle> availableVehicles = new ArrayList<>();
    private Map<String, Vehicle> rentals = new HashMap<>();

    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
    }

    public void rentVehicle(String renterName, Vehicle vehicle) {
        if (availableVehicles.contains(vehicle)) {
            availableVehicles.remove(vehicle);
            rentals.put(renterName, vehicle);
            System.out.println(renterName + " has rented " + vehicle.getDetail());
        } else {
            System.out.println("Vehicle is not available.");
        }
    }

    public void displayAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : availableVehicles) {
            System.out.println(vehicle.getDetail());
        }
    }

    public void displayRenters() {
        System.out.println("List of Renters:");
        for (Map.Entry<String, Vehicle> entry : rentals.entrySet()) {
            System.out.println("Renter Name: " + entry.getKey() + ", Vehicle Details: " + entry.getValue().getDetail());
        }
    }
}
```

**Penjelasan:**
- `availableVehicles` adalah daftar kendaraan yang tersedia untuk disewa.
- `rentals` adalah peta (map) yang menyimpan pasangan nama penyewa dengan kendaraan yang disewa.
- `addVehicle()` menambahkan kendaraan ke daftar kendaraan yang tersedia.
- `rentVehicle()` melakukan proses penyewaan dengan memindahkan kendaraan dari daftar `availableVehicles` ke `rentals`.
- `displayAvailableVehicles()` menampilkan daftar kendaraan yang tersedia untuk disewa.
- `displayRenters()` menampilkan daftar penyewa dan detail kendaraan yang disewa.

### 6. Kelas `VehicleRentalApplication` (Main Class)
Kelas ini adalah titik awal aplikasi, berfungsi untuk menjalankan simulasi rental kendaraan. Kelas ini menambahkan beberapa kendaraan, menyewakannya, dan menampilkan daftar kendaraan serta penyewa.

```java
public class VehicleRentalApplication {
    public static void main(String[] args) {
        Rental rental = new Rental();

        // Menambahkan beberapa kendaraan ke daftar kendaraan yang tersedia
        rental.addVehicle(new Car("Toyota", "Avanza", 2020, 4));
        rental.addVehicle(new Motorcycle("Yamaha", "NMAX", 2021, 2));
        rental.addVehicle(new Bicycle("Polygon", "BMX", 2019, "BMX"));

        // Menampilkan daftar kendaraan yang tersedia
        rental.displayAvailableVehicles();

        // Menyewa kendaraan
        rental.rentVehicle("Andi", new Car("Toyota", "Avanza", 2020, 4));
        rental.rentVehicle("Budi", new Motorcycle("Yamaha", "NMAX", 2021, 2));

        // Menampilkan daftar kendaraan yang tersedia setelah penyewaan
        rental.displayAvailableVehicles();

        // Menampilkan daftar penyewa dan detail kendaraan yang disewa
        rental.displayRenters();
    }
}
```

**Penjelasan:**
- Membuat instance dari `Rental`.
- Menambahkan beberapa kendaraan menggunakan `addVehicle()`.
- Menampilkan daftar kendaraan yang tersedia menggunakan `displayAvailableVehicles()`.
- Melakukan penyewaan kendaraan dengan `rentVehicle()`.
- Menampilkan daftar penyewa dan kendaraan yang disewa menggunakan `displayRenters()`.
