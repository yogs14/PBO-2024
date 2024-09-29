# Implementasi Studi Kasus Grouping Object (Music Organizer)

Konsep **grouping objects** dalam pemrograman berorientasi objek (OOP) digunakan untuk mengelompokkan objek-objek yang memiliki hubungan atau karakteristik yang sama ke dalam suatu koleksi, sehingga dapat lebih mudah dikelola dan dimanipulasi. Dalam konteks program `MusicOrganizer`, konsep grouping objects diterapkan melalui penggunaan **ArrayList** untuk mengelompokkan objek-objek `Track`.

### Penjelasan Berdasarkan Konsep Grouping Object

1. **ArrayList sebagai Wadah untuk Mengelompokkan Objek:**
   - Pada program ini, variabel `tracks` dideklarasikan sebagai `ArrayList<Track>`. **ArrayList** adalah salah satu jenis *collection* di Java yang bisa menyimpan sekumpulan objek `Track`. 
   - Setiap objek `Track` merepresentasikan satu lagu yang memiliki properti seperti `title` (judul lagu) dan `artist` (artis lagu). Dengan menggunakan ArrayList, kita dapat mengelompokkan banyak objek `Track` dalam satu koleksi, sehingga kita dapat mengelola mereka secara kolektif.
   
   ```java
   private ArrayList<Track> tracks;
   ```

2. **Menambahkan Objek ke dalam Group (Collection):**
   - Metode `addTrack(Track track)` menambahkan objek `Track` baru ke dalam daftar `tracks`. Ini mencerminkan konsep grouping di mana kita mengelompokkan objek-objek lagu ke dalam satu koleksi sehingga bisa diakses dan diatur secara bersama-sama.
   
   ```java
   public void addTrack(Track track) {
       tracks.add(track); // Menambah track ke dalam group (ArrayList)
   }
   ```

3. **Mengelola dan Mengakses Objek dalam Group:**
   - Metode `listAllTracks()` digunakan untuk mengakses dan menampilkan semua objek `Track` yang sudah dikelompokkan dalam `ArrayList`. Dengan konsep grouping, kita dapat mengelola semua objek `Track` dalam satu waktu, misalnya dengan melakukan *looping* untuk menampilkan detail dari setiap lagu.

   ```java
   public void listAllTracks() {
       for (Track track : tracks) {
           System.out.println(track.getDetails()); // Mengakses setiap Track dalam group
       }
   }
   ```

4. **Menghapus Objek dari Group:**
   - Metode `removeTrack(Track track)` menghapus objek `Track` dari koleksi. Dengan adanya pengelompokan objek dalam ArrayList, kita bisa memodifikasi daftar objek yang dikelompokkan, seperti menghapus objek tertentu.
   
   ```java
   public void removeTrack(Track track) {
       tracks.remove(track); // Menghapus track dari group (ArrayList)
   }
   ```

### Manfaat dari Grouping Objects
- **Kemudahan dalam Pengelolaan:** Dengan mengelompokkan objek, kita dapat mengelola objek-objek tersebut secara bersamaan (misalnya, menambahkan, menampilkan, atau menghapus).
- **Skalabilitas:** Jika ada perubahan dalam jumlah objek (seperti menambah atau menghapus lagu), kita hanya perlu memodifikasi koleksi yang telah dibentuk, tanpa perlu membuat variabel terpisah untuk setiap objek.
- **Reusabilitas:** Setelah objek-objek `Track` dikelompokkan dalam `ArrayList`, kita bisa dengan mudah menggunakan metode seperti `listAllTracks` atau `removeTrack` tanpa perlu menulis ulang logika untuk tiap operasi.
  
### Contoh Implementasi Grouping Object di Program

```java
public void manageTracks() {
    // Menambahkan objek Track ke dalam grup
    addTrack(new Track("Song1", "Artist1"));
    addTrack(new Track("Song2", "Artist2"));
    
    // Menampilkan semua track yang ada di grup
    listAllTracks();
    
    // Menghapus track dari grup
    removeTrack(new Track("Song1", "Artist1"));
    
    // Menampilkan ulang setelah penghapusan
    listAllTracks();
}
```

### Hasil Output
```
Music library loaded. 2 tracks.

Track Listing: 
Song1 by Artist1
Song2 by Artist2

Added a new track: Song3 by Artist3
Track Listing: 
Song1 by Artist1
Song2 by Artist2
Song3 by Artist3

Track removed: Song3 by Artist3
Track Listing:
Song1 by Artist1
Song2 by Artist2

Track not found: NonExistentSong by UnknownArtist
Track Listing:
Song1 by Artist1
Song2 by Artist2
```
