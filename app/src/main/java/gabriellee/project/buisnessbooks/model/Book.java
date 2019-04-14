package gabriellee.project.buisnessbooks.model;

public class Book {

    private int rank;

    private String author;

    private String title;

    private String book_image;

    private String publisher;

    public Book(int rank, String author, String title, String book_image, String publisher) {
        this.rank = rank;
        this.author = author;
        this.title = title;
        this.book_image = book_image;
        this.publisher = publisher;
    }

    public Book() {
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "rank=" + rank +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", book_image='" + book_image + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
