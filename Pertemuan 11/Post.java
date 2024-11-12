import java.util.ArrayList;

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