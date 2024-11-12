# Implementasi Network App

### 1. `Post.java` (Kelas Dasar)
```java
public class Post {
    private String username;
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    public Post(String author) {
        username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }

    public void like() {
        likes++;
    }

    public void unlike() {
        if (likes > 0) {
            likes--;
        }
    }

    public void addComment(String text) {
        comments.add(text);
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void display() {
        System.out.println(username);
        System.out.println("Likes: " + likes);
        System.out.println("Comments: ");
        for (String comment : comments) {
            System.out.println(comment);
        }
    }
}
```

Kelas `Post` adalah *superclass* yang mendefinisikan properti umum dari sebuah *post*, seperti `username`, `timestamp`, `likes`, dan `comments`. Metode seperti `like`, `unlike`, `addComment`, dan `display` menyediakan fungsionalitas dasar untuk semua jenis *post*. Kelas ini juga menyediakan konstruktor untuk inisialisasi nilai-nilai dasar seperti `username` dan `timestamp`.

### 2. `MessagePost.java` (Kelas Turunan dari `Post`)
```java
public class MessagePost extends Post {
    private String message;

    public MessagePost(String author, String text) {
        super(author);
        message = text;
    }

    public String getText() {
        return message;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Message: " + message);
    }
}
```

Kelas `MessagePost` memperluas (`extends`) kelas `Post`, sehingga mewarisi semua properti dan metode dari `Post`. Properti `message` ditambahkan untuk menyimpan teks dari pesan. Konstruktor `MessagePost` memanggil `super(author)` untuk menginisialisasi bagian dari `Post` (yaitu, `username`). Metode `display` juga *override* dari `Post`, untuk menampilkan konten tambahan dari `MessagePost`.

### 3. `PhotoPost.java` (Kelas Turunan dari `Post`)
```java
public class PhotoPost extends Post {
    private String filename;
    private String caption;

    public PhotoPost(String author, String filename, String caption) {
        super(author);
        this.filename = filename;
        this.caption = caption;
    }

    public String getImageFile() {
        return filename;
    }

    public String getCaption() {
        return caption;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Image: " + filename);
        System.out.println("Caption: " + caption);
    }
}
```

Kelas `PhotoPost` adalah turunan lain dari `Post`. Properti tambahan `filename` dan `caption` ditambahkan untuk mendefinisikan file gambar dan keterangan gambar. Metode `display` *override* dari `Post` untuk menampilkan gambar dan keterangan khusus dari `PhotoPost`.

### 4. `NewsFeed.java`
```java
import java.util.ArrayList;

public class NewsFeed {
    private ArrayList<Post> posts;

    public NewsFeed() {
        posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void show() {
        for (Post post : posts) {
            post.display();
            System.out.println();
        }
    }
}
```

Kelas `NewsFeed` berfungsi sebagai koleksi dari berbagai jenis *post* (baik `MessagePost` maupun `PhotoPost`). Karena keduanya adalah tipe `Post`, mereka dapat ditambahkan ke dalam `ArrayList<Post>`.
