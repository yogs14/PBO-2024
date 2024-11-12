
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