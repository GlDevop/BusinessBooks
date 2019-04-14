package gabriellee.project.buisnessbooks.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "books")
public class Book {

    @PrimaryKey
    @NonNull
    private String title;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "book_image")
    private String book_image;

    @ColumnInfo(name = "publisher")
    private String publisher;

    @ColumnInfo(name = "rank")
    private int rank;

    @ColumnInfo(name = "timestamp")
    private int timestamp;

    public Book(@NonNull String title, String author, String book_image, String publisher, int rank, int timestamp) {
        this.title = title;
        this.author = author;
        this.book_image = book_image;
        this.publisher = publisher;
        this.rank = rank;
        this.timestamp = timestamp;
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

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", book_image='" + book_image + '\'' +
                ", publisher='" + publisher + '\'' +
                ", rank=" + rank +
                ", timestamp=" + timestamp +
                '}';
    }
}
