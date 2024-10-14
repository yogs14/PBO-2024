# Demo & Revisi Implementasi Tech Support System

Berikut adalah penjelasan fitur-fitur baru yang telah ditambahkan dalam implementasi baru:

### 1. **Tokenisasi Input Pengguna**:
   - **Deskripsi**: Input dari pengguna sekarang dipecah menjadi token atau kata-kata terpisah. Ini memungkinkan sistem untuk lebih fleksibel dalam mengenali kata kunci yang relevan, bahkan jika kata kunci tersebut muncul di bagian mana pun dari kalimat pengguna.
   - **Fungsi Baru**: `String[] tokens = input.split("\\s+");`
   - **Manfaat**: Pengguna dapat memasukkan kalimat yang lebih panjang atau kompleks seperti "My network is down", dan sistem tetap dapat mengenali "network" sebagai kata kunci yang relevan untuk memberikan respons yang sesuai.

### 2. **Pencocokan Sinonim**:
   - **Deskripsi**: Sistem sekarang bisa mengenali sinonim dari kata kunci. Misalnya, untuk kata kunci "slow", sinonim seperti "lag", "freezing", atau "unresponsive" juga akan dikenali sebagai masalah yang sama.
   - **Fungsi Baru**: `synonymMap.put("slow", Arrays.asList("lag", "freezing", "unresponsive"));`
   - **Manfaat**: Pengguna tidak perlu menggunakan kata kunci yang tepat. Jika mereka mengatakan "lagging", sistem akan tetap memberikan respons untuk masalah "slow". Ini membuat sistem lebih fleksibel dan intuitif.

### 3. **Koreksi Kesalahan Ejaan (Levenshtein Distance)**:
   - **Deskripsi**: Fitur ini menggunakan algoritma **Levenshtein Distance** untuk menghitung jarak antara dua string dan menangani kesalahan ejaan. Jika pengguna mengetikkan sesuatu dengan salah, seperti "crashh" alih-alih "crash", sistem dapat memperbaikinya secara otomatis dan tetap memberikan respons yang relevan.
   - **Fungsi Baru**: `private static int levenshteinDistance(String a, String b)`
   - **Manfaat**: Membantu menangani input yang memiliki typo kecil, sehingga meningkatkan pengalaman pengguna. Sistem tetap dapat memahami maksud pengguna meskipun ada kesalahan ketik.

### 4. **Pertanyaan Lanjutan (Follow-up Questions)**:
   - **Deskripsi**: Setelah memberikan respons awal, sistem sekarang juga dapat menambahkan pertanyaan lanjutan untuk mengumpulkan informasi lebih detail tentang masalah yang sedang dialami pengguna. Contohnya, jika masalah jaringan terdeteksi, sistem akan menanyakan apakah pengguna bisa mengakses situs web lain.
   - **Fungsi Baru**: `followUpQuestion = generateFollowUpQuestion(keyword);`
   - **Manfaat**: Interaksi menjadi lebih interaktif dan berkelanjutan. Sistem tidak hanya memberikan respons statis, tetapi juga berusaha membantu pengguna lebih lanjut dengan mengajukan pertanyaan terkait.

### 5. **Pemrosesan Kalimat Kompleks**:
   - **Deskripsi**: Dengan adanya tokenisasi dan pencocokan sinonim, sistem sekarang dapat menangani kalimat-kalimat yang lebih kompleks dan tidak harus fokus pada satu kata kunci saja. Ini memungkinkan input seperti "My wifi is slow and my computer crashed" untuk diuraikan, di mana sistem bisa mengenali beberapa masalah sekaligus.
   - **Fungsi Baru**: `for (String token : tokens) {...}`
   - **Manfaat**: Sistem menjadi lebih pintar dalam memahami kalimat yang lebih panjang dan memungkinkan respons yang lebih relevan meskipun ada lebih dari satu masalah yang disebutkan.

### 6. **Respons terhadap Kalimat Tidak Relevan atau Tidak Dikenali**:
   - **Deskripsi**: Sistem sekarang lebih baik dalam memberikan respons jika tidak ada kata kunci atau sinonim yang dikenali. Ia akan memberikan respons default yang ramah, meminta pengguna untuk memberikan lebih banyak detail tentang masalah mereka.
   - **Fungsi Baru**: `return defaultResponse;`
   - **Manfaat**: Pengguna tidak akan mendapatkan respons yang salah atau kosong jika masalah mereka tidak dikenali, tetapi justru diarahkan untuk memberikan klarifikasi lebih lanjut.

### 7. **Manajemen dan Penyimpanan Kata Kunci serta Sinonim yang Lebih Baik**:
   - **Deskripsi**: Kata kunci dan sinonim sekarang disimpan dalam `Map` yang terpisah, yaitu `responseMap` dan `synonymMap`, untuk memudahkan pengelolaan dan pemeliharaan sistem.
   - **Fungsi Baru**: 
     ```java
     private static Map<String, String> responseMap = new HashMap<>();
     private static Map<String, List<String>> synonymMap = new HashMap<>();
     ```
   - **Manfaat**: Ini mempermudah pengembang untuk menambahkan, mengubah, atau menghapus kata kunci serta sinonim tanpa harus mengubah banyak kode. Sistem menjadi lebih mudah di-update untuk menambah berbagai masalah baru yang bisa dikenali.

### 8. **Penghentian Interaksi yang Lebih Fleksibel**:
   - **Deskripsi**: Sistem sekarang dapat mengenali lebih banyak variasi untuk perintah keluar seperti "quit" dan "exit", sehingga pengguna dapat menghentikan interaksi dengan lebih nyaman.
   - **Fungsi Lama dan Baru**: `if (input.equals("quit") || input.equals("exit"))`
   - **Manfaat**: Pengguna memiliki lebih banyak fleksibilitas dalam cara mereka ingin mengakhiri percakapan.

### Demo

https://github.com/user-attachments/assets/835bea9e-99e7-46c6-b212-f8b4fdc98b1a


