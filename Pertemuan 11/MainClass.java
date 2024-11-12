public class MainClass {
    public static void main(String[] args) {
        NewsFeed feed = new NewsFeed();

        MessagePost message1 = new MessagePost("Alice", "Hello everyone!");
        PhotoPost photo1 = new PhotoPost("Bob", "vacation.jpg", "Having fun at the beach!");

        message1.like();
        photo1.like();
        photo1.like();

        message1.addComment("Nice message!");
        photo1.addComment("Great photo!");

        feed.addPost(message1);
        feed.addPost(photo1);

        feed.show();
    }
}